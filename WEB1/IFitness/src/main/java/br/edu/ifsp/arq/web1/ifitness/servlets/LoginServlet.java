package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UserLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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

        String url;

        User user = UserLogin.login(email, password);

        if(user != null){
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(3600);
            session.setAttribute("user", user);
            url = "/homeServlet";
        }else{
            req.setAttribute("result", "loginError");
            url = "/login.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
