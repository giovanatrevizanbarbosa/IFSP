package br.edu.ifsp.arq.web1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.arq.web1.model.Person;
import br.edu.ifsp.arq.web1.model.PersonUtil;


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
