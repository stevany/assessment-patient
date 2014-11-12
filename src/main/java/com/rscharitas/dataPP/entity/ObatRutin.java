package com.rscharitas.dataPP.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/17/13
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class ObatRutin {
    @Id
    @GeneratedValue
    @Column(name="obat_id")
    private Integer idObat;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pasien_id")
    private DataPasien idPasien;

    @Column(name="jenis_obat", length = 100)
    private String jenisObat;

    @Column(name="frekuensi", length = 20)
    private String frekuensi;

    @Column(name="dosis", length = 20)
    private String dosis;

    @Column(name="user_update", length = 30)
    private String userUpdate;

    @Column(name="last_update")
    private Date lastUpdate;
    public Integer getIdObat() {
        return idObat;
    }

    public void setIdObat(Integer idObat) {
        this.idObat = idObat;
    }

    public DataPasien getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(DataPasien idPasien) {
        this.idPasien = idPasien;
    }

    public String getJenisObat() {
        return jenisObat;
    }

    public void setJenisObat(String jenisObat) {
        this.jenisObat = jenisObat;
    }

    public String getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(String frekuensi) {
        this.frekuensi = frekuensi;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
