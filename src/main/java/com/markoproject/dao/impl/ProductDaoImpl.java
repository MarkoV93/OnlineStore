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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marko
 */
public class ProductDaoImpl extends AbstractDao implements ProductDao{

    @Override
    public void addProduct(Product product) throws SQLException {
   super.saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
    super.delete(Product.class, id);
    }

    @Override
    public Product getProduct(int id) throws SQLException {
     return (Product)super.get(Product.class, id);
    }

    @Override
    public List<Product> getProducts(Integer page) throws SQLException {
        if(page==null) page=0;
     List<Product> result = super.getAll(Product.class,page);
       
        return result;
    }

    @Override
    public List<Product> getByCategory(Category category,Integer page) throws SQLException {
        if(page==null) page=0;
          List<Product> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
           Criteria productCriteria = session.createCriteria(Product.class);
           productCriteria.setFirstResult(page * 10).setMaxResults(10);
            productCriteria.add(Restrictions.eq("category", category));
           result = productCriteria.list();
            
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    
    }

    @Override
    public int getCountOfProducts(Category category) throws SQLException {
        int count=0;
          Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
           Criteria productCriteria = session.createCriteria(Product.class);
           if(category!=null){
            productCriteria.add(Restrictions.eq("category", category));
           }
           count =((Number)productCriteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
           
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
         return count;
    }
}
    

