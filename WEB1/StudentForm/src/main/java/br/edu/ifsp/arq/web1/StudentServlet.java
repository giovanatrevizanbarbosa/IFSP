package br.edu.ifsp.arq.web1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/enviar")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public StudentServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<String> emails = new ArrayList<>();
        String fullName = req.getParameter("fullName");
        String email1 = req.getParameter("email1");
        String email2 = req.getParameter("email2");
        String email3 = req.getParameter("email3");
        emails.add(email1);
        if(email2 != null && !email2.isEmpty()) emails.add(email2);
        if(email3 != null && !email3.isEmpty()) emails.add(email3);
        String[] options = req.getParameterValues("options");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"pt-BR\">");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>Sucesso!</title>");
        writer.println("<link rel=\"stylesheet\" href=\"style.css\">");
        writer.println("</head>");
        writer.println("<body class=\"d-flex justify-content-center p-5\">");
        writer.println("<div class=\"d-flex flex-column align-items-center main-container p-5\">");
        writer.println("<p>Obrigado por se inscrever na nossa newsletter, "+fullName+"!</p>");
        writer.println("<p>Cursos selecionados:</p>");
        writer.println("<ul>");
        for (String option : options) {
            writer.println("<li>" + option + "</li>");
        }
        writer.println("</ul>");
        writer.println("<p>Emails cadastrados:</p>");
        writer.println("<ul>");
        for (String email : emails) {
            writer.println("<li>" + email + "</li>");
        }
        writer.println("</ul>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
