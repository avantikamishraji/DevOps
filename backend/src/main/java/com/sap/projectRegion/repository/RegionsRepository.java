package com.sap.projectRegion.repository;

import com.sap.projectRegion.model.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository <Regions, Long>{
    //ideally repo should use a dao object for its functions
    //here we didn't have a need for that, sadly
}