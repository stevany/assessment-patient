package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.DataPasien;
import com.rscharitas.dataPP.entity.ObatRutin;
import com.rscharitas.dataPP.repository.ObatRutinRepository;
import com.rscharitas.dataPP.service.DataPasienService;
import com.rscharitas.dataPP.service.ObatRutinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ObatRutinServiceImpl implements ObatRutinService {
    @Autowired
    private ObatRutinRepository orRepo;
    @Autowired
    private DataPasienService dataPasienService;

    @Override
    public void save(ObatRutin obatRutin,Integer idPasien) {
        obatRutin.setIdPasien(dataPasienService.findById(idPasien));
        orRepo.save(obatRutin);
    }

    @Override
    public void save(ObatRutin obatRutin) {
        orRepo.saveAndFlush(obatRutin);
    }

    @Override
    public void remove(Integer idObat) {
        orRepo.delByIdObat(idObat);
    }

    @Override
    public ObatRutin findByIdObat(Integer idObat) {
        return orRepo.findOne(idObat);
    }

    @Override
    public List<ObatRutin> findByIdPasien(Integer idPasien) {
        return orRepo.findByIdPas(idPasien);
    }
}
