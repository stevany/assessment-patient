package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.Stdfield;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:28 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StdFieldService {
    void save(Stdfield stdfield, String kode);
    void save(Stdfield stdfield);
    void delete(Integer idField);
    Stdfield findById(Integer id);
    List<Stdfield> findByKdField(String kdField);
    List<Stdfield>findAll();
}
