package com.sap.projectRegion.repository;

import com.sap.projectRegion.model.Territories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TerritoriesRepository extends JpaRepository<Territories, Long> {
    @Transactional
    @Modifying
    @Query("update Territories t set t.territoryDescription = ?1 where t.territoryID = ?2")
    void updateTerritory(String territoryDescription, long territoryID);

    //since territoryID is not changing, we cannot update regionID
}
