package com.website.dao;

import com.website.models.GoodsReceivedEntity;
import com.website.models.UserEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserDAO extends GenericDAO<Integer,UserEntity> {
    public UserEntity findByUserName(String username) {
        Transaction transaction = null;
        UserEntity userEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            userEntity = (UserEntity) session.createQuery("FROM UserEntity U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();

            if (userEntity != null ) {
                return userEntity;
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public UserEntity findbyusername_password(String username, String password){
        Transaction transaction = null;
        UserEntity userEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            userEntity = (UserEntity) session.createQuery("FROM UserEntity U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();

            if (userEntity != null && userEntity.getPassWord().equals(password)) {
                return userEntity;
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    public int test_user (String username){
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("username",username));
        return criteria.list().size();
    }
}
