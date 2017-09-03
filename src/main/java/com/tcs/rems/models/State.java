package com.tcs.rems.models;

/**
 * Created by lenovo on 7/16/2017.
 */
public class State {
    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    int state_id;
    String state_name;

}
