package main.java.br.edu.ifsp.arq.web1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    @Serial
    private static final long serialVersionUID = 1L;

    public RegisterServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
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
        writer.println("\t<h1>Thanks for registering to our newsletter, "+fullName+".</h1>");
        writer.println("\t<h2>Interests: "+selectedOptions+".</h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }

}