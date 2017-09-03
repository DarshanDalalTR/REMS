package com.tcs.rems.models;

/**
 * Created by lenovo on 7/16/2017.
 */
public class WindPlant {
    int w_plant_id;
    String w_plant_name;
    double w_plant_lat;
    double w_plant_lon;
    double wind_direction;
    double wind_speed;
    double air_density;

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    int state_id;

    public int getW_plant_id() {
        return w_plant_id;
    }

    public void setW_plant_id(int w_plant_id) {
        this.w_plant_id = w_plant_id;
    }

    public String getW_plant_name() {
        return w_plant_name;
    }

    public void setW_plant_name(String w_plant_name) {
        this.w_plant_name = w_plant_name;
    }

    public double getW_plant_lat() {
        return w_plant_lat;
    }

    public void setW_plant_lat(double w_plant_lat) {
        this.w_plant_lat = w_plant_lat;
    }

    public double getW_plant_lon() {
        return w_plant_lon;
    }

    public void setW_plant_lon(double w_plant_lon) {
        this.w_plant_lon = w_plant_lon;
    }

    public double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getAir_density() {
        return air_density;
    }

    public void setAir_density(double air_density) {
        this.air_density = air_density;
    }
}
