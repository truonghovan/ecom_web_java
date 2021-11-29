package com.website.service;

import com.website.dao.BrandDAO;
import com.website.models.BrandEntity;

import java.util.List;

public class BrandService  {
    BrandDAO brandDAO = new BrandDAO();

    public List<BrandEntity> findAll() {
        return brandDAO.findAll();
    }

    public void save(BrandEntity brandEntity) {
        brandDAO.save(brandEntity);
    }

    public BrandEntity findById(Integer id) {
        return brandDAO.findById(id);
    }

    public BrandEntity update(BrandEntity brand) {
        return brandDAO.update(brand);
    }

    public int delete(Integer id) {
        BrandEntity brand = findById(id);
        brand.setStatus(0);
        return brandDAO.delete(brand);
    }
}
