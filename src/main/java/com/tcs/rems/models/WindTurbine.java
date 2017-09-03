package com.tcs.rems.models;

import java.util.List;

/**
 * Created by lenovo on 7/10/2017.
 */
public class WindTurbine {
    public String getTurbine_name() {
        return turbine_name;
    }

    public void setTurbine_name(String turbine_name) {
        this.turbine_name = turbine_name;
    }

    public Double getBlade_length() {
        return blade_length;
    }

    public void setBlade_length(Double blade_length) {
        this.blade_length = blade_length;
    }

    public Double getPower_coeff() {
        return power_coeff;
    }

    public void setPower_coeff(Double power_coeff) {
        this.power_coeff = power_coeff;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(int plant_id) {
        this.plant_id = plant_id;
    }

    public int getTurbine_id() {
        return turbine_id;
    }

    public void setTurbine_id(int turbine_id) {
        this.turbine_id = turbine_id;
    }

    String turbine_name;
    Double blade_length,power_coeff;
    int qty, plant_id, turbine_id;
    List<WindNotification> notif;

    public List<WindNotification> getNotif() {
        return notif;
    }

    public void setNotif(List<WindNotification> notif) {
        this.notif = notif;
    }
}
