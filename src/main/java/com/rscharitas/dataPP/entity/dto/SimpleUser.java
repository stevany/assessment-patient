package com.rscharitas.dataPP.entity.dto;

import com.rscharitas.dataPP.entity.Role;
import com.rscharitas.dataPP.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleUser {

    private Integer id;
    private String username;
    private String salt;
    private String password;
    private boolean enabled;
    private String[] authorities;

    public void cloneValueFrom(User user){
        this.id=user.getId();
        this.username=user.getUsername();
        this.enabled=user.isEnabled();
        if(user.getAuthorities()!=null){
            this.authorities=new String[user.getAuthorities().size()];
            int i=0;
            for(Role role:user.getAuthorities()){
                this.authorities[i]=role.getAuthority();
                i++;
            }
        }
    }
    public User cloneTo(){
        User user=new User();
        user.setId(this.getId());
        user.setUsername(this.getUsername());
        user.setPassword(this.password);
        user.setSalt(this.salt);
        user.setEnabled(this.isEnabled());
        Set<Role> roleSet= new HashSet<Role>();
        for(String authority:this.authorities){
            Role role=new Role();
            role.setAuthority(authority);
            roleSet.add(role);
        }
        user.setAuthorities(roleSet);
        return user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }


}
