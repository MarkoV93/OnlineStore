/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao;

import com.markoproject.dao.impl.CategoryDaoImpl;
import com.markoproject.dao.impl.CityDaoImpl;
import com.markoproject.dao.impl.ProductDaoImpl;
import com.markoproject.dao.impl.UserDaoImpl;

/**
 *
 * @author Marko
 */
public class DaoFactory {
    private static DaoFactory instance=new DaoFactory();
    private UserDao userDao;
private ProductDao productDao;
private CityDao cityDao;
private CategoryDao categoryDao;
   
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return DaoFactory.instance;
    }
    public UserDao getUserDao(){
        if (userDao==null) userDao=new UserDaoImpl();
        return userDao;
    }
    
      public ProductDao getProductDao(){
        if (productDao==null) productDao=new ProductDaoImpl();
        return productDao;
    }
        public CityDao getCityDao(){
        if (cityDao==null) cityDao=new CityDaoImpl();
        return cityDao;
    }
          public CategoryDao getCategoryDao(){
        if (categoryDao==null) categoryDao=new CategoryDaoImpl();
        return categoryDao;
    }
}