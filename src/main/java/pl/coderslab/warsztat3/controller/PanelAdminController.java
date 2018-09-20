package pl.coderslab.warsztat3.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelAdminController",urlPatterns = {"/panelAdmin"})
public class PanelAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/panelAdmin.jsp")
                .forward(request, response);

    }
}
