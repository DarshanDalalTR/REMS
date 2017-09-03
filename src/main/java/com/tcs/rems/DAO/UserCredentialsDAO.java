package com.tcs.rems.DAO;

import com.tcs.rems.models.UserCredentials;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.util.List;

/**
 * Created by darsh on 7/16/2017.
 */
public class UserCredentialsDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean addUser(UserCredentials user)
    {
        String query="INSERT into user_details (user_name, user_password, user_email, user_role) VALUES (?,?,?,?)";
        return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) preparedStatement -> {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(4, user.getRole());
            return preparedStatement.execute();
        });
    }

    public int editUser(int user_id, UserCredentials user)
    {
        String query="Update user_details SET user_name=?,user_email=?,user_role=? WHERE user_id=?";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setInt(3, user.getRole());
            preparedStatement.setInt(4, user_id);
        });
    }

    public List<UserCredentials> getUserById(int userid)
    {
        String query="Select user_name, user_email, user_role FROM user_details WHERE user_id=?";
        return jdbcTemplate.query(query, new Object[] {userid},(rs, rownumber) -> {
            UserCredentials user = new UserCredentials();
            user.setName(rs.getString(1));
            user.setEmail(rs.getString(2));
            user.setRole(rs.getInt(3));
            return user;
        });
    }

    public List<UserCredentials> viewUsers()
    {
        String query="Select * FROM user_details";
        return jdbcTemplate.query(query, (rs, rownumber) -> {
            UserCredentials user = new UserCredentials();
            user.setId(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setEmail(rs.getString(4));
            user.setRole(rs.getInt(5));
            return user;
        });
    }

    public int deleteUser(int id)
    {
        String query="DELETE FROM user_details WHERE user_id=?";
        return jdbcTemplate.update(query, id);
    }
}
