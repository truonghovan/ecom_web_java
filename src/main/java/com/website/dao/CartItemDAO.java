package com.website.dao;

import com.website.models.CartEntity;
import com.website.models.GoodsReceivedEntity;
import com.website.models.Product_Cart_Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAO extends GenericDAO<Integer, Product_Cart_Entity> {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    public List<Product_Cart_Entity> find_cart_pro (int year){
        Criteria criteria = session.createCriteria(Product_Cart_Entity.class);
        criteria.createCriteria("cartEntity").add(Restrictions.eq("status",4));
        List<Product_Cart_Entity> productCartEntityList = criteria.list();
        List<Product_Cart_Entity> kq = new ArrayList<Product_Cart_Entity>();
        for(Product_Cart_Entity product_cart_entity : productCartEntityList){
            LocalDate localDate = product_cart_entity.getCartEntity().getBuyDate().toLocalDate();
            if(localDate.getYear() == year){
                kq.add(product_cart_entity);
            }
        }
        System.out.println(kq);
        return kq;
    }

    public List<Product_Cart_Entity> find_cart_pro_month_year (int year, int month){
        Criteria criteria = session.createCriteria(Product_Cart_Entity.class);
        criteria.createCriteria("cartEntity").add(Restrictions.eq("status",4));
        List<Product_Cart_Entity> productCartEntityList = criteria.list();
        List<Product_Cart_Entity> kq = new ArrayList<Product_Cart_Entity>();
        for(Product_Cart_Entity product_cart_entity : productCartEntityList){
            LocalDate localDate = product_cart_entity.getCartEntity().getBuyDate().toLocalDate();
            if(localDate.getYear() == year && localDate.getMonthValue() == month){
                kq.add(product_cart_entity);
            }
        }
        System.out.println(kq);
        return kq;
    }
}
