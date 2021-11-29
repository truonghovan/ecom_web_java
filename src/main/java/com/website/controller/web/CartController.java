package com.website.controller.web;

import com.website.models.CartEntity;
import com.website.models.Product_Cart_Entity;
import com.website.models.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/client-cart-list"})
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartEntity cartEntity =  (CartEntity) session.getAttribute("order");
        UserEntity user = (UserEntity) session.getAttribute("user");
        Integer totalPrice =0;
        String url ="";

        req.setAttribute("totalPrice",totalPrice);
        req.setAttribute("user",user);
        if (cartEntity != null) {
            List<Product_Cart_Entity> cartItemModelList = cartEntity.getProductCartEntityList();
            req.setAttribute("cartItemModelList",cartItemModelList);

            for(Product_Cart_Entity item: cartItemModelList) {
                totalPrice += item.getUnitPrice() * item.getQuantity();
            }
            cartEntity.setTotalPrice(totalPrice);
            req.setAttribute("totalPrice",totalPrice);
        }
        if (user!=null) {
            url ="views/web/cart.jsp";
        } else {
            url="views/web/login.jsp";
        }
        ;
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
