package devzeus.com.webapp.controllers.manager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import devzeus.com.webapp.models.UserModel;
import devzeus.com.webapp.services.implement.UserServiceImpl;

import java.io.IOException;
import java.io.Serial;

@WebServlet(urlPatterns = {"/login", "/dang-nhap"})
public class LoginController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhan tham so tu URL
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String alertMsg = "";
        if(username.isEmpty() || password.isEmpty()){
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
        UserServiceImpl service = new UserServiceImpl();
        UserModel user = service.login(username, password);
        if(user!=null){
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            resp.sendRedirect(req.getContextPath()+"/waiting");
        }else{
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
