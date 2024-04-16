package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.Activity;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.activity.ActivitiesReader;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UsersReader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");

        RequestDispatcher dispatcher = null;

        if(user != null){
            // buscar a lista de atividades do usuário logado
            List<Activity> userActivities = ActivitiesReader.readByUser(user);
            req.setAttribute("userActivities", userActivities);
            req.setAttribute("name", user.getName());

            dispatcher = req.getRequestDispatcher("/home.jsp");
        }else{
            // remover cookie
            Cookie[] cookies = req.getCookies();
            if(cookies != null){
                for (Cookie c : cookies){
                    if (c.getName().equals("loggedUser")){
                        user = UsersReader.findUserByEmail(c.getValue());
                    }
                }
            }
            if(user != null) {
                // buscar a lista de atividades do usuário logado
                List<Activity> userActivities = ActivitiesReader.readByUser(user);
                req.setAttribute("userActivities", userActivities);
                req.setAttribute("name", user.getName());

                dispatcher = req.getRequestDispatcher("/home.jsp");
            }else{
                req.setAttribute("result", "loginError");
                dispatcher = req.getRequestDispatcher("/login.jsp");
            }
        }

        dispatcher.forward(req, resp);
    }
}
