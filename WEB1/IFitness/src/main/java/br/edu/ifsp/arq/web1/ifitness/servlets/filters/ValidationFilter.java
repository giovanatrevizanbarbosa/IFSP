package br.edu.ifsp.arq.web1.ifitness.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpResponse;

@WebFilter(
        urlPatterns = {
                "/homeServlet"
               ,"/activityRegister"
               ,"/home.jsp"
               ,"/activity-register.jsp"
               , "/activitySearch"}
       ,filterName = "Authorization")
public class ValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else{
            chain.doFilter(request, response);
        }
    }
}
