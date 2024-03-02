package br.edu.ifsp.arq.web1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public HelloWorldServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html lang=\"pt-BR\">");
        writer.println("<head>");
        writer.println("\t<title>Resposta<title>");
        writer.println("\t<meta charset=\"UTF-8\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("\t<h1>Seja bem vindo(a), "+fullName+"</h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }

}
