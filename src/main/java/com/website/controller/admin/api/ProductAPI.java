package com.website.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.models.BrandEntity;
import com.website.models.DetailCategoryEntity;
import com.website.models.ProductEntity;
import com.website.service.BrandService;
import com.website.service.DetailCategoryService;
import com.website.service.ProductService;
import com.website.utils.HttpUtil;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static java.lang.Integer.parseInt;

@MultipartConfig
@WebServlet(urlPatterns = {"/api-admin-product"})
public class ProductAPI extends HttpServlet {

    private ProductService productService = new ProductService();
    private BrandService brandService = new BrandService();
    private DetailCategoryService detailCategoryService = new DetailCategoryService();
    private BrandEntity brandEntity = new BrandEntity();
    private DetailCategoryEntity detailCategoryEntity = new DetailCategoryEntity();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()){
            int loi =0;
            /// Lay gia tri
            if(req.getParameter("productName").equals("")){
                loi++;
                req.setAttribute("error_name","Yêu cầu nhập tên sản phẩm !");
            } else {
                req.setAttribute("name_pro",req.getParameter("productName"));
            }
            if(req.getParameter("price").equals("")){
                loi ++;
                req.setAttribute("error_price","Yêu cầu nhập giá sản phẩm !");
            } else {
                req.setAttribute("price",req.getParameter("price"));
            }
            if(req.getParameter("quantity").equals("")){
                loi ++;
                req.setAttribute("error_quantity","Yêu cầu nhập số lượng sản phẩm !");
            } else {
                req.setAttribute("quantity",req.getParameter("quantity"));
            }
            if (loi == 0){
                String filename = "";
                String name = req.getParameter("productName");
                int price = Integer.parseInt(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                String mota = req.getParameter("ckeditor");
                int detailCateId = Integer.parseInt(req.getParameter("detailCateId"));
                int brandId = Integer.parseInt(req.getParameter("brandId"));

                try {
                    Thread.sleep(3000);

                    ///Tim detailCate va Brand
                    brandEntity = brandService.findById(brandId);
                    detailCategoryEntity = detailCategoryService.findById(detailCateId);

                    ///Luu san pham
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.setProName(name);
                    productEntity.setPrice(price);
                    productEntity.setQuantity(quantity);
                    productEntity.setDescribePro(mota);
                    productEntity.setBrandEntity(brandEntity);
                    productEntity.setDetailCategoryEntity(detailCategoryEntity);

                    try {
                        Part part = req.getPart("image");
                        filename = part.getSubmittedFileName();
                        ///upload anh
                        InputStream is = part.getInputStream();
                        byte []data = new byte[is.available()];

                        is.read(data);
                        String path = req.getRealPath("/") + "image" + File.separator + filename;
                        out.println(path);
                        FileOutputStream fos = new FileOutputStream(path);
                        fos.write(data);
                        fos.close();
                    } catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        //Luu va Chuyen ve trang list san pham
                        productEntity.setImage(filename);
                        productService.save(productEntity);
                        List<ProductEntity> lstProduct =productService.findAll();
                        req.setAttribute("lstProduct",lstProduct);
                        req.getRequestDispatcher("views/admin/view/list-product.jsp").forward(req,resp);
                    }
                }  catch (Exception e){
                    e.printStackTrace();
                    out.println("Error");
                }
            } else {
                List<BrandEntity> lstBrand = brandService.findAll();
                List<DetailCategoryEntity> lstDetailCate = detailCategoryService.findAll();
                req.setAttribute("lstDetailCate",lstDetailCate);
                req.setAttribute("lstBrand",lstBrand);
                req.getRequestDispatcher("views/admin/view/add-product.jsp").forward(req,resp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        ProductEntity product = HttpUtil.of(req.getReader()).toModel(ProductEntity.class);

        productService.update(product);
        mapper.writeValue(resp.getOutputStream(),product);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        Integer id = parseInt(req.getReader().readLine());
        int result= productService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
