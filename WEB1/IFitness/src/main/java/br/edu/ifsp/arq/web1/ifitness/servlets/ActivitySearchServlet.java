package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.ActivityType;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesFilter;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesReader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/activitySearch")
public class ActivitySearchServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ActivitySearchServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        ActivityType activityType = null;
        String date = req.getParameter("initial-date");
        LocalDate initialDate = null;
        LocalDate finalDate = null;

        if(!type.isEmpty()) {
            activityType = ActivityType.valueOf(type.toUpperCase());
        }
        if(!date.isEmpty()) {
            initialDate = LocalDate.parse(date);
        }
        date = req.getParameter("final-date");
        if(!date.isEmpty()) {
            finalDate = LocalDate.parse(date);
        }

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        ActivitiesFilter filter = new ActivitiesFilter();

        filter.setUser(user);
        filter.setType(activityType);
        filter.setInitialDate(initialDate);
        filter.setFinalDate(finalDate);
        List<Activity> userActivities = null;
        userActivities = ActivitiesReader.getActivityByFilter(filter);
        req.setAttribute("userActivities", userActivities);
        req.setAttribute("activityType", activityType);
        req.setAttribute("initialDate", initialDate);
        req.setAttribute("finalDate", finalDate);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }
}
