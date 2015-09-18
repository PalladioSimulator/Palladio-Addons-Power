/**
 */
package de.fzi.power.specification.tests;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.SpecificationFactory;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.util.SpecificationResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> A sample utility for the '<em><b>specification</b></em>' package. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class SpecificationExample {
    /**
     * <!-- begin-user-doc --> Load all the argument file paths or URIs as instances of the model.
     * <!-- end-user-doc -->
     * 
     * @param args
     *            the file paths or URIs.
     * @generated
     */
    public static void main(final String[] args) {
        // Create a resource set to hold the resources.
        //
        final ResourceSet resourceSet = new ResourceSetImpl();

        // Register the appropriate resource factory to handle all file extensions.
        //
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new SpecificationResourceFactoryImpl());

        // Register the package to ensure it is available during loading.
        //
        resourceSet.getPackageRegistry().put(SpecificationPackage.eNS_URI, SpecificationPackage.eINSTANCE);

        // If there are no arguments, emit an appropriate usage message.
        //
        if (args.length == 0) {
            System.out.println("Enter a list of file paths or URIs that have content like this:");
            try {
                final Resource resource = resourceSet.createResource(URI.createURI("http:///My.spec"));
                final PowerModelRepository root = SpecificationFactory.eINSTANCE.createPowerModelRepository();
                resource.getContents().add(root);
                resource.save(System.out, null);
            } catch (final IOException exception) {
                exception.printStackTrace();
            }
        } else {
            // Iterate over all the arguments.
            //
            for (final String arg : args) {
                // Construct the URI for the instance file.
                // The argument is treated as a file path only if it denotes an existing file.
                // Otherwise, it's directly treated as a URL.
                //
                final File file = new File(arg);
                final URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath()) : URI.createURI(arg);

                try {
                    // Demand load resource for this file.
                    //
                    final Resource resource = resourceSet.getResource(uri, true);
                    System.out.println("Loaded " + uri);

                    // Validate the contents of the loaded resource.
                    //
                    for (final EObject eObject : resource.getContents()) {
                        final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
                        if (diagnostic.getSeverity() != Diagnostic.OK) {
                            printDiagnostic(diagnostic, "");
                        }
                    }
                } catch (final RuntimeException exception) {
                    System.out.println("Problem loading " + uri);
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * <!-- begin-user-doc --> Prints diagnostics with indentation. <!-- end-user-doc -->
     * 
     * @param diagnostic
     *            the diagnostic to print.
     * @param indent
     *            the indentation for printing.
     * @generated
     */
    protected static void printDiagnostic(final Diagnostic diagnostic, final String indent) {
        System.out.print(indent);
        System.out.println(diagnostic.getMessage());
        for (final Diagnostic child : diagnostic.getChildren()) {
            printDiagnostic(child, indent + "  ");
        }
    }

} // SpecificationExample
