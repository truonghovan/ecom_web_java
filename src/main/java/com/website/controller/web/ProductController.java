package com.website.controller.web;

import com.website.models.*;
import com.website.service.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/client-product-list"})
public class ProductController extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    DetailCategoryService detailCategoryService = new DetailCategoryService();
    CommentService commentService = new CommentService();
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String type = req.getParameter("type");
        String url = "";
        String keyWord = "";
        int numberpage = 1;
        int pageSize = 9;
        int category_id = -1;
        int detail_cate_id = -1;
        int start_price = -1;
        int end_price = 900000000;
        int brandId = -1;
        Long totalpage;
        Long totalProduct;
        List<ProductEntity> lstProduct = null;

        //chung
        List<CategoryEntity> lstCategory = categoryService.findAll();
        List<BrandEntity> lstBrand = brandService.findAll();
        req.setAttribute("lstCategory",lstCategory);
        req.setAttribute("lstBrand",lstBrand);
        HttpSession session=req.getSession();
        session.setAttribute("theloaicu",type);

        //Rieng theo tung loai
        if (type.equals("list")) {
            numberpage  = Integer.parseInt(req.getParameter("page"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            totalProduct = productService.totalProduct();
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);
        } else if(type.equals("detail_category")){
            numberpage  = Integer.parseInt(req.getParameter("page"));
            detail_cate_id = Integer.parseInt(req.getParameter("detail_cate_id"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            req.setAttribute("detail_cate_id",detail_cate_id);
            totalProduct = productService.totalProduct_detail_category(detail_cate_id);
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);

        } else if(type.equals("Price")){
            numberpage  = Integer.parseInt(req.getParameter("page"));
            start_price = Integer.parseInt(req.getParameter("startPrice"));
            end_price = Integer.parseInt(req.getParameter("endPrice"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            req.setAttribute("start_price",start_price);
            req.setAttribute("end_price",end_price);
            totalProduct = productService.totalProduct_price(start_price,end_price);
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);

        } else if(type.equals("Brand")){
            numberpage  = Integer.parseInt(req.getParameter("page"));
            brandId = Integer.parseInt(req.getParameter("brand_id"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            req.setAttribute("brand_id",brandId);
            totalProduct = productService.totalProduct_brand(brandId);
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);
        } else if(type.equals("searchByName")){
            numberpage  = Integer.parseInt(req.getParameter("page"));
            keyWord = req.getParameter("keyword");
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            req.setAttribute("keyWord",keyWord);
            totalProduct = productService.totalProdcut_keyWord(keyWord);
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);
        } else if(type.equals("category")){
            numberpage  = Integer.parseInt(req.getParameter("page"));
            category_id = Integer.parseInt(req.getParameter("cate_id"));
            lstProduct = productService.getProductEntity(brandId,detail_cate_id,start_price,end_price,keyWord,category_id,(numberpage - 1) * pageSize, pageSize);
            req.setAttribute("lstProduct",lstProduct);
            url ="views/web/shop.jsp";

            ///Rieng theo tung loai
            req.setAttribute("cate_id",category_id);
            totalProduct = productService.totalProdcut_cate(category_id);
            if (totalProduct % pageSize == 0){
                totalpage = totalProduct / pageSize;
            } else {
                totalpage = totalProduct / pageSize + 1;
            }
            if(numberpage == 1){
                req.setAttribute("lastPages", numberpage);
            } else {
                req.setAttribute("lastPages", numberpage - 1);
            }
            if(numberpage == totalpage){
                req.setAttribute("nextPages",numberpage);
            } else {
                req.setAttribute("nextPages",numberpage + 1);
            }
            req.setAttribute("numOfPages",totalpage);
        } else if (type.equals("detail_product")) {
            Integer id =Integer.parseInt(req.getParameter("id"));
            ProductEntity productEntity = productService.findById(id);
            List<CommentEntity> lstComment = commentService.findByProductID(id);
            req.setAttribute("lstComment",lstComment);
            req.setAttribute("productEntity",productEntity);
            url ="views/web/product-details.jsp";
        }

        req.setAttribute("type",type);
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
