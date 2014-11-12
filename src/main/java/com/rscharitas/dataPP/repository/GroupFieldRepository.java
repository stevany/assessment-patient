package com.rscharitas.dataPP.repository;

import com.rscharitas.dataPP.entity.Groupfield;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 7/31/13
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GroupFieldRepository extends JpaRepository<Groupfield, String> {
    Groupfield findBykodeGroup(String kodeGroup);
}
