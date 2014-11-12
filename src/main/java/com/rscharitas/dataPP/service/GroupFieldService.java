package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.Groupfield;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/31/13
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GroupFieldService  {
    Groupfield findBykode(String kode);
    void save(Groupfield groupfield);
    List<Groupfield> findAll();

}
