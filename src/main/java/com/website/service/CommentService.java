package com.website.service;

import com.website.dao.CommentDAO;
import com.website.models.CommentEntity;

import java.util.List;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();
    public void save(CommentEntity comment) {
        commentDAO.save(comment);
    }
    public List<CommentEntity> findAll() {
        return commentDAO.findAll();
    }
    public List<CommentEntity> findByProductID(Integer id) {
        return commentDAO.findByProductID(id);
    }
    public CommentEntity findByID(Integer id) {
        return commentDAO.findById(id);
    }

    public CommentEntity update(CommentEntity commentEntity) {
        return commentDAO.update(commentEntity);
    }
}
