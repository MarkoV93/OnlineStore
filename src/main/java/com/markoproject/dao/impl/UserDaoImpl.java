/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.UserDao;
import com.markoproject.table.User;
import com.markoproject.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marko
 */
public class UserDaoImpl implements UserDao{
      @Override
    public void addUser(User user) throws SQLException {
             Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }
    

    @Override
    public void deleteUser(String login) throws SQLException {
          Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
              Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("login", login));
           User user  = (User) userCriteria.uniqueResult();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }
    

    @Override
    public User getUser(String login) throws SQLException  {
        User result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
           Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("login", login));
            result = (User) userCriteria.uniqueResult();
            
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Boolean verifyUser(String login,String password) throws SQLException {
        User result = null;
        Session session = null;
        try {
         session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("verifyUser");
        query.setString("login", login);
         query.setString("password", password);
        result = (User) query.uniqueResult();
      } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result!=null;
    }

    @Override
    public List<User> getUsers() throws SQLException {

        List<User> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createCriteria(User.class).list();
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }
    

   
}
