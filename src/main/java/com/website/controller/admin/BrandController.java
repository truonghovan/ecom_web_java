package com.website.controller.admin;

import com.website.models.BrandEntity;
import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.service.BrandService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-brand-list"})
public class BrandController extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type= req.getParameter("type");
        String url ="";

        HttpSession session = req.getSession();
        UserEntity userEntity =(UserEntity) session.getAttribute("user");

        if (userEntity == null || !userEntity.getRole().equals("1")) {
            url= "views/web/login.jsp";
        } else {
            if (type.equals("list")) {
                List<BrandEntity> lstBrand= brandService.findAll();
                req.setAttribute("lstBrand",lstBrand);
                url="views/admin/view/list-brand.jsp";
            } else if (type.equals("add")) {
                url="views/admin/view/add-brand.jsp";
            } else if (type.equals("edit")) {
                Integer id= Integer.parseInt(req.getParameter("id"));
                BrandEntity brand = brandService.findById(id);
                req.setAttribute("brand",brand);
                url="views/admin/view/edit-brand.jsp";
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
