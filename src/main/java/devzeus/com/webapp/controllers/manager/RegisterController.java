package devzeus.com.webapp.controllers.manager;

import devzeus.com.webapp.models.UserModel;
import devzeus.com.webapp.services.IUserService;
import devzeus.com.webapp.services.implement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/register", "/dang_ky"})
public class RegisterController extends HttpServlet {
    IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "Đăng nhập thành công";
        // get value of parameter from form
        String username = req.getParameter("username");
        String password = req.getParameter("psw");
        String retypePassword = req.getParameter("psw-repeat");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        if (username.isEmpty()){
            msg = "username này đã tồn tại";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }
        if (password.isEmpty()){
            msg = "Mật khẩu không được để trống";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }
        if (password.isEmpty()){
            msg = "Vui lòng nhập lại mật khẩu";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }
        if (!password.equals(retypePassword)){
            msg = "Mật nhập lại không trùng khớp";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);
        }

        // user verify
        UserModel user = new UserModel(username, password, email, fullName, LocalDate.now(), phone);
        userService.register(user);
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }
}
