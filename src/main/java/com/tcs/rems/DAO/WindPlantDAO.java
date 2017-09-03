package com.tcs.rems.DAO;

import com.tcs.rems.models.WindPlantWithState;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by darsh on 7/16/2017.
 */
public class WindPlantDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public Boolean addWindPlant(WindPlantWithState plant) {
        String query = "INSERT into wind_plant ( w_plant_name, w_plant_lat, w_plant_lon, wind_direction, wind_speed, air_density, state_id) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setString(1, plant.getW_plant_name());
            preparedStatement.setDouble(2, plant.getW_plant_lat());
            preparedStatement.setDouble(3, plant.getW_plant_lon());
            preparedStatement.setDouble(4, plant.getWind_direction());
            preparedStatement.setDouble(5, plant.getWind_speed());
            preparedStatement.setDouble(6, plant.getAir_density());
            preparedStatement.setInt(7, plant.getState_id());
            return preparedStatement.execute();
        });
    }

    public int editWindPlant(int plantid, WindPlantWithState plant) {
        String query = "Update wind_plant SET w_plant_name=?,w_plant_lat=?,w_plant_lon=?,wind_direction=?,wind_speed=?,air_density=?,state_id=? WHERE w_plant_id=?";
        return jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, plant.getW_plant_name());
                preparedStatement.setDouble(2, plant.getW_plant_lat());
                preparedStatement.setDouble(3, plant.getW_plant_lon());
                preparedStatement.setDouble(4, plant.getWind_direction());
                preparedStatement.setDouble(5, plant.getWind_speed());
                preparedStatement.setDouble(6, plant.getAir_density());
                preparedStatement.setInt(7, plant.getState_id());
                preparedStatement.setInt(8, plantid);
            }
        });
    }

    public List<WindPlantWithState> getPlantById(int plantid) {
        String query = "Select w_plant_name,w_plant_lat,w_plant_lon,wind_direction,wind_speed,air_density,state.state_id, state_name FROM wind_plant INNER JOIN state ON wind_plant.state_id = state.state_id WHERE w_plant_id=?";
        return jdbcTemplate.query(query, new Object[]{plantid}, (rs, rownumber) -> {
            WindPlantWithState windPlant = new WindPlantWithState();
            windPlant.setW_plant_name(rs.getString(1));
            windPlant.setW_plant_lat(rs.getDouble(2));
            windPlant.setW_plant_lon(rs.getDouble(3));
            windPlant.setWind_direction(rs.getDouble(4));
            windPlant.setWind_speed(rs.getDouble(5));
            windPlant.setAir_density(rs.getDouble(6));
            windPlant.setState_id(rs.getInt(7));
            windPlant.setState_name(rs.getString(8));
            return windPlant;
        });
    }

    public List<WindPlantWithState> viewPlants() {
        String query = "Select * FROM wind_plant";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            WindPlantWithState windPlant = new WindPlantWithState();
            windPlant.setW_plant_id(rs.getInt(1));
            windPlant.setW_plant_name(rs.getString(2));
            windPlant.setW_plant_lat(rs.getDouble(3));
            windPlant.setW_plant_lon(rs.getDouble(4));
            windPlant.setWind_direction(rs.getDouble(5));
            windPlant.setWind_speed(rs.getDouble(6));
            windPlant.setAir_density(rs.getDouble(7));
            windPlant.setState_id(rs.getInt(8));
            return windPlant;
        });
    }

    public int deletePlant(int id) {
        String query = "DELETE FROM wind_plant WHERE w_plant_id=?";
        return jdbcTemplate.update(query, id);
    }
    public List<Double> getRecentReadings(int plantId) {
        String query = "SELECT reading_value FROM wind_reading WHERE plant_id = ? ORDER BY reading_id DESC LIMIT 10";
        return jdbcTemplate.query(query, new Object[] {plantId}, (rs, rownumber) -> rs.getDouble(1));
    }
}