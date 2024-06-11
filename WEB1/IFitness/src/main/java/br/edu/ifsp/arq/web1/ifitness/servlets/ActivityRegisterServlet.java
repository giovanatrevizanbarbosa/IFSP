package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.ActivityType;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesReader;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesWriter;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        Long id = Long.parseLong(req.getParameter("id"));
        ActivityType type = ActivityType.valueOf
                (req.getParameter("type"));
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        Double distance =
                Double.parseDouble(req.getParameter("distance"));
        Double duration =
                Double.parseDouble(req.getParameter("duration"));

        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");
        Activity activity = new Activity();
        activity.setType(type);
        activity.setDate(date);
        activity.setDistance(distance);
        activity.setDuration(duration);
        activity.setUser(user);
        if(id == 0) {
            if(ActivitiesWriter.write(activity)) {
                req.setAttribute("result", "registered");
            }
        }else {
            activity.setId(id);
            if(ActivitiesWriter.update(activity)) {
                req.setAttribute("result", "registered");
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/activity-register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        var activityIdParam = req.getParameter("activity-id");

        String url = null;
        if(activityIdParam != null){
            Long activityId = Long.parseLong(activityIdParam);
            Activity activity = ActivitiesReader.findById(activityId);
            RequestDispatcher dispatcher = null;
            if(activity != null) {
                if(action.equals("update")) {
                    req.setAttribute("activity", activity);
                    url = "/activity-register.jsp";
                    dispatcher = req.getRequestDispatcher(url);
                    dispatcher.forward(req, resp);
                }
                if(action.equals("remove")) {
                    Boolean response = ActivitiesWriter.delete(activity);
                    Gson gson = new Gson();
                    String json = gson.toJson(response);
                    resp.setContentType("application/json");
                    resp.getWriter().write(json.toString());
                }
            }else {
                url = "/homeServlet";
                dispatcher = req.getRequestDispatcher(url);
                dispatcher.forward(req, resp);
            }
        }else{
            url = "/activity-register.jsp";
        }
    }
}
