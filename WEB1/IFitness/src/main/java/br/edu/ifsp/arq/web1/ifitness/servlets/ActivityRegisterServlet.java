package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.ActivityType;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesWriter;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UsersReader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/activityRegister")
public class ActivityRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ActivityRegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActivityType type = ActivityType.valueOf(req.getParameter("type"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        Double distance = Double.parseDouble(req.getParameter("distance"));
        Double duration = Double.parseDouble(req.getParameter("duration"));
        User user = null;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie c : cookies){
                if (c.getName().equals("loggedUser")){
                    user = UsersReader.findUserByEmail(c.getValue());
                }
            }
        }

        RequestDispatcher dispatcher = null;

        if(user != null){
            Activity activity = new Activity();
            activity.setType(type);
            activity.setDate(date);
            activity.setDistance(distance);
            activity.setDuration(duration);
            activity.setUser(user);

            if(ActivitiesWriter.write(activity)) {
                req.setAttribute("result", "registered");
                dispatcher = req.getRequestDispatcher("/activity-register.jsp");
            }
        }else{
            req.setAttribute("result", "notRegistered");
            dispatcher = req.getRequestDispatcher("/activity-register.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
