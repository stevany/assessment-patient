package com.rscharitas.dataPP.repository;

import com.rscharitas.dataPP.entity.ObatRutin;

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
 * Time: 8:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ObatRutinRepository extends JpaRepository<ObatRutin, Integer> {
    @Query("select p from ObatRutin p where p.idPasien=:id")
    List<ObatRutin> findByIdPas(@Param("id")Integer id);
    @Modifying
    @Transactional
    @Query("delete from ObatRutin o where o.idObat=:idObat")
    void delByIdObat(@Param("idObat") Integer idObat);

}
