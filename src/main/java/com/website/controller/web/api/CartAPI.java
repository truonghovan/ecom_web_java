package com.website.controller.web.api;

import com.website.models.CartEntity;
import com.website.models.ProductEntity;
import com.website.models.Product_Cart_Entity;
import com.website.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/api-user-cart"})
public class CartAPI extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        int quantity=1;
        int id = Integer.parseInt(req.getReader().readLine());
        ProductEntity productEntity = productService.findById(id);
        if (productEntity != null){
            HttpSession session = req.getSession();
            if (session.getAttribute("order")==null) {
                CartEntity cartEntity = new CartEntity();
                List<Product_Cart_Entity> lstCartItem = new ArrayList<Product_Cart_Entity>();
                Product_Cart_Entity cartItem = new Product_Cart_Entity();

                cartItem.setProductEntity(productEntity);
                cartItem.setUnitPrice(productEntity.getPrice());
                cartItem.setQuantity(quantity);
                lstCartItem.add(cartItem);
                cartEntity.setProductCartEntityList(lstCartItem);

                session.setAttribute("order",cartEntity);
            } else {
                CartEntity cartEntity =  (CartEntity) session.getAttribute("order");
                List<Product_Cart_Entity> lstCartItem = cartEntity.getProductCartEntityList();
                boolean check=false;
                for(Product_Cart_Entity item : lstCartItem) {
                    if (item.getProductEntity().getId()==id){
                        item.setQuantity(item.getQuantity()+quantity);
                        check=true;
                    }
                }
                if (check==false) {
                    Product_Cart_Entity Product_Cart_Entity = new Product_Cart_Entity();

                    Product_Cart_Entity cartItem = new Product_Cart_Entity();

                    cartItem.setProductEntity(productEntity);
                    cartItem.setUnitPrice(productEntity.getPrice());
                    cartItem.setQuantity(quantity);
                    lstCartItem.add(cartItem);
                    cartEntity.setProductCartEntityList(lstCartItem);
                }
                cartEntity.setProductCartEntityList(lstCartItem);
                session.setAttribute("order",cartEntity);
            }

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=req.getParameter("type");
        System.out.println(type);
        int productId = Integer.parseInt(req.getReader().readLine());
        HttpSession session = req.getSession();
        CartEntity cartModel =  (CartEntity) session.getAttribute("order");
        List<Product_Cart_Entity> lstCartItem = cartModel.getProductCartEntityList();


        PrintWriter out=resp.getWriter();
        resp.setContentType("text/html");

        for(Product_Cart_Entity item : lstCartItem) {
            if (item.getProductEntity().getId()==productId){
                if (type.equals("add")) {
                    if (item.getQuantity() >= item.getProductEntity().getQuantity()){
                        // Nếu trong kho hết hàng thi không cho thêm
                    }
                    else {
                        item.setQuantity(item.getQuantity() + 1);
                    }

                } else if (type.equals("sub") && item.getQuantity() > 1){
                    item.setQuantity(item.getQuantity() - 1);
                } else if (type.equals("del")){
                    lstCartItem.remove(item);
                }

            }
        }
        cartModel.setProductCartEntityList(lstCartItem);
        session.setAttribute("order",cartModel);

        String url ="/client-cart-list";
        resp.sendRedirect(req.getContextPath()+url);
    }
}
