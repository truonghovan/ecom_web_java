package com.website.controller.admin.api;

import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.service.CartService;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-cart"})
public class CartAPI extends HttpServlet {
    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        Integer id = Integer.parseInt(req.getReader().readLine());
        CartEntity cartEntity = cartService.findById(id);
        cartEntity.setStatus(cartEntity.getStatus()%4+1);
        if (cartEntity.getStatus()==3) {
            cartEntity.setStatus(cartEntity.getStatus()+1);
        }
        CartEntity cartEntity1 = cartService.update(cartEntity);
        mapper.writeValue(resp.getOutputStream(),cartEntity1);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        Integer id = Integer.parseInt(req.getReader().readLine());
        int result = cartService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
