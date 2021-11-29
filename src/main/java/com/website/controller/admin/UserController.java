package com.website.controller.admin;

import com.website.models.UserEntity;
import com.website.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-user-list"})
public class UserController extends HttpServlet {
    UserService userService = new UserService();
    String url="";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("list")) {
            List<UserEntity> lstUser = userService.findAll();
            req.setAttribute("lstUser",lstUser);
            url = "views/admin/view/list-user.jsp";
        } else if (type.equals("add")) {
            url = "views/admin/view/add-user.jsp";
        } else if (type.equals("edit")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            UserEntity userEntity= userService.findById(id);
            req.setAttribute("user",userEntity);
            url = "views/admin/view/edit-user.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
