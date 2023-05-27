package com.sap.projectRegion.dao;

import com.sap.projectRegion.model.Territories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoriesDao extends JpaRepository <Territories, Long>{
    //basic crud functions should ideally be defined here
    //and those will be used by TerritoriesRepository to implement its own functions
    //but then a TerritoriesRepoImplementation class should be made which will implement interface TerritoriesRepo
    //but interface TerritoriesRepo extends abstract class (or interface) JpaRepository
    //so now this new class TerritoriesRepoImplementation will be asked to override all the methods inside JpaRepository
    //and this cannot be done since we wish to use the existing implementation of these functions only

    //to avoid this huge messy problem, I have avoided creation of implementation classes of Dao and Repo interfaces here
}