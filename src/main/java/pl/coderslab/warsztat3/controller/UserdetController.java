package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.SolutionDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.Solution;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserdetController", urlPatterns = {"/userdet"})
public class UserdetController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("user_id");
    try{
        int user_id = Integer.parseInt(id);
        Users users = UsersDao.getById(user_id);
        request.setAttribute("Users",users);
        List <Solution> solution = SolutionDao.getById(user_id);
        request.setAttribute("Solution",solution);
//        for(int i = 0; i < solution.size();i++){
//            System.out.println(solution.get(i));
//        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/userdet.jsp")
                .forward(request, response);

        }  catch (NumberFormatException e){
        System.out.println("Zlee");
        }
    }
}
