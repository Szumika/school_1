package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.model.User_Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerAddGroupController",urlPatterns = {"/managerAddGroup"})
public class ManagerAddGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    User_Group group = new User_Group(name);
        UserGroupDao.create(group);
        System.out.println("Dodano grp");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/operacje.jsp")
                .forward(request, response);
    }
}
