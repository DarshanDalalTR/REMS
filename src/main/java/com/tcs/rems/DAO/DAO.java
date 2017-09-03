package com.tcs.rems.DAO;

import com.tcs.rems.models.SolarNotification;
import com.tcs.rems.models.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import java.time.LocalDateTime;
import java.util.List;

public class DAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public boolean validateUser(UserCredentials user) {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM user_details WHERE user_name = ? AND user_password = ? AND user_role = ?",
                new Object[] {user.getName(), user.getPassword(), user.getRole()},
                Integer.class
        ) > 0;
    }

    public Boolean addSolarPlate(SolarPlate plate) {
        LocalDateTime dateTime = LocalDateTime.now();
        String query = "INSERT into solar_plate (plant_id, plate_name, plate_area, plate_efficiency, qty, plate_perf_ratio, last_updated) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setInt(1, plate.getPlant_id());
            preparedStatement.setString(2, plate.getPlate_name());
            preparedStatement.setDouble(3, plate.getPlate_area());
            preparedStatement.setDouble(4, plate.getPlate_efficiency());
            preparedStatement.setInt(5, plate.getQty());
            preparedStatement.setDouble(6, plate.getPlate_perf_ratio());
            preparedStatement.setString(7, String.valueOf(dateTime));
            return preparedStatement.execute();
        });
    }

    public int editSolarPlate(int plateid, SolarPlate plate) {
        String query = "Update solar_plate SET plate_name=?,plate_area=?,plate_efficiency=?,qty=?,plate_perf_ratio=? WHERE plate_id=?";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, plate.getPlate_name());
            preparedStatement.setDouble(2, plate.getPlate_area());
            preparedStatement.setDouble(3, plate.getPlate_efficiency());
            preparedStatement.setInt(4, plate.getQty());
            preparedStatement.setDouble(5, plate.getPlate_perf_ratio());
            preparedStatement.setInt(6, plateid);
        });
    }

    public List<SolarPlate> getPlateByPlateId(int plateid) {
        String query = "Select plant_id,plate_name,plate_area,plate_efficiency,qty,plate_perf_ratio,last_updated FROM solar_plate WHERE plate_id=?";
        return jdbcTemplate.query(query, new Object[] {plateid}, (rs, rownumber) -> {
            SolarPlate solarPlate = new SolarPlate();
            solarPlate.setPlant_id(rs.getInt(1));
            solarPlate.setPlate_name(rs.getString(2));
            solarPlate.setPlate_area(rs.getDouble(3));
            solarPlate.setPlate_efficiency(rs.getDouble(4));
            solarPlate.setQty(rs.getInt(5));
            solarPlate.setPlate_perf_ratio(rs.getDouble(6));
            solarPlate.setLast_updated(rs.getString(7));
            return solarPlate;
        });
    }

    public List<SolarPlate> getPlatesByPlantId(int plantId) {
        String query = "Select plate_id,plate_name,plate_area,plate_efficiency,qty,plate_perf_ratio,last_updated FROM solar_plate WHERE plant_id=?";
        return jdbcTemplate.query(query, new Object[]{plantId}, (rs, rownumber) -> {
            SolarPlate solarPlate = new SolarPlate();
            solarPlate.setPlate_id(rs.getInt(1));
            solarPlate.setPlate_name(rs.getString(2));
            solarPlate.setPlate_area(rs.getDouble(3));
            solarPlate.setPlate_efficiency(rs.getDouble(4));
            solarPlate.setQty(rs.getInt(5));
            solarPlate.setPlate_perf_ratio(rs.getDouble(6));
            solarPlate.setLast_updated(rs.getString(7));
            return solarPlate;
        });
    }

    public List<SolarPlate> viewPlates() {
        String query = "Select plant_id,plate_name,plate_area,plate_efficiency,qty,plate_perf_ratio,plate_id FROM solar_plate";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            SolarPlate solarPlate = new SolarPlate();
            solarPlate.setPlant_id(rs.getInt(1));
            solarPlate.setPlate_name(rs.getString(2));
            solarPlate.setPlate_area(rs.getDouble(3));
            solarPlate.setPlate_efficiency(rs.getDouble(4));
            solarPlate.setQty(rs.getInt(5));
            solarPlate.setPlate_perf_ratio(rs.getDouble(6));
            solarPlate.setPlate_id(rs.getInt(7));
            return solarPlate;
        });
    }

    public int deletePlate(int id) {
        String query = "DELETE FROM solar_plate WHERE plate_id=?";
        return jdbcTemplate.update(query, id);
    }

    public List<State> getStatesByType(String type) {
        String query = "";
        if (type.equalsIgnoreCase("solar")) {
            query = "SELECT DISTINCT state.state_id, state_name FROM solar_plant INNER JOIN  state ON solar_plant.state_id=state.state_id";
        } else if (type.equalsIgnoreCase("wind")) {
            query = "SELECT DISTINCT state.state_id, state_name FROM wind_plant INNER JOIN  state ON wind_plant.state_id=state.state_id";
        }
        return jdbcTemplate.query(query, (resultSet, i) -> {
            State state = new State();
            state.setState_name(resultSet.getString("state_name"));
            state.setState_id(resultSet.getInt("state_id"));
            return state;
        });
    }

    public List<SolarPlant> getSolarPlantByState(int state_id) {
        String query = "SELECT * FROM solar_plant WHERE state_id=?";
        return jdbcTemplate.query(query, new Object[]{state_id}, (resultSet, i) -> {
            SolarPlant sp = new SolarPlant();
            sp.setAvg_radiation(resultSet.getDouble("avg_radiation"));
            sp.setS_plant_id(resultSet.getInt("s_plant_id"));
            sp.setS_plant_lat(resultSet.getDouble("s_plant_lat"));
            sp.setS_plant_lon(resultSet.getDouble("s_plant_lon"));
            sp.setS_plant_name(resultSet.getString("s_plant_name"));
            return sp;
        });
    }

    public List<WindPlant> getWindPlantByState(int state_id) {
        String query = "SELECT * FROM wind_plant WHERE state_id=?";
        return jdbcTemplate.query(query, new Object[]{state_id}, (resultSet, i) -> {
            WindPlant wp = new WindPlant();
            wp.setWind_speed(resultSet.getDouble("wind_speed"));
            wp.setWind_direction(resultSet.getDouble("wind_direction"));
            wp.setW_plant_name(resultSet.getString("w_plant_name"));
            wp.setW_plant_lon(resultSet.getDouble("w_plant_lon"));
            wp.setW_plant_lat(resultSet.getDouble("w_plant_lat"));
            wp.setW_plant_id(resultSet.getInt("w_plant_id"));
            wp.setAir_density(resultSet.getDouble("air_density"));
            return wp;
        });
    }

    public List<SolarNotification> getNotifications(int plateid) {
        String query = "SELECT solar_notifications.text FROM solar_notifications WHERE plate_id=?";
        return jdbcTemplate.query(query, new Object[]{plateid}, (resultSet, i) -> {
            SolarNotification sn = new SolarNotification();
            sn.setText(resultSet.getString(1));
            return sn;
        });
    }

    public List<SolarPlantWithState> getPlantDetails(int plantid) {
        String query = "Select s_plant_name,state.state_name AS stateName,avg_radiation FROM solar_plant INNER JOIN state ON solar_plant.state_id = state.state_id WHERE s_plant_id=?";
        return jdbcTemplate.query(query, new Object[]{plantid}, (rs, rownumber) -> {
            SolarPlantWithState solarPlant = new SolarPlantWithState();
            solarPlant.setS_plant_name(rs.getString("s_plant_name"));
            solarPlant.setStateName(rs.getString("stateName"));
            solarPlant.setAvg_radiation(rs.getDouble("avg_radiation"));
            return solarPlant;
        });
    }

    public List<State> getAllStates() {
        String query = "Select state_name, state_id FROM state";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            State states = new State();
            states.setState_name(rs.getString("state_name"));
            states.setState_id(rs.getInt("state_id"));
            return states;
        });
    }

    public List<Plants> searchForPlants(String key) {
        String query = "SELECT * FROM ((SELECT state_name AS state,wind_plant.w_plant_name AS plant_name,wind_plant.w_plant_id AS plant_id,'wind' plant_type FROM state INNER JOIN wind_plant ON state.state_id = wind_plant.state_id) UNION (SELECT state_name AS state,solar_plant.s_plant_name AS plant_name,solar_plant.s_plant_id AS plant_id,'solar' plant_type FROM state INNER JOIN solar_plant ON state.state_id = solar_plant.state_id)) AS temp WHERE UPPER(state) LIKE UPPER(?) OR UPPER(plant_name) LIKE UPPER(?) OR UPPER(plant_type) LIKE UPPER(?)";
        String regexpKey = "%" + key + "%";
        return jdbcTemplate.query(query, new Object[]{regexpKey, regexpKey, regexpKey}, (resultSet, i) -> {
            Plants plant = new Plants();
            plant.setPlant_type(resultSet.getString("plant_type"));
            plant.setPlant_name(resultSet.getString("plant_name"));
            plant.setState(resultSet.getString("state"));
            plant.setPlant_id(resultSet.getString("plant_id"));
            return plant;
        });
    }

    public List<GeneralNotification> getAllNotifications() {
        String query = "(SELECT s_plant.s_plant_name as plant,s_plate.plate_name AS component,s_plant.s_plant_id AS plant_id,s_not.text AS notify,'solar' plant_type FROM solar_notifications AS s_not INNER JOIN solar_plate AS s_plate ON s_not.plate_id = s_plate.plate_id INNER JOIN solar_plant AS s_plant ON s_plate.plant_id = s_plant.s_plant_id) UNION (SELECT w_plant.w_plant_name AS plant,w_turbine.turbine_name AS component,w_plant.w_plant_id AS plant_id,w_not.text AS notify,'wind' plant_type FROM wind_notifications w_not INNER JOIN wind_turbine w_turbine ON w_not.turbine_id = w_turbine.turbine_id INNER JOIN wind_plant w_plant ON w_turbine.plant_id = w_plant.w_plant_id)";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            GeneralNotification n = new GeneralNotification();
            n.setNotif(resultSet.getString("notify"));
            n.setPlantComponent(resultSet.getString("component"));
            n.setPlantId(resultSet.getInt("plant_id"));
            n.setPlantName(resultSet.getString("plant"));
            n.setPlantType(resultSet.getString("plant_type"));
            return n;
        });
    }
}
