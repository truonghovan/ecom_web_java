package com.website.controller.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.models.*;
import com.website.service.CommentService;
import com.website.service.ProductService;
import com.website.utils.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/api-user-comment"})
public class CommentAPI extends HttpServlet {
    CommentService commentService = new CommentService();
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        CommentEntity comment = HttpUtil.of(req.getReader()).toModel(CommentEntity.class);

        HttpSession session = req.getSession();
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
            return;
        }
        if (comment.getCommentEntity().getId() == 0) {
            comment.setCommentEntity(null);
        }
        ProductEntity product = productService.findById(comment.getProductEntity().getId());
        comment.setUserEntity(user);
        comment.setStatus(1);
        comment.setId(1);
        comment.setProductEntity(product);
        commentService.save(comment);
        mapper.writeValue(resp.getOutputStream(),comment.getUserEntity().getFullname());
    }
}
