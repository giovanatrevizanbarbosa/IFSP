package br.edu.ifsp.arq.web1.projetojstl.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.web1.projetojstl.model.Person;
import br.edu.ifsp.arq.web1.projetojstl.model.PersonUtil;


@WebServlet("/ServletPeople")
public class ServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ServletController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("people");
		PersonUtil personlUtil = new PersonUtil();
		List<Person> list = personlUtil.getPeople(data);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}

}
