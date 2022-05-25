package by.tms.servlet.servlet;

import by.tms.servlet.entity.User;
import by.tms.servlet.storage.ImMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/auth")
public class AuthentificationServlet extends HttpServlet {

    private final ImMemoryUserStorage imMemoryUserStorage =
            new ImMemoryUserStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUSername = imMemoryUserStorage.findByUSername(username);
        if(byUSername.isPresent()) {
            User user = byUSername.get();
            if (user.getUserName().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
            } else {
                resp.getWriter().println("Wrong password");
            }
        }else {
            resp.getWriter().println("User not found");
        }
    }
}
