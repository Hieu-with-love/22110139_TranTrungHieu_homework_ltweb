package devzeus.com.webapp.controllers.admin;

import devzeus.com.webapp.models.Category;
import devzeus.com.webapp.services.ICategoryService;
import devzeus.com.webapp.services.implement.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/categories")) {
            List<Category> categoryList = categoryService.findAll();
            req.setAttribute("categoryList", categoryList);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        } else if (url.contains("/admin/category/add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/category/insert")) {
            // Get data from form
            String name = req.getParameter("name");
            String image = req.getParameter("image");
            int status = Integer.parseInt(req.getParameter("status"));
            Category category = new Category();
            category.setName(name);
            category.setImage(image);
            category.setStatus(status);
            categoryService.insert(category);
            // transferred model to insert method
            req.setAttribute("category", category);
            // chuyen trang
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}
