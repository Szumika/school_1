package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.model.User_Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupAdminController",urlPatterns = {"/groupAdmin"})
public class GroupAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String param = request.getParameter("admin");
    if(param.equals("dodaj")){
        System.out.println("DOdawanie");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/groupAdd.jsp")
                .forward(request, response);
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("user_group_id");
        try {
            int id1 = Integer.parseInt(s);
            User_Group user_groups = new User_Group(id1);
            request.setAttribute("groups",user_groups);
            System.out.println(id1);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/groupEdit.jsp")
                    .forward(request, response);
        }catch (NumberFormatException e){
            System.out.println("zle");
        }
        List<User_Group> group = UserGroupDao.findAll();
        request.setAttribute("groups", group);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/groupAdmin.jsp")
                .forward(request, response);

    }
}
