package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.dto.ActivityByType;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesReader;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public StatisticsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if (key.equals("type")){
            List<ActivityByType> activityTypeList = ActivitiesReader.getActivitiesStatisticsByType(user);
            Gson gson = new Gson();
            String json = gson.toJson(activityTypeList);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }
}
