package com.rscharitas.dataPP.controller;

import com.rscharitas.dataPP.entity.DataPasien;

import com.rscharitas.dataPP.entity.ObatRutin;
import com.rscharitas.dataPP.entity.Stdfield;
import com.rscharitas.dataPP.service.DataPasienService;
import com.rscharitas.dataPP.service.ObatRutinService;
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

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/pasienForm")
@SessionAttributes({"dataPasien", "obatRutin"})
public class DataPasienController {
    @Autowired
    private DataPasienService dataPasienService;
    @Autowired
    private StdFieldService stdfService;
    @Autowired
    private ObatRutinService orService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields(new String[]{"id"});
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @InitBinder
    public void initFieldBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Stdfield.class, new FieldPropertyEditor(this.stdfService));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(ModelMap model, Principal currentUser) {
        model.addAttribute("dataPasien", new DataPasien());
        model.addAttribute("obatRutin", new ObatRutin());
        model.addAttribute("currUser", currentUser.getName());
        return "pasienForm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPasien(@PathVariable Integer id, ModelMap model, Principal currentUser) {
        DataPasien data = dataPasienService.findById(id);
        model.addAttribute("dataPasien", data);
        model.addAttribute("obatRutin", new ObatRutin());
        model.addAttribute("listObat", data.getObatRutin());
        model.addAttribute("currUser", currentUser.getName());
        return "pasienForm";
    }

    @RequestMapping(value = "/{id}/{idObat}", method = RequestMethod.GET)
    public String getObat(@PathVariable("id") Integer idPas, @PathVariable("idObat") Integer idObt, ModelMap model, Principal currentUser) {
        ObatRutin obat = orService.findByIdObat(idObt);
        DataPasien data = dataPasienService.findById(idPas);
        model.addAttribute("dataPasien", data);
        model.addAttribute("obatRutin", obat);
        model.addAttribute("listObat", data.getObatRutin());
        model.addAttribute("currUser", currentUser.getName());
        return "pasienForm";
    }

    @RequestMapping(params = "create", method = RequestMethod.POST)
    public String update(DataPasien dataPasien, BindingResult bindingResult, SessionStatus sessionStatus, ModelMap modelMap, Principal currentUser) {
        if (bindingResult.hasErrors()) {
            return "redirect:/pasienForm";
        } else {
            dataPasien.setUserUpdate(currentUser.getName());
            dataPasien.setLastUpdate(new Date(System.currentTimeMillis()));
            dataPasienService.save(dataPasien);
            sessionStatus.setComplete();
            return "redirect:/pasienForm/" + dataPasien.getId();
        }
    }

    @RequestMapping(params = "addRow", method = RequestMethod.POST)
    public String editObat(DataPasien data, ObatRutin obat, BindingResult result, SessionStatus status, Principal currentUser) {
        if(result.hasErrors()){
            return "redirect:/pasienForm" + data.getId();
        }
        else{
            obat.setUserUpdate(currentUser.getName());
            obat.setLastUpdate(new Date(System.currentTimeMillis()));
            if (obat.getIdObat() == null) {
                orService.save(obat, data.getId());
            } else {
                orService.save(obat);
            }
            status.setComplete();
            return "redirect:/pasienForm/" + data.getId();
        }


    }

    @RequestMapping(value = "/del/{id}/{idObat}")
    public String remove(@PathVariable("id") Integer idPas, @PathVariable("idObat") Integer idObt, ModelMap model) {
        orService.remove(idObt);
        DataPasien data = dataPasienService.findById(idPas);
        model.addAttribute("dataPasien", data);
        model.addAttribute("obatRutin", new ObatRutin());
        model.addAttribute("listObat", data.getObatRutin());
        return "pasienForm";
    }

    @ModelAttribute("alljk")
    public List<Stdfield> loadjk() {
        return stdfService.findByKdField("JK");
    }

    @ModelAttribute("allkwn")
    public List<Stdfield> loadkwn() {
        return stdfService.findByKdField("KWN");
    }

    @ModelAttribute("allpkj")
    public List<Stdfield> loadpkj() {
        return stdfService.findByKdField("PKJ");
    }

    @ModelAttribute("allagama")
    public List<Stdfield> loadagama() {
        return stdfService.findByKdField("AGM");
    }

    @ModelAttribute("allpdd")
    public List<Stdfield> loadpdd() {
        return stdfService.findByKdField("PDD");
    }

    @ModelAttribute("allhub")
    public List<Stdfield> loadhub() {
        return stdfService.findByKdField("HUB");
    }

    @ModelAttribute("allbyr")
    public List<Stdfield> loadbyr() {
        return stdfService.findByKdField("BYR");
    }

    @ModelAttribute("alltgl")
    public List<Stdfield> loadtgl() {
        return stdfService.findByKdField("TGL");
    }

    @ModelAttribute("allhml")
    public List<Stdfield> loadhml() {
        return stdfService.findByKdField("HML");
    }

    @ModelAttribute("allank")
    public List<Stdfield> loadankp() {
        return stdfService.findByKdField("ANK");

    }

    @ModelAttribute("allimp")
    public List<Stdfield> loadimp() {
        return stdfService.findByKdField("IMP");

    }

    @ModelAttribute("allrp")
    public List<Stdfield> loadrp() {
        return stdfService.findByKdField("RP");

    }

    @ModelAttribute("allrvd")
    public List<Stdfield> loadrvd() {
        return stdfService.findByKdField("RVD");

    }

    @ModelAttribute("allrvl")
    public List<Stdfield> loadrvl() {
        return stdfService.findByKdField("RVL");

    }

    static class FieldPropertyEditor extends PropertyEditorSupport {
        private StdFieldService stdFieldService;

        public FieldPropertyEditor(StdFieldService stdFieldService) {
            super();
            this.stdFieldService = stdFieldService;
        }

        @Override
        public String getAsText() {
            Stdfield value = (Stdfield) getValue();
            return (value != null ? value.getKdUser() : "");    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void setAsText(String s) throws IllegalArgumentException {
            Integer id = Integer.valueOf(s);
            setValue(this.stdFieldService.findById(id));

        }

    }


}
