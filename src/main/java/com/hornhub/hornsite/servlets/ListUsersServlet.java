package com.hornhub.hornsite.servlets;

import com.hornhub.hornsite.entities.User;
import com.hornhub.hornsite.model.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
        req.setAttribute("Users", Users);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/listUsers.jsp");
        requestDispatcher.forward(req, resp);
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
