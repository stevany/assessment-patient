package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.Stdfield;
import com.rscharitas.dataPP.repository.GroupFieldRepository;
import com.rscharitas.dataPP.repository.StdFieldRepository;
import com.rscharitas.dataPP.service.StdFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:33 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class StdFieldServiceImpl implements StdFieldService {
    @Autowired
    private StdFieldRepository sfRepo;
    @Autowired
    private GroupFieldRepository groupRepo;

    @Override
    public void save(Stdfield stdfield, String kode) {
         stdfield.setKdField(groupRepo.findOne(kode));
         sfRepo.save(stdfield);

    }

    @Override
    public void save(Stdfield stdfield) {
        sfRepo.saveAndFlush(stdfield);
    }

    @Override
    public void delete(Integer idField) {
        sfRepo.delByIdField(idField);
    }

    @Override
    public Stdfield findById(Integer id) {
        return sfRepo.findOne(id);
    }

    @Override
    public List<Stdfield> findByKdField(String kdField) {
        return  sfRepo.findByKode(kdField);
    }

    @Override
    public List<Stdfield> findAll() {
        return sfRepo.findAll();
    }


}
