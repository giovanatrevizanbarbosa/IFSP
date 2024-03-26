package br.edu.ifsp.arq.web1.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.web1.controller.UserController;
import br.edu.ifsp.arq.web1.model.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserUtil userUtil = new UserUtil();
		UserController controller = UserController.getInstance();
		
		request.setAttribute("email", email);
		
		if(controller.authtenticateUser(userUtil.getUser(email, password))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(request, response);
		}else {
			throw new ServletException();
		}
		
	}

}
