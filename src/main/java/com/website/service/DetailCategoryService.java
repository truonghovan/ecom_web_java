package com.website.service;

import com.website.dao.DetailCategoryDAO;
import com.website.models.DetailCategoryEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class DetailCategoryService {
    private DetailCategoryDAO detailCategoryDAO = new DetailCategoryDAO();
    public List<DetailCategoryEntity> findAll() {
        return detailCategoryDAO.findAll();
    }
    public void save(DetailCategoryEntity detailCate) {
        detailCategoryDAO.save(detailCate);
    }
    public DetailCategoryEntity update(DetailCategoryEntity detailCate) {
        return detailCategoryDAO.update(detailCate);
    }
    public DetailCategoryEntity findById(Integer id) {
        return detailCategoryDAO.findById(id);
    }
    public int delete(int id) {
        DetailCategoryEntity detailCate = findById(id);
        detailCate.setStatus(0);
        DetailCategoryEntity result= detailCategoryDAO.update(detailCate);
        if (result==null) {
            return 0;
        } else {
            return 1;
        }

    }

}
