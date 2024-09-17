package devzeus.com.webapp.controllers.manager;

import devzeus.com.webapp.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/waiting")
public class WaitingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if(session != null && session.getAttribute("account") != null) {
            UserModel u=(UserModel) session.getAttribute("account");
            req.setAttribute("username", u.getUsername());
            if(u.getRoleid()==1) {
                resp.sendRedirect(req.getContextPath()+"/views/user/home.jsp");
            }else if(u.getRoleid()==2) {
                resp.sendRedirect(req.getContextPath()+"/views//admin/home");
            }else {
                resp.sendRedirect(req.getContextPath()+"/views//manager/home");
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/views/login");
        }
    }
}