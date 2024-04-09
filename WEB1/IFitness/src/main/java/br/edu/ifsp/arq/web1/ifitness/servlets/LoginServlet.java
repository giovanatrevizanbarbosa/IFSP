package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UserLogin;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UsersReader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = UserLogin.login(email, password);

        RequestDispatcher dispatcher = null;

        if(user != null){
            // armazenar o cookie do usuario logado
            Cookie cookie = new Cookie("loggedUser", email);
            cookie.setMaxAge(60*60*24); // um dia -> 86400 segundos
            resp.addCookie(cookie);

            req.setAttribute("name", user.getName());
            dispatcher = req.getRequestDispatcher("/activity-register.jsp");
        }else{
            // remover cookie
            Cookie[] cookies = req.getCookies();
            if(cookies != null){
                for (Cookie c : cookies){
                    if (c.getName().equals("loggedUser")){
                        c.setMaxAge(0);
                        resp.addCookie(c);
                    }
                }
            }
            req.setAttribute("result", "loginError");
            dispatcher = req.getRequestDispatcher("/login.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
