package com.website.service;

import com.website.dao.GoodReceivedItemDAO;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.Product_GoodReceived_Key;
import com.website.models.UserEntity;

import java.util.List;

public class ProductGoodReceivedService {
    GoodReceivedItemDAO goodReceivedItemDAO = new GoodReceivedItemDAO();
    public void save(Product_GoodReceived_Entity product_goodReceived_entity){
        Product_GoodReceived_Key product_goodReceived_key = new Product_GoodReceived_Key(product_goodReceived_entity.getGoodsReceivedEntity().getId(),product_goodReceived_entity.getProductEntity().getId());
        product_goodReceived_entity.setId(product_goodReceived_key);
        goodReceivedItemDAO.save(product_goodReceived_entity);
    }

    public List<Product_GoodReceived_Entity> productGoodReceivedEntityList(int id){
        return goodReceivedItemDAO.productGoodReceivedEntityList(id);
    }


    public List<Product_GoodReceived_Entity> find_delete (int id_phieunhap,int id_pro, int quantity){
        return  goodReceivedItemDAO.productGoodReceivedEntityList(id_phieunhap,id_pro,quantity);
    }

    public void update(Product_GoodReceived_Entity product_goodReceived_entity) {
         goodReceivedItemDAO.update(product_goodReceived_entity);
    }

    public Product_GoodReceived_Entity productGoodReceivedEntity (int id_phieunhaphang, int id_pro, int quantity){
        return goodReceivedItemDAO.product_goodReceived_entity(id_phieunhaphang,id_pro,quantity);
    }
}
