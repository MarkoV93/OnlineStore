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
public class UserDaoImpl extends AbstractDao implements UserDao{
      @Override
    public void addUser(User user) throws SQLException {
 super.saveOrUpdate(user);
    }
    

    @Override
    public void deleteUser(int id) throws SQLException {
super.delete(User.class, id);
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
           Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("login", login));
            userCriteria.add(Restrictions.eq("password", password));
            result = (User) userCriteria.uniqueResult();
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

      List<User> users=super.getAll(User.class);
      return users;
    }
    

   
}
