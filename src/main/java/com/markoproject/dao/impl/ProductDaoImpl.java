/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.ProductDao;
import com.markoproject.table.Category;
import com.markoproject.table.City;
import com.markoproject.table.Product;
import com.markoproject.table.User;
import com.markoproject.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marko
 */
public class ProductDaoImpl implements ProductDao{

    @Override
    public void addProduct(Product product,int cityId,int categoryId) throws SQLException {
        Session session = null;
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
            session.load(City.class, cityId);
            session.load(Category.class,categoryId);      
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
     Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
          Product product   = (Product) session.load(Product.class, id);
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    @Override
    public Product getProduct(int id) throws SQLException {
        Product result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Product) session.load(Product.class, id);
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<Product> getProducts() throws SQLException {
     List<Product> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = session.createCriteria(Product.class).list();
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }
}
