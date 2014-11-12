package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.Role;
import com.rscharitas.dataPP.entity.dto.SimpleUser;
import com.rscharitas.dataPP.entity.User;
import com.rscharitas.dataPP.repository.UserRepository;
import com.rscharitas.dataPP.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {

    }

    @Override
    public User save(SimpleUser simpleUser) {
        User user = simpleUser.cloneTo();
        return userRepository.saveAndFlush(user);
    }


    public User update(Integer id, User user) {
        User oldUser = findById(id);
        oldUser.setAccountNonExpired(user.isAccountNonExpired());
        oldUser.setEnabled(user.isEnabled());
        oldUser.setAccountNonLocked(user.isAccountNonLocked());
        oldUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
        oldUser.setAuthorities(user.getAuthorities());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setSalt(user.getSalt());
       return  userRepository.saveAndFlush(oldUser);
    }

    @Override
    public User update(Integer id, SimpleUser simpleUser) {
        User user = simpleUser.cloneTo();
        return update(id, user);

    }

    @Override
    public List<User> findAll() {
        List<User> results = userRepository.findAll();
        initialize(results);
        return results;
    }

    @Override
    public List<User> findByRole(Role role) {
        return null;
    }


    @Override
    public void delete(User user) {
       userRepository.delete(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    protected void initialize(User user) {
        Hibernate.initialize(user.getAuthorities());
    }

    protected void initialize(Collection<User> users) {
        for (User user : users) {
            initialize(user);
        }
    }
}
