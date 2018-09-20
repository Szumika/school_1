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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/"})
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> solList = SolutionDao.findAll();
        request.setAttribute("solution",solList);
        getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/home.jsp")
                    .forward(request, response);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/userdet.jsp")
                .forward(request, response);
    }
}
