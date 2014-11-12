package com.rscharitas.dataPP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller

public class AccessController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /** Login form with error. */
    @RequestMapping("/login-error")
    public String loginError(ModelMap model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
