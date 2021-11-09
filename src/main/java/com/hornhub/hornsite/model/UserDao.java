package com.hornhub.hornsite.model;

import com.hornhub.hornsite.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    static Connection con = DataBaseConnection.getConnection();

    public int createUSer(User user) throws SQLException {

        String INSERT_USER_SQL = "INSERT INTO users" + "(name, password) VALUES " + "(?,?)";
        PreparedStatement ps = con.prepareStatement(INSERT_USER_SQL);

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        int result = ps.executeUpdate();
        return result;

    }

    public boolean deleteUser(int id) throws SQLException {

        boolean status = false;
        String query = "delete from users where id =?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        status = ps.executeUpdate() > 0;

        return status;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean status = false;
        String UPDATE_USERS_SQL = "update users set name = ?,password= ? where id = ?;";

        PreparedStatement ps = con.prepareStatement(UPDATE_USERS_SQL);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(2, user.getPassword());
        status = ps.executeUpdate() > 0;

        return status;
    }

    public User readUser(int id) throws SQLException {

        User user = null;
        String SELECT_USER_BY_ID = "select id,name,password from users where id =?";

        PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            String name = rs.getString("name");
            String password = rs.getString("password");

            user = new User(id, name, password);
        }
        return user;
    }



    public List<User> getAllUsers() throws SQLException {

        String query = "select * from users";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<User> users_list = new ArrayList();

        while (rs.next()) {

            User u = new User();

            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("name"));
            u.setPassword(rs.getString("password"));

            users_list.add(u);

        }
        return users_list;
    }

    public void closeConnection() throws SQLException {
        DataBaseConnection.closeConnection();
    }
}
