package by.tms.servlet.servlet;

import by.tms.servlet.entity.Operation;
import by.tms.servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/findHistory")
public class FindHistoreServlet extends HttpServlet {

    private final InMemoryOperationStorage storage =
            new InMemoryOperationStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        List<Operation> allOperationByUsername = storage.findAllOperationByUsername(currentUser.getUserName());
       for (Operation operation : allOperationByUsername) {
           resp.getWriter().println(operation);
       }
    }
}
