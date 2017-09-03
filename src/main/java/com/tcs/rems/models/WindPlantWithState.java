package com.tcs.rems.models;

/**
 * Created by darsh on 7/16/2017.
 */
public class WindPlantWithState {
    int w_plant_id, state_id;
    Double w_plant_lat, w_plant_lon, wind_speed, wind_direction, air_density;
    String w_plant_name, state_name;

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public int getW_plant_id() {
        return w_plant_id;
    }

    public void setW_plant_id(int w_plant_id) {
        this.w_plant_id = w_plant_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public Double getW_plant_lat() {
        return w_plant_lat;
    }

    public void setW_plant_lat(Double w_plant_lat) {
        this.w_plant_lat = w_plant_lat;
    }

    public Double getW_plant_lon() {
        return w_plant_lon;
    }

    public void setW_plant_lon(Double w_plant_lon) {
        this.w_plant_lon = w_plant_lon;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(Double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public Double getAir_density() {
        return air_density;
    }

    public void setAir_density(Double air_density) {
        this.air_density = air_density;
    }

    public String getW_plant_name() {
        return w_plant_name;
    }

    public void setW_plant_name(String w_plant_name) {
        this.w_plant_name = w_plant_name;
    }
}
