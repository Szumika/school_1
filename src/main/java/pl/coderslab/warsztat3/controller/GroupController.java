package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.SolutionDao;
import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.model.Solution;
import pl.coderslab.warsztat3.model.User_Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupController", urlPatterns = {"/group"})
public class GroupController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //TODO change to solution display instead of groups
            List<User_Group> ugList = UserGroupDao.findAll();
            request.setAttribute("groups", ugList);
        getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/group.jsp")
                    .forward(request, response);
    }
}
