package com.rscharitas.dataPP.entity.enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/4/13
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */
public enum VaksinDasar {
    BC(0,"BCG"),DP(1,"DPT"),CM(2,"Campak"),PO(3,"Polio"),HP(4,"Hepatitis B");
    private int vaksindasar;
    private String label;

    private VaksinDasar(int vaksindasar, String label) {
        this.vaksindasar = vaksindasar;
        this.label = label;
    }

    public int getVaksindasar() {
        return vaksindasar;
    }

    public String getLabel() {
        return label;
    }
}
