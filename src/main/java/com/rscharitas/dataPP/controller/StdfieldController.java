package com.rscharitas.dataPP.controller;

import com.rscharitas.dataPP.entity.Groupfield;
import com.rscharitas.dataPP.entity.Stdfield;
import com.rscharitas.dataPP.service.GroupFieldService;
import com.rscharitas.dataPP.service.StdFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/31/13
 * Time: 7:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/stdfieldForm")
@SessionAttributes({"groupfield", "stdfield"})
public class StdfieldController {
    @Autowired
    private GroupFieldService groupService;
    @Autowired
    private StdFieldService stdService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[]{"id"});
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(ModelMap model, Principal currentUser) {
        model.addAttribute("groupfield", new Groupfield());
        model.addAttribute("stdfield", new Stdfield());
        model.addAttribute("currUser", currentUser.getName());

        return "stdfieldForm";
    }

    @RequestMapping(value = "/{kodeGroup}", method = RequestMethod.GET)
    public String getGroup(@PathVariable String kodeGroup, ModelMap model, Principal currentUser) {
        Groupfield groupfield = groupService.findBykode(kodeGroup);
        model.addAttribute("groupfield", groupfield);
        model.addAttribute("stdfield", new Stdfield());
        model.addAttribute("liststdField", groupfield.getStdfieldSet());
        model.addAttribute("currUser", currentUser.getName());
        return "stdfieldForm";
    }

    @RequestMapping(value = "/{kodeGroup}/{idField}", method = RequestMethod.GET)
    public String getStdField(@PathVariable("kodeGroup") String kodeGroup, @PathVariable("idField") Integer idField, ModelMap model, Principal currentUser) {
        Stdfield stdfield = stdService.findById(idField);
        Groupfield group = groupService.findBykode(kodeGroup);

        model.addAttribute("groupfield", group);
        model.addAttribute("stdfield", stdfield);
        model.addAttribute("liststdField", group.getStdfieldSet());
        model.addAttribute("currUser", currentUser.getName());
        return "stdfieldForm";

    }

    @RequestMapping(params = "create", method = RequestMethod.POST)
    public String editGroupField(Groupfield group, BindingResult result, SessionStatus status, Principal currentUser) {
        if (result.hasErrors()) {
            return "redirect:/stdfieldForm";
        } else {
            group.setUserUpdate(currentUser.getName());
            group.setLastUpdate(new Date(System.currentTimeMillis()));
            groupService.save(group);
            status.setComplete();
            return "redirect:/stdfieldForm/" + group.getKodeGroup();
        }
    }

    @RequestMapping(params = "addRow", method = RequestMethod.POST)
    public String editStdField(Groupfield group, Stdfield stdfield, BindingResult result, SessionStatus status, Principal currentUser) {
        if(result.hasErrors()){
            return "redirect:/stdfieldForm" + group.getKodeGroup();
        }
        else{
            stdfield.setUserUpdate(currentUser.getName());
            stdfield.setLastUpdate(new Date(System.currentTimeMillis()));
            if (stdfield.getIdField() == null) {
                stdService.save(stdfield, group.getKodeGroup());

            } else {
                stdService.save(stdfield);

            }
            status.setComplete();
            return "redirect:/stdfieldForm/" + group.getKodeGroup();
    }
    }
    @RequestMapping(value = "/del/{kodeGroup}/{idField}")
    public String delStdField(@PathVariable("kodeGroup") String kodeGroup, @PathVariable("idField") Integer idField, ModelMap model) {
        stdService.delete(idField);
        Groupfield groupfield = groupService.findBykode(kodeGroup);
        model.addAttribute("groupfield", groupfield);
        model.addAttribute("stdfield", new Stdfield());
        model.addAttribute("liststdField", groupfield.getStdfieldSet());
        return "stdfieldForm";

    }

    @ModelAttribute("allgrup")
    public List<Groupfield> loadfield() {
        return groupService.findAll();
    }
}
