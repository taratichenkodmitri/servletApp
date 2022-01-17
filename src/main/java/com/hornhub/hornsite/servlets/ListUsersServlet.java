package com.hornhub.hornsite.servlets;

import com.hornhub.hornsite.entities.User;
import com.hornhub.hornsite.model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import com.google.gson.Gson;

@WebServlet(name = "ListUsersServlet",urlPatterns = "/list-users")
public class ListUsersServlet extends HttpServlet {

    private UserDao uD;

    @Override
    public void init() {
        this.uD = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> Users = null;

        try {
            Users = uD.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String userJsonString = gson.toJson(Users);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(userJsonString);
    }

    @Override
    public void destroy() {
        try {
            uD.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Servlet is being destroyed");
    }
}
