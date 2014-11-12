package com.rscharitas.dataPP.controller;


import com.rscharitas.dataPP.entity.ObatRutin;
import com.rscharitas.dataPP.service.DataPasienService;
import com.rscharitas.dataPP.service.ObatRutinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/25/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/pasienForm/obat")
@SessionAttributes("obatRutin")
public class ObatController {
    @Autowired
    private ObatRutinService orService;

    private Integer idPasien;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[]{"id"});
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ObatRutin setUpForm(@RequestParam(value = "idPasien", required = false) Integer id, ModelMap model) {
        if (id == null) {
           return null;
        } else {
            model.addAttribute("idPasien", id);
            idPasien = id;
            return new ObatRutin();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(ObatRutin obatRutin, BindingResult bindingResult, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "redirect:pasienForm/obat?idPasien=3";
        } else {
            orService.save(obatRutin, idPasien);
            return "redirect:/pasienForm/obat";
        }

    }


}
