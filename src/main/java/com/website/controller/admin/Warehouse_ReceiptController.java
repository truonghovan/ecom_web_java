package com.website.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.website.models.*;
import com.website.service.ProductService;
import com.website.service.SupplierService;
import com.website.service.Warehouse_ReceiptService;
import org.hibernate.Criteria;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/admin-warehouse_receipt-list")
public class Warehouse_ReceiptController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Warehouse_ReceiptService warehouse_receiptService = new Warehouse_ReceiptService();
        SupplierService supplierService = new SupplierService();
        ProductService productService = new ProductService();
        String url = "";
        String type=request.getParameter("type");
        if(type.equals("list")){
            ServletContext application=getServletConfig().getServletContext();
            List<GoodsReceivedEntity> goodsReceivedEntityList = warehouse_receiptService.goodsReceivedEntityList();
            request.setAttribute("lstGoodsReceived", goodsReceivedEntityList);
            url="views/admin/view/list-warehouse_receipt.jsp";
        } else if (type.equals("add")){
            HttpSession session = request.getSession();
            UserEntity user = (UserEntity) session.getAttribute("user");
            GoodsReceivedEntity goodsReceivedEntity = new GoodsReceivedEntity();
            ArrayList pro_good_list = new ArrayList<Product_GoodReceived_Entity>();
            goodsReceivedEntity.setProductGoodReceivedEntityList(pro_good_list);
            session.setAttribute("ss_GoodsReceived", goodsReceivedEntity);

            List<SupplierEntity> supplierEntityList = supplierService.findAll();
            List<ProductEntity> productEntityList = productService.findAll();
            request.setAttribute("lstProduct",productEntityList);
            request.setAttribute("lstSupplier",supplierEntityList);
            url ="views/admin/view/add-warehouse_receipt.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        GoodsReceivedEntity goodsReceivedEntity = gson.fromJson(reader, GoodsReceivedEntity.class);
        Warehouse_ReceiptService warehouse_receiptService = new Warehouse_ReceiptService();
        int result = warehouse_receiptService.delete(goodsReceivedEntity.getId());

        ////Tra ve jsp
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(),result);
    }
}
