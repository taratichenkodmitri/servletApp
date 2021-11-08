package com.hornhub.hornsite.model;

import com.hornhub.hornsite.entities.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDao {

    static Connection con = DataBaseConnection.getConnection();

    public static int registerUSer(user user) throws SQLException {

        String INSERT_USER_SQL = "INSERT INTO users" + "(name, password) VALUES " + "(?,?)";
        PreparedStatement ps = con.prepareStatement(INSERT_USER_SQL);

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        int result = ps.executeUpdate();
        return result;

    }

    public void delete(int id) throws SQLException {

        String query = "delete from users where id =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    public List<user> getUsers() throws SQLException {

        String query = "select * from users";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<user> users_list = new ArrayList();

        while (rs.next()) {

            user u = new user();

            u.setUsername(rs.getString("name"));
            u.setPassword(rs.getString("password"));

            users_list.add(u);

        }
        return users_list;
    }

}
