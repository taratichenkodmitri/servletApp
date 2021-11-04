package com.hornhub.hornsite.servlets;

import com.hornhub.hornsite.model.dataController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listUsersServlet",urlPatterns = "/list-users")
public class listUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dataController data = dataController.getInstance();
        List<String> names = data.list();
        req.setAttribute("userNames", names);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/listUsers.jsp");
        requestDispatcher.forward(req, resp);
    }
}
