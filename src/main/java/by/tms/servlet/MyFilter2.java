package by.tms.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(servletNames = "HelloServlet")
public class MyFilter2 extends HttpFilter {

    //Application Scope/Servlet Context
    //Session Scope
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    chain.doFilter(req,res);
    }

}
