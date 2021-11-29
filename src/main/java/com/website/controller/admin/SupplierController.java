package com.website.controller.admin;

import com.website.models.SupplierEntity;
import com.website.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin-supplier-list")
public class SupplierController extends HttpServlet {
    SupplierService supplierService = new SupplierService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String url ="";
        if (type.equals("list")) {
            List<SupplierEntity> lstSupplier = supplierService.findAll();
            req.setAttribute("lstSupplier",lstSupplier);
            url="views/admin/view/list-supplier.jsp";
        } else if (type.equals("add")) {
            url="views/admin/view/add-supplier.jsp";
        } else if (type.equals("edit")) {
            Integer id = Integer.parseInt(req.getParameter("id").trim());
            SupplierEntity supplier = supplierService.findById(id);
            req.setAttribute("supplier",supplier);
            url="views/admin/view/edit-supplier.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }
}
