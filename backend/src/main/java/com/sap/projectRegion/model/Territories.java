package com.sap.projectRegion.model;

import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territories {

    public Territories() {
    }

    public Territories(long territoryID, String territoryDescription, Regions regions) {
        this.territoryID = territoryID;
        this.territoryDescription = territoryDescription;
        this.regions = regions;
    }

    @Id
    @Column(name = "territoryID")
    private long territoryID;

    @Column(name = "territoryDescription")
    private String territoryDescription;

    //many territories can have one region
    @ManyToOne
    @JoinColumn (name = "regionID", referencedColumnName = "regionID")
    private Regions regions;

    public long getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(long territoryID) {
        this.territoryID = territoryID;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Territories{" +
                "territoryID=" + territoryID +
                ", territoryDescription='" + territoryDescription + '\'' +
                ", regions=" + regions +
                '}';
    }
}
