package by.tms.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(servletNames = "HelloServlet" )

public class MyFilter1 extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        if (name.equals("Devil")){
            res.getWriter().println("Invalidate name");
        }else {
            chain.doFilter(req,res);
        }
    }
}
