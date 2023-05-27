package com.sap.projectRegion.service;

import com.sap.projectRegion.dao.RegionsDao;
import com.sap.projectRegion.model.Regions;
import com.sap.projectRegion.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.lang.IllegalArgumentException;

@Service
public class RegionsService {

    @Autowired
    public RegionsRepository regionsRepo;

    @Autowired
    public RegionsDao regionsDao;

    public void addRegion (Regions region) {
        regionsRepo.save (region);
    }

    public void addMultipleRegions (List<Regions> regionsList) {
        regionsRepo.saveAll (regionsList);
    }

    public List<Regions> readRegions () {
        return regionsRepo.findAll();
    }

    public Optional<Regions> findById(long idToFind) throws IllegalArgumentException {
        if (!regionsRepo.existsById(idToFind))
            throw new IllegalArgumentException("Entered ID does not exist.");
        return regionsRepo.findById(idToFind);
    }

    public String deleteRegionsByID (long idToDelete) {
        try {
            if (!regionsRepo.existsById(idToDelete))
                throw new IllegalArgumentException("Invalid ID entered.");
            regionsRepo.deleteById(idToDelete);
            return "Region with " + idToDelete + " deleted.";
        }
        catch (IllegalArgumentException e) {
            return "" + e;
        }
    }

    public void updateDetailsByID (String updatedDesc, long idToUpdate) {
        try {
            if (!(regionsRepo.existsById(idToUpdate)))
                throw new IllegalArgumentException("Invalid ID entered!");
            //tried a lot, to use regionsRepo here, but not feasible
            regionsDao.updateByID(updatedDesc, idToUpdate);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        finally {
            //prints in the terminal
            System.out.println("Details updated if ID exists.");
        }
    }
}
