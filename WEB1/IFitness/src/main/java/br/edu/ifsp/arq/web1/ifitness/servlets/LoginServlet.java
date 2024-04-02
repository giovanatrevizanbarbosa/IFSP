package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UserLogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
            req.setAttribute("name", user.getName());
            dispatcher = req.getRequestDispatcher("/home.jsp");
        }else{
            req.setAttribute("result", "loginError");
            dispatcher = req.getRequestDispatcher("/login.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
