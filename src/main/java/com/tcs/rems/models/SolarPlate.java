package com.tcs.rems.models;

import java.util.ArrayList;

/**
 * Created by lenovo on 7/10/2017.
 */
public class SolarPlate {

    public String getPlate_name() {
        return plate_name;
    }

    public void setPlate_name(String plate_name) {
        this.plate_name = plate_name;
    }

    public Double getPlate_area() {
        return plate_area;
    }

    public void setPlate_area(Double plate_area) {
        this.plate_area = plate_area;
    }

    public Double getPlate_efficiency() {
        return plate_efficiency;
    }

    public void setPlate_efficiency(Double plate_efficiency) {
        this.plate_efficiency = plate_efficiency;
    }

    public Double getPlate_perf_ratio() {
        return plate_perf_ratio;
    }

    public void setPlate_perf_ratio(Double plate_perf_ratio) {
        this.plate_perf_ratio = plate_perf_ratio;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    String plate_name;

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    String last_updated;

    public int getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(int plant_id) {
        this.plant_id = plant_id;
    }

    int plant_id;

    public int getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(int plate_id) {
        this.plate_id = plate_id;
    }

    int plate_id;

    Double plate_area,plate_efficiency,plate_perf_ratio;
    int qty;

    public ArrayList<SolarNotification> getNotifs() {
        return notifs;
    }

    public void setNotifs(ArrayList<SolarNotification> notifs) {
        this.notifs = notifs;
    }

    ArrayList<SolarNotification> notifs;

}
