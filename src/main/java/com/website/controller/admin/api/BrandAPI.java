package com.website.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.models.BrandEntity;
import com.website.models.ProductEntity;
import com.website.service.BrandService;
import com.website.utils.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-brand"})
public class BrandAPI extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        BrandEntity brand = HttpUtil.of(req.getReader()).toModel(BrandEntity.class);

        brandService.save(brand);
        mapper.writeValue(resp.getOutputStream(),brand);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        BrandEntity newBrand = HttpUtil.of(req.getReader()).toModel(BrandEntity.class);
        BrandEntity brand = brandService.update(newBrand);
        mapper.writeValue(resp.getOutputStream(),brand);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json"); //
        // Convert from type json to Model
        Integer id = Integer.parseInt(req.getReader().readLine());
        int result = brandService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
