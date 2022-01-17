package com.hornhub.hornsite.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection con = null;
    static
    {
        String url = "jdbc:mysql://localhost:3306/my_db?useSSL=false";
        String user = "tort";
        String pass = "Password123#@!";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}
