package com.website.dao;

import com.website.models.CartEntity;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.UserEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CartDAO extends GenericDAO<Integer, CartEntity> {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<CartEntity> findByUserId(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql = "From CartEntity C Where C.clientEntity.id=:id";
            Query query1 = session.createQuery(sql);
            query1.setParameter("id",id);
            List<CartEntity> lstCart = query1.list();
            transaction.commit();
            return lstCart;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List<CartEntity> findByYear(int year){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(CartEntity.class);
        criteria.add(Restrictions.eq("status",4));
        List<CartEntity> cartEntityList = criteria.list();
        List<CartEntity> kq = new ArrayList<CartEntity>();
        for(CartEntity cartEntity : cartEntityList){
            LocalDate localDate = cartEntity.getBuyDate().toLocalDate();
            System.out.println(localDate.getYear());
            if(localDate.getYear() == year){
                kq.add(cartEntity);
            }
        }
        return kq;
    }
}
