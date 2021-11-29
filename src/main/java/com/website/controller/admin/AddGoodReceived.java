package com.website.controller.admin;

import com.google.gson.Gson;
import com.website.models.GoodsReceivedEntity;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.SupplierEntity;
import com.website.models.UserEntity;
import com.website.service.ProductGoodReceivedService;
import com.website.service.SupplierService;
import com.website.service.Warehouse_ReceiptService;
import com.website.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(urlPatterns = {"/add_goodreceived"})
public class AddGoodReceived extends HttpServlet {

    ProductGoodReceivedService productGoodReceivedService = new ProductGoodReceivedService();
    SupplierService supplierService = new SupplierService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        ////Lay gia trị thoi gian va user
        HttpSession session = req.getSession();
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        UserEntity user = (UserEntity) session.getAttribute("user");

        //Chuyen thanh model
        GoodsReceivedEntity goodsReceivedEntity_model = HttpUtil.of(req.getReader()).toModel(GoodsReceivedEntity.class);

        int supplier_id = goodsReceivedEntity_model.getSupplierEntity().getId();
        String note = goodsReceivedEntity_model.getNote();
        SupplierEntity supplierEntity = supplierService.findById(supplier_id);
        GoodsReceivedEntity goodsReceivedEntity = (GoodsReceivedEntity) session.getAttribute("ss_GoodsReceived");
        int total_price = 0;
        for (Product_GoodReceived_Entity item: goodsReceivedEntity.getProductGoodReceivedEntityList()) {
            total_price += item.getQuantity() * item.getProductEntity().getPrice();
        }

        goodsReceivedEntity.setSupplierEntity(supplierEntity);
        goodsReceivedEntity.setNote(note);
        goodsReceivedEntity.setDate_Goods_Received(date);
        goodsReceivedEntity.setUserEntity(user);
        goodsReceivedEntity.setTotal_price(total_price);
        Warehouse_ReceiptService warehouse_receiptService = new Warehouse_ReceiptService();
        warehouse_receiptService.save(goodsReceivedEntity);
        for (Product_GoodReceived_Entity item: goodsReceivedEntity.getProductGoodReceivedEntityList()) {
            item.setGoodsReceivedEntity(goodsReceivedEntity);
            productGoodReceivedService.save(item);
        }

        ////Tra ve jsp
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String hangnhap = new Gson().toJson(goodsReceivedEntity_model);
        resp.getWriter().write(hangnhap);
    }
}
