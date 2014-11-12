package com.rscharitas.dataPP.repository;

import com.rscharitas.dataPP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
