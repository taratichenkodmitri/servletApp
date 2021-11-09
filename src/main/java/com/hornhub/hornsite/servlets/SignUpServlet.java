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

@WebServlet(name = "SignUpServlet",urlPatterns = "/sign-up")
public class SignUpServlet extends HttpServlet {
    private UserDao uD;

    @Override
    public void init() {
        this.uD = new UserDao();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/signUp.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        User user = new User(name,password);

        try {
            uD.createUSer(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("userName", name);
        doGet(req, resp);
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