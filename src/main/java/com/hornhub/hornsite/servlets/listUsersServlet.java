package com.hornhub.hornsite.servlets;

import com.hornhub.hornsite.entities.user;
import com.hornhub.hornsite.model.userDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "listUsersServlet",urlPatterns = "/list-users")
public class listUsersServlet extends HttpServlet {

    private userDao uD;

    public void init() {
        this.uD = new userDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<user> users = null;

        try {
            users = uD.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/listUsers.jsp");
        requestDispatcher.forward(req, resp);
    }
}
