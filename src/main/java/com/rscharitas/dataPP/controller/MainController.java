package com.rscharitas.dataPP.controller;

import com.rscharitas.dataPP.entity.Groupfield;
import com.rscharitas.dataPP.service.DataPasienService;
import com.rscharitas.dataPP.service.GroupFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 6/28/13
 * Time: 7:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private GroupFieldService groupService;
    @Autowired
    private DataPasienService dataPasienService;

    @RequestMapping( method = RequestMethod.GET)
    public String home(ModelMap modelMap, Principal currentUser){
        modelMap.addAttribute("currUser",currentUser.getName());
        return "home";
    }

    @RequestMapping(value="/intro", method = RequestMethod.GET)
    public String intro(ModelMap modelMap){
        return "intro";
    }
    @RequestMapping(value="/pasienList", method = RequestMethod.GET)
    public String form(ModelMap modelMap){
        return "pasienList";

    }
    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String getData(@RequestParam("namaLgkp") String namaLengkap,@RequestParam("from") Date from, @RequestParam("to")Date to, ModelMap modelMap){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String frm = sdf.format(from);
        String t=sdf.format(to);
        if(namaLengkap==null){
            modelMap.addAttribute("listData", dataPasienService.getTgl(frm,t));

        }else{
            modelMap.addAttribute("listData", dataPasienService.findByNamaLengkap(namaLengkap));
        }

        return "pasienList";
    }

    @RequestMapping("/stdfieldList")
    @ModelAttribute("groupfields")
    public List<Groupfield> getGroup(){
        return  groupService.findAll();
    }
}
