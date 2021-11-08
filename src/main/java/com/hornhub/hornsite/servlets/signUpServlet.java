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

@WebServlet(name = "signUpServlet",urlPatterns = "/sign-up")
public class signUpServlet extends HttpServlet {
    private userDao uD;

    @Override
    public void init() {
        this.uD = new userDao();
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

        user user = new user(name,password);

        try {
            uD.registerUSer(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("userName", name);
        doGet(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed");
    }
}