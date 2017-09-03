package com.tcs.rems.DAO;

import com.tcs.rems.models.Plants;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GeneralPlantDAO
{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Plants> getAllPlants()
    {
        String query="(SELECT s_plant_id plant_id, 'solar' plant_type, s_plant_lat plant_lat, s_plant_lon plant_lon, s_plant_name plant_name  FROM solar_plant) UNION (SELECT w_plant_id plant_id, 'wind' plant_type, w_plant_lat plant_lat, w_plant_lon plant_lon, w_plant_name plant_name  FROM wind_plant)";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            Plants plant=new Plants();
            plant.setPlant_id(rs.getString("plant_id"));
            plant.setPlant_name(rs.getString("plant_name"));
            plant.setPlant_lat(rs.getDouble("plant_lat"));
            plant.setPlant_lon(rs.getDouble("plant_lon"));
            plant.setPlant_type(rs.getString("plant_type"));
            return plant;
        });
    }
}
