package com.tcs.rems.DAO;

import com.tcs.rems.models.SolarPlantWithState;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.util.List;

/**
 * Created by darsh on 7/16/2017.
 */
public class SolarPlantDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean addSolarPlant(SolarPlantWithState plant) {
        String query = "INSERT into solar_plant (s_plant_lat, s_plant_lon, avg_radiation, state_id,s_plant_name) VALUES (?,?,?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {

            preparedStatement.setDouble(1, plant.getS_plant_lat());
            preparedStatement.setDouble(2, plant.getS_plant_lon());
            preparedStatement.setDouble(3, plant.getAvg_radiation());
            preparedStatement.setInt(4, plant.getState_id());
            preparedStatement.setString(5, plant.getS_plant_name());
            return preparedStatement.execute();
        });
    }

    public int editSolarPlant(int plantid, SolarPlantWithState plant) {
        String query = "Update solar_plant SET s_plant_name=?,s_plant_lat=?,s_plant_lon=?,avg_radiation=?,state_id=? WHERE s_plant_id=?";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, plant.getS_plant_name());
            preparedStatement.setDouble(2, plant.getS_plant_lat());
            preparedStatement.setDouble(3, plant.getS_plant_lon());
            preparedStatement.setDouble(4, plant.getAvg_radiation());
            preparedStatement.setInt(5, plant.getState_id());
            preparedStatement.setInt(6, plantid);
        });
    }

    public List<SolarPlantWithState> getPlantById(int plantid) {
        String query = "Select s_plant_name,s_plant_lat,s_plant_lon,avg_radiation,state_id FROM solar_plant WHERE s_plant_id=?";
        return jdbcTemplate.query(query, new Object[] {plantid}, (rs, rownumber) -> {
            SolarPlantWithState solarPlant = new SolarPlantWithState();
            solarPlant.setS_plant_name(rs.getString(1));
            solarPlant.setS_plant_lat(rs.getDouble(2));
            solarPlant.setS_plant_lon(rs.getDouble(3));
            solarPlant.setAvg_radiation(rs.getDouble(4));
            solarPlant.setState_id(rs.getInt(5));
            return solarPlant;
        });
    }

    public List<SolarPlantWithState> viewPlants() {
        String query = "Select * FROM solar_plant";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            SolarPlantWithState solarPlant = new SolarPlantWithState();
            solarPlant.setS_plant_name(rs.getString("s_plant_name"));
            solarPlant.setS_plant_lat(rs.getInt("s_plant_lat"));
            solarPlant.setS_plant_lon(rs.getDouble("s_plant_lon"));
            solarPlant.setAvg_radiation(rs.getDouble("avg_radiation"));
            solarPlant.setState_id(rs.getInt("state_id"));
            solarPlant.setPlant_id(rs.getInt("s_plant_id"));
            return solarPlant;
        });
    }

    public int deletePlant(int id) {
        String query = "DELETE FROM solar_plant WHERE s_plant_id=?";
        return jdbcTemplate.update(query, id);
    }

    public List<Double> getRecentReadings(int plantId) {
        String query = "SELECT reading_value FROM solar_reading WHERE plant_id = ? ORDER BY reading_id DESC LIMIT 10";
        return jdbcTemplate.query(query, new Object[] {plantId}, (rs, rownumber) -> rs.getDouble(1));
    }
}

