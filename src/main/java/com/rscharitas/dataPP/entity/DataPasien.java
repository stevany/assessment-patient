package com.rscharitas.dataPP.entity;


import javax.persistence.*;


import java.util.Date;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/17/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "data_pasien")
public class DataPasien implements Cloneable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl")
    private Date tgl;

    @Column(name = "nama_lengkap", length = 100)
    private String namaLengkap;

    @Column(name = "nama_panggilan", length = 50)
    private String namaPanggilan;

    @Column(name = "jalan", length = 100)
    private String jalan;

    @Column(name = "kelurahan", length = 30)
    private String kelurahan;

    @Column(name = "kota", length = 20)
    private String kota;

    @Column(name = "kodepos", length = 7)
    private String kodePos;

    @Column(name = "telepon", length = 11)
    private String telepon;

    @Column(name = "hp", length = 12)
    private String hp;

    @Column(name = "tmplahir", length = 20)
    private String tmpLahir;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir")
    private Date tglLahir;

    @Column(name = "jk", length = 2)
    private String jk;

    @Column(name = "stkawin")
    private Boolean stKawin;

    @Column(name = "kwn", length = 2)
    private String kwn;

    @Column(name = "agama", length = 2)
    private String agama;

    @Column(name = "pekerjaan", length = 2)
    private String pekerjaan;

    @Column(name = "pendidikan", length = 2)
    private String pendidikan;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "nama_d", length = 100)
    private String namaDarurat;

    @Column(name = "jalan_d", length = 100)
    private String jalanDarurat;

    @Column(name = "keluarahan_d", length = 30)
    private String kelurahanDarurat;

    @Column(name = "kota_d", length = 20)
    private String kotaDarurat;

    @Column(name = "kodepos_d", length = 7)
    private String kodePosDarurat;

    @Column(name = "telepon_d", length = 7)
    private String teleponDarurat;

    @Column(name = "hp_d", length = 12)
    private String hpDarurat;

    @Column(name = "hubungan", length = 2)
    private String hubungan;

    @Column(name = "jk_d", length = 2)
    private String jkDarurat;

    @Column(name = "pekerjaan_d", length = 2)
    private String pekerjaanDarurat;

    @Column(name = "cara_bayar", length = 2)
    private String caraBayar;

    @Column(name = "tinggal", length = 2)
    private String tinggal;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "data_alatbantu", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "idField")})
    private Set<Stdfield> alatBantu;

    @Column(name = "keluhan", length = 200)
    private String keluhan;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "data_riwayatpenyakit",joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "idField")} )
    private Set<Stdfield> riwayatPenyakit;

    @Column(name = "riwayat_bedah_anestesi", length = 200)
    private String riwayatBA;

    @OneToMany(mappedBy = "idPasien", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<ObatRutin> obatRutin;

    @Column(name="riwayat_penyakit_keluarga", length = 200)
    private String riwayatPK;

    @Column(name = "riwayat_alergiy")
    private Boolean riwayatAlergiY;

    @Column(name="riwayat_alergit")
    private Boolean riwayatAlergiT;

    @Column(name = "ketriwayat_alergi", length = 200)
    private String ketRiwayatAlergi;

    @Column(name = "riwayat_hamil", length = 2)
    private String riwayatHamil;

    @Column(name = "riwayat_lahir", length = 2)
    private String riwayatLahir;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "data_rvdasar",joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "idField")} )
    private Set<Stdfield> rvDasar;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "data_rvlanjut",joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "idField")} )
    private Set<Stdfield> rvLanjut;

    @Column(name = "rokok")
    private boolean rokok;

    @Column(name = "ketRokok", length = 2)
    private Integer ketRokok;

    @Column(name = "alkohol")
    private boolean alkohol;

    @Column(name = "ketAlkohol", length = 2)
    private Integer ketAlkohol;

    @Column(name = "narkotika")
    private boolean narkotika;

    @Column(name = "olahraga")
    private boolean olahraga;

    @Column(name = "psikologis_y")
    private boolean psikologisY;

    @Column(name="psikologis_t")
    private boolean psikologisT;

    @Column(name="usrUpdate")
    private String userUpdate;

    @Column(name="lastUpdate")
    private Date lastUpdate;

    public boolean isNew() {
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNamaPanggilan() {
        return namaPanggilan;
    }

    public void setNamaPanggilan(String namaPanggilan) {
        this.namaPanggilan = namaPanggilan;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getTmpLahir() {
        return tmpLahir;
    }

    public void setTmpLahir(String tmpLahir) {
        this.tmpLahir = tmpLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public Boolean getStKawin() {
        return stKawin;
    }

    public void setStKawin(Boolean stKawin) {
        this.stKawin = stKawin;
    }

    public String getKwn() {
        return kwn;
    }

    public void setKwn(String kwn) {
        this.kwn = kwn;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaDarurat() {
        return namaDarurat;
    }

    public void setNamaDarurat(String namaDarurat) {
        this.namaDarurat = namaDarurat;
    }

    public String getJalanDarurat() {
        return jalanDarurat;
    }

    public void setJalanDarurat(String jalanDarurat) {
        this.jalanDarurat = jalanDarurat;
    }

    public String getKelurahanDarurat() {
        return kelurahanDarurat;
    }

    public void setKelurahanDarurat(String kelurahanDarurat) {
        this.kelurahanDarurat = kelurahanDarurat;
    }

    public String getKotaDarurat() {
        return kotaDarurat;
    }

    public void setKotaDarurat(String kotaDarurat) {
        this.kotaDarurat = kotaDarurat;
    }

    public String getKodePosDarurat() {
        return kodePosDarurat;
    }

    public void setKodePosDarurat(String kodePosDarurat) {
        this.kodePosDarurat = kodePosDarurat;
    }

    public String getTeleponDarurat() {
        return teleponDarurat;
    }

    public void setTeleponDarurat(String teleponDarurat) {
        this.teleponDarurat = teleponDarurat;
    }

    public String getHpDarurat() {
        return hpDarurat;
    }

    public void setHpDarurat(String hpDarurat) {
        this.hpDarurat = hpDarurat;
    }

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
    }

    public String getJkDarurat() {
        return jkDarurat;
    }

    public void setJkDarurat(String jkDarurat) {
        this.jkDarurat = jkDarurat;
    }

    public String getPekerjaanDarurat() {
        return pekerjaanDarurat;
    }

    public void setPekerjaanDarurat(String pekerjaanDarurat) {
        this.pekerjaanDarurat = pekerjaanDarurat;
    }

    public String getCaraBayar() {
        return caraBayar;
    }

    public void setCaraBayar(String caraBayar) {
        this.caraBayar = caraBayar;
    }

    public String getTinggal() {
        return tinggal;
    }

    public void setTinggal(String tinggal) {
        this.tinggal = tinggal;
    }

    public Set<Stdfield> getAlatBantu() {
        return alatBantu;
    }

    public void setAlatBantu(Set<Stdfield> alatBantu) {
        this.alatBantu = alatBantu;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public Set<Stdfield> getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setRiwayatPenyakit(Set<Stdfield> riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public String getRiwayatBA() {
        return riwayatBA;
    }

    public void setRiwayatBA(String riwayatBA) {
        this.riwayatBA = riwayatBA;
    }

    public Set<ObatRutin> getObatRutin() {
        return obatRutin;
    }

    public void setObatRutin(Set<ObatRutin> obatRutin) {
        this.obatRutin = obatRutin;
    }

    public String getRiwayatPK() {
        return riwayatPK;
    }

    public void setRiwayatPK(String riwayatPK) {
        this.riwayatPK = riwayatPK;
    }

    public Boolean getRiwayatAlergiY() {
        return riwayatAlergiY;
    }

    public void setRiwayatAlergiY(Boolean riwayatAlergiY) {
        this.riwayatAlergiY = riwayatAlergiY;
    }

    public Boolean getRiwayatAlergiT() {
        return riwayatAlergiT;
    }

    public void setRiwayatAlergiT(Boolean riwayatAlergiT) {
        this.riwayatAlergiT = riwayatAlergiT;
    }

    public String getKetRiwayatAlergi() {
        return ketRiwayatAlergi;
    }

    public void setKetRiwayatAlergi(String ketRiwayatAlergi) {
        this.ketRiwayatAlergi = ketRiwayatAlergi;
    }

    public String getRiwayatHamil() {
        return riwayatHamil;
    }

    public void setRiwayatHamil(String riwayatHamil) {
        this.riwayatHamil = riwayatHamil;
    }

    public String getRiwayatLahir() {
        return riwayatLahir;
    }

    public void setRiwayatLahir(String riwayatLahir) {
        this.riwayatLahir = riwayatLahir;
    }

    public Set<Stdfield> getRvDasar() {
        return rvDasar;
    }

    public void setRvDasar(Set<Stdfield> rvDasar) {
        this.rvDasar = rvDasar;
    }

    public Set<Stdfield> getRvLanjut() {
        return rvLanjut;
    }

    public void setRvLanjut(Set<Stdfield> rvLanjut) {
        this.rvLanjut = rvLanjut;
    }

    public boolean isRokok() {
        return rokok;
    }

    public void setRokok(boolean rokok) {
        this.rokok = rokok;
    }

    public Integer getKetRokok() {
        return ketRokok;
    }

    public void setKetRokok(Integer ketRokok) {
        this.ketRokok = ketRokok;
    }

    public boolean isAlkohol() {
        return alkohol;
    }

    public void setAlkohol(boolean alkohol) {
        this.alkohol = alkohol;
    }

    public Integer getKetAlkohol() {
        return ketAlkohol;
    }

    public void setKetAlkohol(Integer ketAlkohol) {
        this.ketAlkohol = ketAlkohol;
    }

    public boolean isNarkotika() {
        return narkotika;
    }

    public void setNarkotika(boolean narkotika) {
        this.narkotika = narkotika;
    }

    public boolean isOlahraga() {
        return olahraga;
    }

    public void setOlahraga(boolean olahraga) {
        this.olahraga = olahraga;
    }

    public boolean isPsikologisY() {
        return psikologisY;
    }

    public void setPsikologisY(boolean psikologisY) {
        this.psikologisY = psikologisY;
    }

    public boolean isPsikologisT() {
        return psikologisT;
    }

    public void setPsikologisT(boolean psikologisT) {
        this.psikologisT = psikologisT;
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

    public static DataPasien clone(DataPasien dataPasien){
        try {
            return(DataPasien)dataPasien.clone();
        } catch (CloneNotSupportedException e) {

        }
        return null;
    }
}
