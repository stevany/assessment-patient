package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.Role;
import com.rscharitas.dataPP.repository.RoleRepository;
import com.rscharitas.dataPP.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleRepository.findOne(authority);
    }
}
