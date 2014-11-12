package com.rscharitas.dataPP.entity.enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/4/13
 * Time: 8:20 AM
 * To change this template use File | Settings | File Templates.
 */
public enum VaksinLanjut {
    HI(0,"HIB"),MMR(1,"MMR"),IN(2,"Influenza"),PN(3,"Pneumokokus"),MN(4,"Menigitis"),RT(5,"Rotavirus"),CA(6,"Cacar Air"),TY(7,"Typhoid"),CS(8,"Ca servix"),HE(9,"Hepatitis A"),HB(10,"Hepatitis B dewasa"),TD(11,"Tetanus dewasa"),PD(12,"Polio dewasa");
    private int vaksinlanjut;
    private String label;

    private VaksinLanjut(int vaksinlanjut, String label) {
        this.vaksinlanjut = vaksinlanjut;
        this.label = label;
    }

    public int getVaksinlanjut() {
        return vaksinlanjut;
    }

    public String getLabel() {
        return label;
    }
}
