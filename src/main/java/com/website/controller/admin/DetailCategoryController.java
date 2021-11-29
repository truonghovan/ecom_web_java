package com.website.controller.admin;
import com.website.models.CategoryEntity;
import com.website.models.DetailCategoryEntity;
import com.website.service.CategoryService;
import com.website.service.DetailCategoryService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin-detailcategory-list")
public class DetailCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DetailCategoryService detailCategoryService = new DetailCategoryService();
        CategoryService categoryService = new CategoryService();

        String type = req.getParameter("type");
        String url="";
        if (type.equals("list")) {
            List<DetailCategoryEntity> lstDetailCategory = detailCategoryService.findAll();
            req.setAttribute("lstDetailCategory",lstDetailCategory);
            url="views/admin/view/list-detail-category.jsp";
        } else if (type.equals("add")) {
            List<CategoryEntity> lstCategory = categoryService.findAll();
            req.setAttribute("lstCategory",lstCategory);
            url="views/admin/view/add-detail-category.jsp";
        } else if (type.equals("edit")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            DetailCategoryEntity detailCategory = detailCategoryService.findById(id);
            List<CategoryEntity> lstCategory = categoryService.findAll();
            req.setAttribute("lstCategory",lstCategory);
            req.setAttribute("detailCategory",detailCategory);
            url="views/admin/view/edit-detail-category.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
