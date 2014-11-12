package com.rscharitas.dataPP.service;

import com.rscharitas.dataPP.entity.DataPasien;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:15 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DataPasienService {
    DataPasien save(DataPasien dataPasien);
    DataPasien findById(Integer id);
    List<DataPasien> findByNamaLengkap(String nama);
    List<DataPasien> getTgl(String from, String to);
}
