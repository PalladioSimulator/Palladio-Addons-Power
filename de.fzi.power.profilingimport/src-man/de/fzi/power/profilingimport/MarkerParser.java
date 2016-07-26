package de.fzi.power.profilingimport;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

import de.fzi.power.profilingimport.mapping.MarkerLog;

public class MarkerParser {

    private CSVParser markerParser;
    private PeekingIterator<CSVRecord> markerParserIt;
    private CSVRecord curRecord;

    public MarkerParser(final MarkerLog markerLog) throws IOException {
        this.markerParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new FileReader(markerLog.getCsvFileUri()));
        this.markerParserIt = Iterators.peekingIterator(markerParser.iterator());
        curRecord = markerParserIt.next();
    }
    
    public boolean hasNext() {
        return markerParserIt.hasNext();
    }
    
    public void step() {
        curRecord = markerParserIt.next();
    }
    
    public void moveToEnd() {
        CSVRecord tmpRecord = null;
        while(markerParserIt.hasNext()) {
            if(!markerParserIt.peek().get(Constants.VALUE_LABEL).equals(curRecord.get(Constants.VALUE_LABEL))) {
                break;
            }
            tmpRecord = markerParserIt.next();
        }
        if(tmpRecord != null) {
            this.curRecord = tmpRecord;
        }
    }
    
    public long getCurTimeStamp() {
        return Long.parseLong(curRecord.get(Constants.TIME_LABEL));
    }
    
    public String getCurLabel() {
        return curRecord.get(Constants.VALUE_LABEL);
    }

}
