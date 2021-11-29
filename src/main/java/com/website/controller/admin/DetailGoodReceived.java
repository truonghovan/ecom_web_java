package com.website.controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.website.dao.GoodReceivedItemDAO;
import com.website.models.GoodsReceivedEntity;
import com.website.models.ProductEntity;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.SupplierEntity;
import com.website.service.ProductGoodReceivedService;
import com.website.service.ProductService;
import com.website.service.SupplierService;
import com.website.service.Warehouse_ReceiptService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/detail_goodreceived")
public class DetailGoodReceived extends HttpServlet {

    ProductEntity productEntity = new ProductEntity();
    SupplierService supplierService = new SupplierService();
    ProductService productService = new ProductService();
    Warehouse_ReceiptService warehouse_receiptService = new Warehouse_ReceiptService();
    ProductGoodReceivedService productGoodReceivedService = new ProductGoodReceivedService();
    List<Product_GoodReceived_Entity> productGoodReceivedEntityList = new ArrayList<Product_GoodReceived_Entity>();
    GoodReceivedItemDAO goodReceivedItemDAO = new GoodReceivedItemDAO();
    GoodsReceivedEntity goodsReceivedEntity = new GoodsReceivedEntity();
    List<SupplierEntity> supplierEntityList = supplierService.findAll();
    List<ProductEntity> productEntityList = productService.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("edit")){
            int id =Integer.parseInt(req.getParameter("id"));
            goodsReceivedEntity = warehouse_receiptService.findById(id);
             productGoodReceivedEntityList = goodReceivedItemDAO.productGoodReceivedEntityList(id);
        }

        ///Chuyen trang
        req.setAttribute("phieunhap",goodsReceivedEntity);
        req.setAttribute("listhangnhap",productGoodReceivedEntityList);
        req.setAttribute("lstProduct",productEntityList);
        req.setAttribute("lstSupplier",supplierEntityList);
        String url="";
        url = "views/admin/view/edit-warehouse_receipt.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        Product_GoodReceived_Entity product_goodReceived_entity = gson.fromJson(reader, Product_GoodReceived_Entity.class);
        int id_phieunhaphang= product_goodReceived_entity.getGoodsReceivedEntity().getId();
        int id_pro = product_goodReceived_entity.getProductEntity().getId();
        int quantity = product_goodReceived_entity.getQuantity();
        goodsReceivedEntity = warehouse_receiptService.findById(id_phieunhaphang);
        int total_price_update = goodsReceivedEntity.getTotal_price() - quantity * product_goodReceived_entity.getProductEntity().getPrice();
        goodsReceivedEntity.setTotal_price(total_price_update);
        warehouse_receiptService.update(goodsReceivedEntity);
        productGoodReceivedEntityList = productGoodReceivedService.find_delete(id_phieunhaphang,id_pro,quantity);
        if (productGoodReceivedEntityList.get(0) != null){
            productGoodReceivedEntityList.get(0).setStatus(0);
        }
        goodReceivedItemDAO.update(productGoodReceivedEntityList.get(0));

        ////Tra ve jsp
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(),"Thành công");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        Product_GoodReceived_Entity product_goodReceived_entity = gson.fromJson(reader, Product_GoodReceived_Entity.class);
        int id_phieunhaphang= product_goodReceived_entity.getGoodsReceivedEntity().getId();
        int id_pro = product_goodReceived_entity.getProductEntity().getId();
        int quantity = product_goodReceived_entity.getQuantity();

        ///Tim phieu nhap hang
        goodsReceivedEntity = warehouse_receiptService.findById(id_phieunhaphang);

        //Tim pro_goods_rece
        product_goodReceived_entity = productGoodReceivedService.productGoodReceivedEntity(id_phieunhaphang, id_pro, quantity);

        ///Tim san pham va cong so luong vao
        productEntity = productService.findById(id_pro);
        productEntity.setQuantity(quantity + productEntity.getQuantity());
        productService.update(productEntity);

        //Cap nhat pro_goods_rece
        product_goodReceived_entity.setStatus(0);
        productGoodReceivedService.update(product_goodReceived_entity);

        ///Kiem tra hang cua phieu da nhap het chua
        productGoodReceivedEntityList = productGoodReceivedService.productGoodReceivedEntityList(id_phieunhaphang);
        int check = 0;
        for (Product_GoodReceived_Entity productGoodReceivedEntity : productGoodReceivedEntityList){
            if (productGoodReceivedEntity.getStatus() == 0){
                check += 1;
            }
        }
        if (check == productGoodReceivedEntityList.size()){
            goodsReceivedEntity.setHoanthanh(1);
        }
        warehouse_receiptService.update(goodsReceivedEntity);

        ////Tra ve jsp
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        mapper.writeValue(resp.getOutputStream(),"Bạn đã nhập hàng thành công. ");
    }
}
