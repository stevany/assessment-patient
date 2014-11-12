package com.rscharitas.dataPP.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
    @Id
    @Column(length=50, nullable=false, unique=true)
    @Size(max=50, min=1)
    private String authority;

    public Role() {

    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}