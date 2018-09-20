package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.User_Group;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerAddUsersController",urlPatterns = {"/managerAddUsers"})
public class ManagerAddUsersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String id = request.getParameter("group_id");
    try{
        int group_id = Integer.parseInt(id);
        Users user = new Users(name,email,password,group_id);
        UsersDao.create(user);
        System.out.println("Dodano usera");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/operacje.jsp")
                .forward(request, response);
    }catch (NumberFormatException e ){
        System.out.println("Zle");
    }

    }
}
