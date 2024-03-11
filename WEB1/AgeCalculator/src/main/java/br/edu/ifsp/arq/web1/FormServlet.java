package br.edu.ifsp.arq.web1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.parse;

@WebServlet("/send")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FormServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String birthDateString = req.getParameter("data-nascimento");
        LocalDate birthDate = parse(birthDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate todayDate = LocalDate.now();
        if (birthDate.getYear() > todayDate.getYear()) {
            throw new ServletException();
        }else{
            Period diff = Period.between(birthDate, todayDate);
            int age = diff.getYears();
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"pt-BR\">");
            writer.println("<head>");
            writer.println("<title>Resultado</title>");
            writer.println("<meta charset=\"UTF-8\">");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\">");
            writer.println("<link rel=\"stylesheet\" href=\"style.css\">");
            writer.println("</head>");
            writer.println("<body class=\"d-flex justify-content-evenly p-5\">");
            writer.println("<div class=\"d-flex flex-column align-items-center main-container\">");
            writer.println("<p class=\"m-3\">Você  "+age+" ano(s)</p>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();

        }
    }

}
