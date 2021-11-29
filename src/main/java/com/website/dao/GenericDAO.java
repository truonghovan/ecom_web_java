package com.website.dao;

import com.website.utils.HibernateUtil;
import org.hibernate.*;
//import sun.net.www.content.text.Generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<ID extends Serializable,T> {
    private Class<T> persistenceClass;

    public GenericDAO() {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();

    }

    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> list = new ArrayList<T>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            sql.append(" where status !=0");
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Transaction transaction = session.beginTransaction();
        try {
            Object obj = session.merge(entity);
            result = (T) obj;
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return  result;
    }

    public int delete(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int result = 0;
        Transaction transaction = session.beginTransaction();
        try {
            Object obj = session.merge(entity);

            transaction.commit();
            result=1;
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return  result;
    }

    public void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = (T) session.get(persistenceClass,id);
            if (result==null) {
                throw new ObjectNotFoundException("Not found "+id,null);
            }
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(String property,Object value,String sortExpression, String sortDirection ) {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {

            StringBuilder sql = new StringBuilder("from ");
            sql.append(getPersistenceClassName());
            sql.append(" where 1=1 ");
            if (property != null && value != null) {
                sql.append("and "+property).append(" =:value");
            }
            if (sortExpression != null && sortDirection != null) {
                sql.append(" order by "+sortExpression).append(" "+ sortDirection);
            }

            Query query1 = session.createQuery(sql.toString());
            if (property != null && value != null) {
                query1.setParameter("value",value);
            }

            list = query1.list();

        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return new Object[] {list.size(),list};
    }
}
