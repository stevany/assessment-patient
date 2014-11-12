package com.rscharitas.dataPP.entity.enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/4/13
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Implant {
    TD(0,"Tidak ada"),AB(1,"Alat bantu dengar"),KG(2,"Kawat Gigi"),KC(3,"Kacamata/lensa kontak"),IM(4,"Implant");
    private int implant;
    private String label;

    private Implant(int implant, String label) {
        this.implant = implant;
        this.label = label;
    }

    public int getImplant() {
        return implant;
    }

    public String getLabel() {
        return label;
    }
}
