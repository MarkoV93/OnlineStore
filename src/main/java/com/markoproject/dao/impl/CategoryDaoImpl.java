/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.CategoryDao;
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
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{

    @Override
    public void addCategory(Category category) throws SQLException {
       super.saveOrUpdate(category);
    }

    @Override
    public List<Category> getCategories() throws SQLException {     
      List<Category> categories = super.getAll(Category.class);
        return categories;
    }

    @Override
    public Category getCategory(int id) throws SQLException {
       return (Category) super.get(Category.class, id);
    }
    
    @Override
    public void deleteCategory(int id) throws SQLException {
       super.delete(Category.class,id);
    }

    @Override
    public Category getCategoryByName(String name) throws SQLException {
       Category result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
           Criteria categoryCriteria = session.createCriteria(Category.class);
            categoryCriteria.add(Restrictions.eq("name",name));
            result = (Category) categoryCriteria.uniqueResult();      
        } catch (Exception e) {
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }
    }

