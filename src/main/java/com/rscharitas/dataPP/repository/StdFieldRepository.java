package com.rscharitas.dataPP.repository;

import com.rscharitas.dataPP.entity.Stdfield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/19/13
 * Time: 8:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StdFieldRepository extends JpaRepository<Stdfield, Integer> {
    @Query("select s from Stdfield s where s.kdField.kodeGroup=:kode order by kdUser")
    List<Stdfield> findByKode(@Param("kode")String kode);
    @Modifying
    @Transactional
    @Query("delete from Stdfield s where s.idField=:idField")
    void delByIdField(@Param("idField") Integer idField);

}
