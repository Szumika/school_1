package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.ExerciseDao;
import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.Exercise;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListController", urlPatterns = {"/userlist"})
public class UserListController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("user_group_id");
    try{
        int group_id = Integer.parseInt(id);
        List<Users> users = UsersDao.findAll(group_id);
        request.setAttribute("Users",users);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/userlist.jsp")
                .forward(request, response);

        }  catch (NumberFormatException e){
        System.out.println("Zlee");
        }
    }
}
