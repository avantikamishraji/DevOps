package com.sap.projectRegion.controller;

import com.sap.projectRegion.model.Regions;
import com.sap.projectRegion.model.Territories;
import com.sap.projectRegion.service.RegionsService;
import com.sap.projectRegion.service.TerritoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/Regions")
public class RegionsController {

    @Autowired
    public RegionsService regionsServ;

    @Autowired
    public TerritoriesService territoriesServ;

    @PostMapping
    public String createRegion (@RequestBody Regions regions) {
        regionsServ.addRegion(regions);
        return "Scholar" + regions + "created.";
    }

    @PostMapping ("/all")
    public String insertMultipleRegions (@RequestBody List<Regions> regionsList) {
        regionsServ.addMultipleRegions(regionsList);
        return "Regions added.";
    }

    @GetMapping
    public List<Regions> getRegions () {
        return regionsServ.readRegions();
    }

    @GetMapping("{regionID}")
    public Optional<Regions> getRegionById (@PathVariable long regionID) {
        return regionsServ.findById (regionID);
    }

    @DeleteMapping("/{regionsID}")
    public String deleteRegion (@PathVariable long regionsID) {
        return regionsServ.deleteRegionsByID(regionsID);
   //     return "Region with " + regionsID + " deleted.";
    }

    @PutMapping
    public String updateDescriptionByID (@RequestParam String updateString, @RequestParam long idToUpdate) {
        regionsServ.updateDetailsByID(updateString, idToUpdate);
        return "Details updated if ID exists.";
    }



    @PostMapping ("territories")
    public String createTerritory (@RequestBody Territories t) {
        territoriesServ.addTerritory(t);
        return "Territory " + t + " created.";
    }

    @PostMapping("territories/all")
    public String createMultipleTerritories (@RequestBody List<Territories> territoriesList) {
        territoriesServ.addMultipleTerritories(territoriesList);
        return "Territories added.";
    }

    @GetMapping("territories/all")
    public List<Territories> readAllTerritories () {
        return territoriesServ.readTerritories();
    }

    @GetMapping ("territories/{idToFind}")
    public Optional<Territories> getTerritoriesByID (@PathVariable long idToFind) {
        return territoriesServ.findById(idToFind);
    }

    //printing the region description of a territory using the regionID attribute of territories
    //also using foreign key reference that we created
    //provide territoryID and print its respective region description
    @GetMapping ("territoriesRegions/{terrID}")
    public String printRegionOfTerritories (@PathVariable long terrID) throws IllegalArgumentException {
        Territories concernedTerritory = territoriesServ.findById(terrID).orElse(null);
        if (Objects.isNull(concernedTerritory))
            throw new IllegalArgumentException("Invalid ID entered");
        return concernedTerritory.getRegions().getRegionDescription();
    }

    @DeleteMapping ("territories/{id}")
    public String deleteTerritoryById (@PathVariable long id) {
        return territoriesServ.deleteTerritoriesByID(id);
    }

    @PutMapping ("territories")
    public String updateTerritory (@RequestParam String updatedDesc, @RequestParam long idToUpdate) {
        return territoriesServ.updateTerritoryByID(updatedDesc, idToUpdate);
    }
}
