package com.tcs.rems.models;

/**
 * Created by lenovo on 7/22/2017.
 */
public class SolarEnergy
{

    public static double calculateEnergy(double perf_ratio,double area,double avg_radiation,double qty,double efficiency)
    {
      return perf_ratio*area*avg_radiation*qty*efficiency;
    }
}
