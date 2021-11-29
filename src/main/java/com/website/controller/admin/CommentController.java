package com.website.controller.admin;


import com.website.models.CommentEntity;
import com.website.service.CommentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-comment-list"})
public class CommentController extends HttpServlet {
    CommentService commentService = new CommentService();
    String url="";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("list")) {
            List<CommentEntity> lstComment = commentService.findAll();
            req.setAttribute("lstComment",lstComment);
            url ="views/admin/view/list-comment.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
