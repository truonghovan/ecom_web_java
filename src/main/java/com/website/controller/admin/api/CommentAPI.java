package com.website.controller.admin.api;

import com.website.models.CommentEntity;
import com.website.service.CommentService;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-comment"})
public class CommentAPI extends HttpServlet {
    CommentService commentService = new CommentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(),1);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        Integer id = Integer.parseInt(req.getReader().readLine());
        CommentEntity commentEntity = commentService.findByID(id);
        commentEntity.setStatus(0);
        commentService.update(commentEntity);

        mapper.writeValue(resp.getOutputStream(),1);
    }
}
