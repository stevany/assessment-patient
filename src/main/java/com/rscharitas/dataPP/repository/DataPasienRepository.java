package com.rscharitas.dataPP.repository;

import com.rscharitas.dataPP.entity.DataPasien;
import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DataPasienRepository extends JpaRepository<DataPasien, Integer > {
//    List<DataPasien> findByNamaLengkapContainingOrTglBetween(String nama,Date from, Date to);
    List<DataPasien>findByTglBetween(Date from, Date to);
    List<DataPasien>findByNamaLengkapContaining(String nama);
//    @Query("select p from DataPasien p where p.namaLengkap =?1 and p.tgl between ?2 and ?3 ")
//    List<DataPasien> findByNamaLgkp(String namaLgkp, Date from, Date to);

}
