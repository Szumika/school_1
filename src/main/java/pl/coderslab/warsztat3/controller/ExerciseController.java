package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.ExerciseDao;
import pl.coderslab.warsztat3.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseController", urlPatterns = {"/exercise"})
public class ExerciseController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("exercise_id");
    try{
        int exercise_id = Integer.parseInt(id);
        Exercise exercise = ExerciseDao.getById(exercise_id);
        request.setAttribute("Exercise",exercise);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/exercise.jsp")
                .forward(request, response);



    }catch (NumberFormatException e){
        System.out.println("Zlee");
    }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
