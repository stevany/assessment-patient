package com.rscharitas.dataPP.entity.enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/4/13
 * Time: 7:50 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Penyakit {
    DM(0,"DM"), HP(1,"Hepatitis"),ST(2,"Stroke"),GJ(3,"Ginjal"),HI(4,"Hipertensi"),JT(5,"Jantung"),TBC(6,"TBC"),KG(7,"Keganasan"),AS(8,"Asma"),L(9,"Lain-Lain");

    private int penyakit;
    private String label;

    private Penyakit(int penyakit, String label) {
        this.penyakit = penyakit;
        this.label = label;
    }

    public int getPenyakit() {
        return penyakit;
    }

    public String getLabel() {
        return label;
    }
}
