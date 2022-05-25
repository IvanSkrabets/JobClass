package by.tms.servlet.servlet;

import by.tms.servlet.entity.Operation;
import by.tms.servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final InMemoryOperationStorage storage =
            new InMemoryOperationStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String operation = req.getParameter("operation");
        String num2 = req.getParameter("num2");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        double v = Double.parseDouble(num1);
        double v1 = Double.parseDouble(num2);
        double v2 = 0;
        switch (operation) {
            case "sum":
                v2 = v + v1;
                break;
            case "sub":
                v2 = v - v1;
                break;
            case "mul":
                v2 = v * v1;
                break;
            case "div":
                v2 = v / v1;
                break;
        }
            Operation operation1 = new Operation();
            operation1.setNum1(v);
            operation1.setNum2(v1);
            operation1.setOperation(operation);
            operation1.setUser(currentUser);
            operation1.setDate(LocalDateTime.now());
            storage.save(operation1);
            resp.getWriter().println("result = " + v2);
        }
}
