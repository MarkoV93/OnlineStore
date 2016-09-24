/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao;

import com.markoproject.table.Category;
import com.markoproject.table.Product;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Marko
 */
public interface ProductDao {
     public void addProduct(Product product) throws SQLException;
    public void deleteProduct(int id) throws SQLException;
    public Product getProduct(int id) throws SQLException;
    public List<Product> getProducts(Integer page) throws SQLException;
    public List<Product> getByCategory(Category category,Integer page )throws SQLException;
    public int getCountOfProducts(Category category)throws SQLException;
}
