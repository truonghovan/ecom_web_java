package com.website.controller.admin.api;

import com.website.models.CategoryEntity;
import com.website.service.CategoryService;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(urlPatterns = {"/api-admin-category"})
public class CategoryAPI extends HttpServlet {

    CategoryService categoryService = new CategoryService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        CategoryEntity category = HttpUtil.of(req.getReader()).toModel(CategoryEntity.class);
        categoryService.save(category);
        mapper.writeValue(resp.getOutputStream(),1);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        CategoryEntity category = HttpUtil.of(req.getReader()).toModel(CategoryEntity.class);
        CategoryEntity cate= categoryService.update(category);
        mapper.writeValue(resp.getOutputStream(),cate);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        Integer id =Integer.parseInt(req.getReader().readLine());
        CategoryEntity categoryEntity = categoryService.findById(id);
        categoryEntity.setStatus(0);
        CategoryEntity cate= categoryService.update(categoryEntity);
        mapper.writeValue(resp.getOutputStream(),cate);
    }
}
