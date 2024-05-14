package br.edu.ifsp.arq.web1.ifitness.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StatisticsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        String url;

        HttpSession session = req.getSession(false);
        if (session.getAttribute("user") == null) {
            url = "/login.jsp";
        }else{
            url = "/statistics.jsp";
        }
        dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
