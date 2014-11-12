package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.Role;
import com.rscharitas.dataPP.entity.dto.SimpleUser;
import com.rscharitas.dataPP.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/26/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    void save(User user);
    User save(SimpleUser simpleUser);
    User update(Integer id, SimpleUser simpleUser);
    List<User> findAll();
    List<User> findByRole(Role role);
    void delete(User user);
    void delete(Integer id);
    User findById(Integer id);
    User findByUsername(String username);

}
