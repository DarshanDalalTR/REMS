package com.tcs.rems.models;

/**
 * Created by lenovo on 7/26/2017.
 */
public class GeneralNotification
{
    String notif;
    String plantName;

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantComponent() {
        return plantComponent;
    }

    public void setPlantComponent(String plantComponent) {
        this.plantComponent = plantComponent;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    String plantComponent;
    int plantId;
    String plantType;


}
