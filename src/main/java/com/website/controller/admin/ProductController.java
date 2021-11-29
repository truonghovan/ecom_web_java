package com.website.controller.admin;

import com.website.models.BrandEntity;
import com.website.models.DetailCategoryEntity;
import com.website.models.ProductEntity;
import com.website.service.BrandService;
import com.website.service.DetailCategoryService;
import com.website.service.ProductService;
import org.hibernate.service.spi.InjectService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-product-list"})
public class ProductController extends HttpServlet {
//    @Inject
    private ProductService productService;
    private BrandService brandService = new BrandService() ;
    private DetailCategoryService detailCategoryService = new DetailCategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        productService = new ProductService();
        String url="";
        if (type.equals("list")) {
            List<ProductEntity> lstProduct =productService.findAll();
            req.setAttribute("lstProduct",lstProduct);
            url ="views/admin/view/list-product.jsp";

        } else if (type.equals("add")) {
            List<BrandEntity> lstBrand = brandService.findAll();
            List<DetailCategoryEntity> lstDetailCate = detailCategoryService.findAll();
            req.setAttribute("lstDetailCate",lstDetailCate);
            req.setAttribute("lstBrand",lstBrand);
            url ="views/admin/view/add-product.jsp";

        } else if (type.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            ProductEntity productEntity = productService.findById(id);
            List<BrandEntity> lstBrand = brandService.findAll();
            List<DetailCategoryEntity> lstDetailCate = detailCategoryService.findAll();
            req.setAttribute("lstDetailCate", lstDetailCate);
            req.setAttribute("lstBrand", lstBrand);
            req.setAttribute("product",productEntity);
            url = "views/admin/view/edit-product.jsp";

        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
