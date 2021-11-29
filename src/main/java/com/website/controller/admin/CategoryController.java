package com.website.controller.admin;

import com.website.models.BrandEntity;
import com.website.models.CategoryEntity;
import com.website.service.BrandService;
import com.website.service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin-category-list")
public class CategoryController  extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String url = "";
        if (type.equals("list")) {
            List<CategoryEntity> lstCategory = categoryService.findAll();
            req.setAttribute("lstCategory", lstCategory);
            url = "views/admin/view/list-category.jsp";
        } else if (type.equals("add")) {
            url = "views/admin/view/add-category.jsp";
        } else if (type.equals("edit")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            CategoryEntity category = categoryService.findById(id);
            req.setAttribute("category", category);
            url = "views/admin/view/edit-category.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
