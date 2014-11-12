package com.rscharitas.dataPP.service.impl;

import com.rscharitas.dataPP.entity.DataPasien;
import com.rscharitas.dataPP.repository.DataPasienRepository;
import com.rscharitas.dataPP.service.DataPasienService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DataPasienServiceImpl implements DataPasienService {
    @Autowired
    private DataPasienRepository dpRepo;

    @Override
    public DataPasien save(DataPasien dataPasien) {
        dpRepo.saveAndFlush(dataPasien);
        return dataPasien;
    }

    @Override
    public DataPasien findById(Integer id) {
        return dpRepo.findOne(id);
    }

    @Override
    public List<DataPasien> findByNamaLengkap(String nama) {
        return dpRepo.findByNamaLengkapContaining(nama);
    }

    @Override
    public List<DataPasien> getTgl(String from, String to) {
        Date frm=new Date();
        Date t=new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            frm = sdf.parse(from);
            t= sdf.parse(to);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return dpRepo.findByTglBetween(frm, t);

    }


}
