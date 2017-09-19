package de.fzi.power.profilingimport.editor.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.Repository.RepositoryFactory;
import org.palladiosimulator.edp2.ui.wizards.datasource.DiscoverLocalDirectoryPage;
import org.palladiosimulator.edp2.ui.wizards.datasource.SelectDataSourceTypePage;

import de.fzi.power.profilingimport.Edp2Importer;
import de.fzi.power.profilingimport.mapping.MappingRepository;

public class ImportWizard extends Wizard {
    
    private SelectDataSourceTypePage dataSourceTypePage;
    private DiscoverLocalDirectoryPage discoverLocalDirectoryPage;
    private Edp2Importer importer;

    public ImportWizard(MappingRepository mappingRepo) {
        this.importer = new Edp2Importer(mappingRepo);
        this.dataSourceTypePage = new SelectDataSourceTypePage();
        this.addPage(dataSourceTypePage);
        this.discoverLocalDirectoryPage = new DiscoverLocalDirectoryPage();
        this.addPage(discoverLocalDirectoryPage);
    }

    @Override
    public boolean performFinish() {
        try {
            getContainer().run(true, true, new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor) {
                    if (dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
                        final Repository repo = discoverLocalDirectoryPage.getRepositoryOnFinish();
                        importResults(repo);
                    } else if (dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
                        final Repository repo = RepositoryFactory.eINSTANCE.createLocalMemoryRepository();
                        importResults(repo);
                    } else {
                        // This line should never be reached.
                        assert(false);
                        return;
                    }
                }
            });
            return true;
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    private void importResults(final Repository repo) {
        try {
            importer.importResults(repo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        if (page == this.dataSourceTypePage) {
            if (this.dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
                return this.discoverLocalDirectoryPage;
            } else if (this.dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
                //return this.discoverLocalMemoryPage;
                return null;
            } else {
                // This line should never be reached. Otherwise there likely are unaccounted data
                // source types.
                assert (false);
            }
        }
        return null;
    }
    
    @Override
    public boolean canFinish() {
        boolean canFinish = false;
        if(this.dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
            canFinish = true;
        } else if(this.dataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
            canFinish = this.discoverLocalDirectoryPage.getRepositoryOnFinish() != null;
        }
        return canFinish;
    }

}
