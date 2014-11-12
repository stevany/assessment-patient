package com.rscharitas.dataPP.controller;

import com.rscharitas.dataPP.entity.Role;
import com.rscharitas.dataPP.entity.dto.SimpleUser;
import com.rscharitas.dataPP.entity.Stdfield;
import com.rscharitas.dataPP.entity.User;
import com.rscharitas.dataPP.service.RoleService;
import com.rscharitas.dataPP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/userForm")
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    Integer userId;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[]{"id"});

    }

    @InitBinder
    public void initRoleBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Stdfield.class, new RolePropertyEditor(this.roleService));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(ModelMap model, Principal currentUser) {
        model.addAttribute("user", new SimpleUser());
        model.addAttribute("namaUser", currentUser.getName());
        model.addAttribute("getUsers", userService.findAll());
        userId = null;
        return "userForm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Integer id, ModelMap model, Principal currentUser) {
        User user = userService.findById(id);
        SimpleUser simpleUser = new SimpleUser();
        simpleUser.cloneValueFrom(user);
        model.addAttribute("user", simpleUser);
        model.addAttribute("namaUser", currentUser.getName());
        userId = id;
        return "userForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(SimpleUser user, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            return "redirect:/userForm";
        }  else{
            String salt = new String(Hex.encode(user.getPassword().getBytes()));
            user.setSalt(salt);
            user.setPassword(passwordEncoder.encodePassword(user.getPassword(), salt));
            User userForm = userService.save(user);
            model.addAttribute("user", userForm);
            status.setComplete();
            return "redirect:/userForm/" + user.getId();
        }

    }

    @ModelAttribute("roleList")
    public List<Role> loadRole() {
        return roleService.findAll();
    }

    static class RolePropertyEditor extends PropertyEditorSupport {
        private RoleService role;

        public RolePropertyEditor(RoleService roleService) {
            super();
            this.role = roleService;
        }

        @Override
        public String getAsText() {
            Role value = (Role) getValue();
            return (value != null ? value.getAuthority().toString() : "");    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void setAsText(String s) throws IllegalArgumentException {
            Integer id = Integer.valueOf(s);
            setValue(this.role.findByAuthority(s));

        }

    }
}



