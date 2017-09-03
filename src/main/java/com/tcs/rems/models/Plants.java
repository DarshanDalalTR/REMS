package com.tcs.rems.models;

/**
 * Created by lenovo on 7/19/2017.
 */
public class Plants
{
    String plant_name;

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(String plant_id) {
        this.plant_id = plant_id;
    }

    public double getPlant_lat() {
        return plant_lat;
    }

    public void setPlant_lat(double plant_lat) {
        this.plant_lat = plant_lat;
    }

    public double getPlant_lon() {
        return plant_lon;
    }

    public void setPlant_lon(double plant_lon) {
        this.plant_lon = plant_lon;
    }

    public String getPlant_type() {
        return plant_type;
    }

    public void setPlant_type(String plant_type) {
        this.plant_type = plant_type;
    }

    String plant_id;
    double plant_lat,plant_lon;
    String plant_type;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    String state;

}
