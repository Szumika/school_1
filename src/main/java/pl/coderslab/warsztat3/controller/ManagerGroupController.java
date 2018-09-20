package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.model.User_Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerGroupController",urlPatterns = {"/managerGroup"})
public class ManagerGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String idik = request.getParameter("id");
    try{
        int id = Integer.parseInt(idik);
        User_Group userGroup = new User_Group(id,name);
        UserGroupDao.update(userGroup);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/operacje.jsp")
                .forward(request, response);
    }catch (NumberFormatException e){
        System.out.println("Zle");
    }

    }
}
