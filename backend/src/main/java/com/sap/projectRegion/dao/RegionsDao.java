package com.sap.projectRegion.dao;

import com.sap.projectRegion.model.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RegionsDao extends JpaRepository <Regions, Long>{
    @Transactional
    @Modifying
    @Query("update Regions r set r.regionDescription = ?1 where r.regionID = ?2")
    void updateByID(String regionDescription, long regionID);
}