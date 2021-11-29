package com.website.dao;

import com.website.models.ProductEntity;
import com.website.models.Product_GoodReceived_Entity;
import com.website.models.UserEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class GoodReceivedItemDAO extends GenericDAO<Integer, Product_GoodReceived_Entity>{

    public List<Product_GoodReceived_Entity> productGoodReceivedEntityList (int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
/*        criteria.add(Restrictions.eq("status",1));*/
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id));
        return criteria.list();
        /*Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            List<Product_GoodReceived_Entity> productGoodReceivedEntityList = (List<Product_GoodReceived_Entity>) session.createQuery("FROM Product_GoodReceived_Entity U WHERE U.goodsReceivedEntity.id = :id").setParameter("id", id).uniqueResult();
            System.out.println(productGoodReceivedEntityList);
            transaction.commit();
            return productGoodReceivedEntityList;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;*/
    }

    public List<Product_GoodReceived_Entity> productGoodReceivedEntityList (int id_phieunhap, int id_pro, int quantity){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
        criteria.add(Restrictions.eq("quantity",quantity));
        criteria.createCriteria("productEntity").add(Restrictions.eq("id",id_pro));
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id_phieunhap));
        return criteria.list();
    }

    public Product_GoodReceived_Entity product_goodReceived_entity (int id_phieunhap, int id_pro, int quantity){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id_phieunhap));
        criteria.createCriteria("productEntity").add(Restrictions.eq("id",id_pro));
        criteria.add(Restrictions.eq("quantity",quantity));
        Product_GoodReceived_Entity product_goodReceived_entity = (Product_GoodReceived_Entity) criteria.list().get(0);
        return product_goodReceived_entity;
    }

   /* public List<Product_GoodReceived_Entity> find_item_goods (int id_phieunhap){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id_phieunhap));
        return criteria.list();
    }*/
}
