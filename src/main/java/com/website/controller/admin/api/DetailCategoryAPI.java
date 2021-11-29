package com.website.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.dao.DetailCategoryDAO;
import com.website.models.DetailCategoryEntity;
import com.website.service.DetailCategoryService;
import com.website.utils.HttpUtil;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-detailcategory"})
public class DetailCategoryAPI extends HttpServlet {
    DetailCategoryService detailCategoryService = new DetailCategoryService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model

        DetailCategoryEntity detailCategoryEntity = HttpUtil.of(req.getReader()).toModel(DetailCategoryEntity.class);

        detailCategoryService.save(detailCategoryEntity);
        mapper.writeValue(resp.getOutputStream(),detailCategoryEntity);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model

        Integer id = Integer.parseInt(req.getReader().readLine());
        DetailCategoryEntity newDetailCate = detailCategoryService.findById(id);

        DetailCategoryEntity detailCate= detailCategoryService.update(newDetailCate);
        mapper.writeValue(resp.getOutputStream(),detailCate);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model

        Integer id =Integer.parseInt(req.getReader().readLine());
        int result = detailCategoryService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
