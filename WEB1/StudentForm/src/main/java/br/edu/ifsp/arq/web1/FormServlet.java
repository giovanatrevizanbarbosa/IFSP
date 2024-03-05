package br.edu.ifsp.arq.web1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/enviar")
public class FormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public FormServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        String email1 = req.getParameter("email1");
        String email2 = req.getParameter("email2");
        String email3 = req.getParameter("email3");
        String [] options = req.getParameterValues("options");
        StringBuilder selectedOptions = new StringBuilder();
        for(String opt: options){
            selectedOptions.append(opt).append(" ");
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html lang=\"pt-BR\">");
        writer.println("<head>");
        writer.println("\t<title>Success<title>");
        writer.println("\t<meta charset=\"UTF-8\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("\t<h1>Aluno: "+fullName+".</h1>");
        writer.println("\t<h1>Email Principal: "+email1+".</h1>");
        if (email2 != null) writer.println("\t<h1>Email Opcional: "+email2+".</h1>");
        if (email3 != null) writer.println("\t<h1>Email Opcional: "+email3+".</h1>");
        writer.println("\t<h2>Cursos escolhidos: "+selectedOptions+".</h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
