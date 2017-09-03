package com.tcs.rems.models;

/**
 * Created by lenovo on 7/16/2017.
 */
public class SolarPlant {


    int s_plant_id;
    double s_plant_lat;

    public int getS_plant_id() {
        return s_plant_id;
    }

    public void setS_plant_id(int s_plant_id) {
        this.s_plant_id = s_plant_id;
    }

    public double getS_plant_lat() {
        return s_plant_lat;
    }

    public void setS_plant_lat(double s_plant_lat) {
        this.s_plant_lat = s_plant_lat;
    }

    public double getS_plant_lon() {
        return s_plant_lon;
    }

    public void setS_plant_lon(double s_plant_lon) {
        this.s_plant_lon = s_plant_lon;
    }

    public String getS_plant_name() {
        return s_plant_name;
    }

    public void setS_plant_name(String s_plant_name) {
        this.s_plant_name = s_plant_name;
    }

    public double getAvg_radiation() {
        return avg_radiation;
    }

    public void setAvg_radiation(double avg_radiation) {
        this.avg_radiation = avg_radiation;
    }

    double s_plant_lon;
    String s_plant_name;
    double avg_radiation;
}
