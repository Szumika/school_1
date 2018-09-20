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
import java.util.List;

@WebServlet(name = "UsersAdminController",urlPatterns = {"/userAdmin"})
public class UsersAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("admin");
        if(param.equals("dodaj")){
            System.out.println("DOdawanie");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/usersAdd.jsp")
                    .forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("user_id");
        try {
            int id = Integer.parseInt(s);
            Users users = new Users(id);
            request.setAttribute("users",users);
            System.out.println(id);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/usersEdit.jsp")
                    .forward(request, response);
        }catch (NumberFormatException e){
            System.out.println("zle");
        }
        List<Users> users = UsersDao.getAll();
        request.setAttribute("users",users);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/usersAdmin.jsp")
                .forward(request, response);
    }
}
