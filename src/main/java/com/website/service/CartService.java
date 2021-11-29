package com.website.service;

import com.website.dao.CartDAO;
import com.website.models.CartEntity;

import java.util.List;

public class CartService {
    private CartDAO cartDAO = new CartDAO();
    public List<CartEntity> findAll() {
        return cartDAO.findAll();
    }
    public CartEntity findById(Integer id) {
        return cartDAO.findById(id);
    }
    public CartEntity update(CartEntity cart) {
        return cartDAO.update(cart);
    }
    public void save(CartEntity cartEntity) {
        cartDAO.save(cartEntity);
    }
    public int delete(Integer id) {
        CartEntity cart = findById(id);
        cart.setStatus(0);
        return cartDAO.delete(cart);
    }
    public List<CartEntity> findByUserID(Integer id) {
        return cartDAO.findByUserId(id);
    }

    public List<CartEntity> findByYear(int year){
        return cartDAO.findByYear(year);
    }

}
