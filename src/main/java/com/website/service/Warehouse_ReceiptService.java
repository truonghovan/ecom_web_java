package com.website.service;

import com.website.dao.Warehouse_ReceiptDAO;
import com.website.models.CartEntity;
import com.website.models.GoodsReceivedEntity;
import com.website.models.ProductEntity;
import com.website.models.UserEntity;

import java.util.List;

public class Warehouse_ReceiptService {
    private Warehouse_ReceiptDAO warehouse_receiptDAO = new Warehouse_ReceiptDAO();

    public void save(GoodsReceivedEntity goodsReceivedEntity) {
        warehouse_receiptDAO.save(goodsReceivedEntity);
    }
    public List<GoodsReceivedEntity> goodsReceivedEntityList () {
        return warehouse_receiptDAO.goodsReceivedEntityList();
    }
/*    public int delete(Integer id) {
        ProductEntity product = findById(id);
        product.setStatus(0);
        return productDAO.delete(product);
    }*/

    public GoodsReceivedEntity findById(int id) {
        return warehouse_receiptDAO.findById(id);
    }
    public int delete (Integer id){
        GoodsReceivedEntity goodsReceivedEntity = findById(id);
        goodsReceivedEntity.setStatus(0);
        return warehouse_receiptDAO.delete(goodsReceivedEntity);
    }

    public void update(GoodsReceivedEntity goodsReceivedEntity) {
        warehouse_receiptDAO.update(goodsReceivedEntity);
    }
}
