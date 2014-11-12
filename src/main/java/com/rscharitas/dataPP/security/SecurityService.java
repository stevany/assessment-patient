package com.rscharitas.dataPP.security;

import com.rscharitas.dataPP.entity.User;
import com.rscharitas.dataPP.repository.UserRepository;
import com.rscharitas.dataPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Service(value="securityService")
public class SecurityService implements UserDetailsService{
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            UserDetails o = userService.findByUsername(s);
            if(o!=null){
                return o;

            }   else{
                throw new UsernameNotFoundException("user not found");
            }
        }catch(Exception x){
            throw new UsernameNotFoundException(x.getMessage());
        }

    }
}
