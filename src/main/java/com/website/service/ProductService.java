package com.website.service;

import com.website.dao.ProductDAO;
import com.website.models.ProductEntity;

import javax.inject.Inject;
import java.util.List;

public class ProductService {
//    @Inject
    private ProductDAO productDAO = new ProductDAO();

    public List<ProductEntity> findAll() {
        return productDAO.findAll();
    }
    public void save(ProductEntity product) {
        productDAO.save(product);
    }
    public ProductEntity findById(int id) {
        return productDAO.findById(id);
    }

    public ProductEntity update(ProductEntity product) {
        return productDAO.update(product);
    }
    public int delete(Integer id) {
        ProductEntity product = findById(id);
        product.setStatus(0);
        return productDAO.delete(product);
    }

    public List<ProductEntity> getProductEntity(int brand_id,int detail_cate_id,int start_price,int end_price,String keyWord,int category_id,int postiton, int pageSize){
        return productDAO.getProductEntity(brand_id,detail_cate_id,start_price,end_price,keyWord,category_id,postiton,pageSize);
    }

    public Long totalProduct(){
        return productDAO.countTotalProduct();
    }
    public Long totalProduct_detail_category(int id){
        return productDAO.countTotalProduct_detail_category(id);
    }
    public Long totalProduct_brand(int id){
        return productDAO.countTotalProduct_brand(id);
    }
    public Long totalProduct_price(int start_price, int end_price){
        return productDAO.countTotalProduct_price(start_price,end_price);
    }
    public Long totalProdcut_keyWord(String keyWord){
        return productDAO.countTotalProduct_keyWord(keyWord);
    }
    public Long totalProdcut_cate(int id){
        return productDAO.countTotalProduct_cate(id);
    }
}
