package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

//URI
@WebServlet(urlPatterns = "/hello",name = "HelloServlet", loadOnStartup = 0)
public class HelloServlet extends HttpServlet {
    // GET POST PUT DELETE

private final AtomicInteger atomicInteger = new AtomicInteger();

@Override
    public void init() throws ServletException {
        System.out.println("Init Hello Servlet");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Hello Servlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
//        atomicInteger.incrementAndGet();
//        customGet(req, resp);
    }

//    private void customGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        resp.getWriter().println("<h1>Hello" + name + "</h1>");
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("name");
       req.setAttribute("name", name);
       resp.sendRedirect("/test");
//       getServletContext().getRequestDispatcher("/test").forward(req,resp);
      // getServletContext().setAttribute("name", name);
       // req.getSession().setAttribute("name", name);
      // resp.getWriter().println("<h1>Hello"+ name + "</h1>");





    }



}
