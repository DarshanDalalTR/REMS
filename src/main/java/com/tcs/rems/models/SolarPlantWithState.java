package com.tcs.rems.models;

public class SolarPlantWithState
{
    double s_plant_lat, s_plant_lon, avg_radiation;
    String s_plant_name;
    int state_id, plant_id;

    public int getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(int plant_id) {
        this.plant_id = plant_id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    String stateName;

    public double getS_plant_lat() {
        return s_plant_lat;
    }

    public void setS_plant_lat(double s_plant_lat) {
        this.s_plant_lat = s_plant_lat;
    }

    public void setS_plant_lon(double s_palnt_lon) {
        this.s_plant_lon = s_palnt_lon;
    }

    public double getAvg_radiation() {
        return avg_radiation;
    }

    public void setAvg_radiation(double avg_radiation) {
        this.avg_radiation = avg_radiation;
    }

    public String getS_plant_name() {
        return s_plant_name;
    }

    public void setS_plant_name(String s_plant_name) {
        this.s_plant_name = s_plant_name;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public double getS_plant_lon() {
        return s_plant_lon;
    }
}

