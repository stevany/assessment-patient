package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.DataPasien;
import com.rscharitas.dataPP.entity.ObatRutin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ObatRutinService {
    void save(ObatRutin obatRutin, Integer id);
    void save(ObatRutin obatRutin);
    void remove(Integer idObat);
    List<ObatRutin> findByIdPasien(Integer idPasien);
    ObatRutin findByIdObat(Integer idObat);
}
