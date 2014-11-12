package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.Groupfield;
import com.rscharitas.dataPP.repository.GroupFieldRepository;
import com.rscharitas.dataPP.service.GroupFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/31/13
 * Time: 7:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class GroupFieldServiceImpl implements GroupFieldService {
    @Autowired
    private GroupFieldRepository repo;

    @Override
    public Groupfield findBykode(String kode) {
        return repo.findOne(kode);
    }

    @Override
    public void save(Groupfield groupfield) {
        repo.saveAndFlush(groupfield);
    }

    @Override
    public List<Groupfield> findAll() {
        return repo.findAll();
    }
}
