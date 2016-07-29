package de.fzi.power.profilingimport;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.UnitFormat;

public class NonSILabels {
    private NonSILabels() {};
    
    public static void init() {
        UnitFormat format = UnitFormat.getInstance();
        format.label(NonSI.BYTE, "B");
        format.label(SI.KILO(NonSI.BYTE), "kB");
        format.label(SI.MEGA(NonSI.BYTE), "MB");
        format.label(SI.GIGA(NonSI.BYTE), "GB");
        format.label(SI.TERA(NonSI.BYTE), "TB");
        format.label(SI.PETA(NonSI.BYTE), "PB");
    }
}