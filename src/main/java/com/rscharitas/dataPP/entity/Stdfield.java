package com.rscharitas.dataPP.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/15/13
 * Time: 8:09 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Stdfield {
    @Id
    @GeneratedValue
    private Integer idField;

    private String kdUser;
    private String nmKdUser;
    private String userUpdate;
    private Date lastUpdate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="group_field")
    private Groupfield kdField;

    public Integer getIdField() {
        return idField;
    }

    public void setIdField(Integer id) {
        this.idField = idField;
    }

    public Groupfield getKdField() {
        return kdField;
    }

    public void setKdField(Groupfield kdField) {
        this.kdField = kdField;
    }

    public String getKdUser() {
        return kdUser;
    }

    public void setKdUser(String kdUser) {
        this.kdUser = kdUser;
    }

    public String getNmKdUser() {
        return nmKdUser;
    }

    public void setNmKdUser(String nmKdUser) {
        this.nmKdUser = nmKdUser;
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
