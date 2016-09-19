/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.table.Product;
import com.markoproject.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marko
 */
public abstract class AbstractDao {
    private Session session;
    private Transaction tx;

    public AbstractDao() {
       
    }

    protected void saveOrUpdate(Object obj) {
        try {
            startOperation();
            session.save(obj);
            tx.commit();
        } catch (Throwable e) {
           e.printStackTrace();
        } finally {
           session.close();
        }
    }

    protected void delete(Class clazz, int id) {
        try {
            startOperation();
             session.delete(session.load(clazz, id));
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
           session.close();
        }
    }

    protected Object get(Class clazz, int id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
//            HibernateFactory.close(session);
        }
        return obj;
    }

    protected List getAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
          session.close();
        }
        return objects;
    }

    protected void handleException(HibernateException e)  {
  e.printStackTrace();
    }

    protected void startOperation() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
}
