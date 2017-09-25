package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 8/29/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationModel {

    @SerializedName("locations")
    @Expose
    private List<Location> locations = null;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

}