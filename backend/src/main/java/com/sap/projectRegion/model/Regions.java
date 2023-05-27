package com.sap.projectRegion.model;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {

    public Regions() {
    }

    public Regions(String regionDescription, long regionID) {
        this.regionDescription = regionDescription;
        this.regionID = regionID;
    }

    @Column(name = "regionDescription")
    private String regionDescription;
    @Id
    @Column(name = "regionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regionID;

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "regionID=" + regionID +
                ", regionDescription='" + regionDescription + '\'' +
                '}';
    }
}