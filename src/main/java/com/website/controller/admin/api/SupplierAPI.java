package com.website.controller.admin.api;

import com.website.models.CategoryEntity;
import com.website.models.SupplierEntity;
import com.website.service.SupplierService;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api-admin-supplier")
public class SupplierAPI extends HttpServlet {
    SupplierService supplierService = new SupplierService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        SupplierEntity supplier = HttpUtil.of(req.getReader()).toModel(SupplierEntity.class);
        supplierService.save(supplier);
        mapper.writeValue(resp.getOutputStream(),1);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        SupplierEntity supplier = HttpUtil.of(req.getReader()).toModel(SupplierEntity.class);
        SupplierEntity newsupplier= supplierService.update(supplier);
        mapper.writeValue(resp.getOutputStream(),newsupplier);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        Integer id = Integer.parseInt(req.getReader().readLine());
        int result = supplierService.delete(id);
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
