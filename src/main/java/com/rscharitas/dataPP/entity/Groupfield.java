package com.rscharitas.dataPP.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/30/13
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="groupfield")
public class Groupfield {
    @Id
    @Column(name="kode", length=3)
    private String kodeGroup;
    @Column(name="nama", length = 30)
    private String namaGroup;

    @Column(name="user_update", length = 30)
    private String userUpdate;

    @Column(name="last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "kdField",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Stdfield> stdfieldSet;

    public String getKodeGroup() {
        return kodeGroup;
    }

    public void setKodeGroup(String kodeGroup) {
        this.kodeGroup = kodeGroup;
    }

    public String getNamaGroup() {
        return namaGroup;
    }

    public void setNamaGroup(String namaGroup) {
        this.namaGroup = namaGroup;
    }

    public Set<Stdfield> getStdfieldSet() {
        return stdfieldSet;
    }

    public void setStdfieldSet(Set<Stdfield> stdfieldSet) {
        this.stdfieldSet = stdfieldSet;
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
