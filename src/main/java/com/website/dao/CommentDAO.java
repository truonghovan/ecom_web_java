package com.website.dao;

import com.website.models.CommentEntity;
import com.website.models.ProductEntity;
import com.website.service.CommentService;
import com.website.utils.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends GenericDAO<Integer, CommentEntity> {
    public List<CommentEntity> findByProductID(Integer id) {
        List<CommentEntity> list = new ArrayList<CommentEntity>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("from CommentEntity");
            sql.append(" where status !=0");
            sql.append(" and product_id =: id");

            Query query = session.createQuery(sql.toString());

//            query.addEntity(CommentEntity.class);
            query.setParameter("id",id);
//            org.hibernate.Query query1 = ;
            list = query.list();
        }catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }
}
