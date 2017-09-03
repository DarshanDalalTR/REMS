package com.tcs.rems.DAO;

import com.tcs.rems.models.WindTurbine;
import com.tcs.rems.models.WindNotification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by darsh on 7/17/2017.
 */
public class WindTurbineDAO {
    private JdbcTemplate jdbcTemplate;

    LocalDateTime dateTime = LocalDateTime.now();

    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public Boolean addWindTurbine(WindTurbine turbine) {
        String query = "INSERT into wind_turbine (plant_id, turbine_name, blade_length, power_coefficient, qty, last_updated) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setInt(1, turbine.getPlant_id());
            preparedStatement.setString(2, turbine.getTurbine_name());
            preparedStatement.setDouble(3, turbine.getBlade_length());
            preparedStatement.setDouble(4, turbine.getPower_coeff());
            preparedStatement.setInt(5, turbine.getQty());
            preparedStatement.setString(6, String.valueOf(dateTime));
            return preparedStatement.execute();
        });
    }

    public int editWindTurbine(int turbineid, WindTurbine turbine) {
        String query = "Update wind_turbine SET turbine_name=?,blade_length=?,power_coefficient=?,qty=? WHERE turbine_id=?";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, turbine.getTurbine_name());
            preparedStatement.setDouble(2, turbine.getBlade_length());
            preparedStatement.setDouble(3, turbine.getPower_coeff());
            preparedStatement.setInt(4, turbine.getQty());
            preparedStatement.setInt(5, turbineid);
        });
    }

    public List<WindTurbine> getTurbineById(int turbineid) {
        String query = "Select turbine_id,turbine_name,blade_length,power_coefficient,qty FROM wind_turbine WHERE turbine_id=?";
        return jdbcTemplate.query(query, new Object[] {turbineid},(rs, rownumber) -> {
            WindTurbine turbine = new WindTurbine();
            turbine.setTurbine_id(rs.getInt(1));
            turbine.setTurbine_name(rs.getString(2));
            turbine.setBlade_length(rs.getDouble(3));
            turbine.setPower_coeff(rs.getDouble(4));
            turbine.setQty(rs.getInt(5));
            return turbine;
        });
    }

    public List<WindTurbine> getTurbinesByPlantId(int plant_id) {
        String query = "Select plant_id,turbine_id,turbine_name,blade_length,power_coefficient,qty FROM wind_turbine WHERE plant_id=?";
        return jdbcTemplate.query(query, new Object[] {plant_id}, (rs, rownumber) -> {
            WindTurbine turbine = new WindTurbine();
            turbine.setPlant_id(rs.getInt(1));
            turbine.setTurbine_id(rs.getInt(2));
            turbine.setTurbine_name(rs.getString(3));
            turbine.setBlade_length(rs.getDouble(4));
            turbine.setPower_coeff(rs.getDouble(5));
            turbine.setQty(rs.getInt(6));
            return turbine;
        });
    }

    public List<WindNotification> getNotifications(int turbineId) {
        String query = "SELECT wind_notifications.text FROM wind_notifications WHERE turbine_id=?";
        return jdbcTemplate.query(query, new Object[] {turbineId},(resultSet, i) -> {
            WindNotification wn=new WindNotification();
            wn.setText(resultSet.getString(1));
            return wn;
        });
    }

    public int deleteTurbine(int id) {
        String query = "DELETE FROM wind_turbine WHERE turbine_id=?";
        return jdbcTemplate.update(query, id);
    }
}
