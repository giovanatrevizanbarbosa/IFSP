package br.edu.ifsp.arq.web1.ifitness.servlets;

import br.edu.ifsp.arq.web1.ifitness.model.Gender;
import br.edu.ifsp.arq.web1.ifitness.model.User;
import br.edu.ifsp.arq.web1.ifitness.model.util.users.UsersWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserRegisterServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String gender = req.getParameter("gender");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setDateOfBirth(LocalDate.parse(dateOfBirth));
        user.setGender(Gender.valueOf(gender));

        RequestDispatcher dispatcher = null;

        if(UsersWriter.write(user)){
            req.setAttribute("result", "registered");
            dispatcher = req.getRequestDispatcher("/login.jsp");
        }else{
            req.setAttribute("result", "notRegistered");
            dispatcher = req.getRequestDispatcher("user-register.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
