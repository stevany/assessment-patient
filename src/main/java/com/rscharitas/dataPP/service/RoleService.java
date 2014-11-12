package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoleService {
    void save(Role role);
    List<Role> findAll();
    Role findByAuthority(String authority);

}
