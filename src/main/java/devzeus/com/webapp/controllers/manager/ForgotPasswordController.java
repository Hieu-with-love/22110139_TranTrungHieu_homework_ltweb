package devzeus.com.webapp.controllers.manager;

import devzeus.com.webapp.models.UserModel;
import devzeus.com.webapp.services.IUserService;
import devzeus.com.webapp.services.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/forgot-password", "/quen-mat-khau"})
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/forgot-password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        UserModel user = userService.findByUserName(username);
        if (user != null && user.getEmail().equals(email)) {
            req.setAttribute("password", user.getPassword());
        }
        else{
            req.setAttribute("error", "Invalid email");
        }
        req.getRequestDispatcher("/views/web/forgot-password.jsp").forward(req, resp);
    }
}
