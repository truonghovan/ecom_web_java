package com.website.dao;

import com.website.models.GoodsReceivedEntity;
import com.website.models.ProductEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class Warehouse_ReceiptDAO extends GenericDAO<Integer, GoodsReceivedEntity>{
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();

    public List<GoodsReceivedEntity> goodsReceivedEntityList (){
        Criteria criteria = session.createCriteria(GoodsReceivedEntity.class);
        criteria.add(Restrictions.eq("status",1));
        List<GoodsReceivedEntity> result = criteria.list();
        return result;
    }

}
