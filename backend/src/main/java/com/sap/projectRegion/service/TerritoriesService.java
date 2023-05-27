package com.sap.projectRegion.service;

import com.sap.projectRegion.model.Territories;
import com.sap.projectRegion.repository.TerritoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerritoriesService {

    @Autowired
    public TerritoriesRepository territoriesRepository;

    public void addTerritory (Territories territory) {
        territoriesRepository.save (territory);
    }

    public void addMultipleTerritories (List<Territories> territoriesList) {
        //when territories object had regionID as attribute, instead of entire region object
        //foreign key referencing was not being possible using mapping
        //check for regionID
        // for (Territories t: territoriesList) {
        //     t.getRegionsID ()
        //if not exists, throw exception

        //now, passed region object as attribute in territories, since this is the general convention followed in production
        //using foreign key referencing
        territoriesRepository.saveAll(territoriesList);
    }

    public List<Territories> readTerritories () {
        return territoriesRepository.findAll();
    }

    public Optional<Territories> findById (long idToFind) throws IllegalArgumentException {
        if (!territoriesRepository.existsById(idToFind))
            throw new IllegalArgumentException("Invalid ID entered!");
        return territoriesRepository.findById(idToFind);
    }

    public String deleteTerritoriesByID (long id) {
        try {
            if (!territoriesRepository.existsById(id))
                throw new IllegalArgumentException("Incorrect ID entered.");
            territoriesRepository.deleteById(id);
            return "Territory with id " + id + " deleted.";
        } catch (IllegalArgumentException e) {
            return "" + e;
        }
    }

    public String updateTerritoryByID (String desc, long id) {
        try {
            if (!territoriesRepository.existsById(id))
                throw new IllegalArgumentException("Invalid ID entered for updation.");
            territoriesRepository.updateTerritory (desc, id);
            return "territory with id " + id + " updated.";
        } catch (IllegalArgumentException e) {
            return "" + e;
        }
    }
}
