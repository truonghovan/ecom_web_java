package com.website.service;

import com.website.dao.CategoryDAO;
import com.website.models.BrandEntity;
import com.website.models.CategoryEntity;

import java.util.List;

public class CategoryService {
    CategoryDAO categoryDAO = new CategoryDAO();
    public List<CategoryEntity> findAll() {
        return categoryDAO.findAll();
    }

    public CategoryEntity findById(int id) {
        return categoryDAO.findById(id);
    }

    public void save(CategoryEntity category) {
        categoryDAO.save(category);
    }

    public CategoryEntity update(CategoryEntity category) {
        return categoryDAO.update(category);
    }

    public int delete(Integer id) {
        CategoryEntity category = findById(id);
        category.setStatus(0);
        return categoryDAO.delete(category);
    }

}
