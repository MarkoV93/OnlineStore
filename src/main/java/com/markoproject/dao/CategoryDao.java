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

/**
 *
 * @author Marko
 */
public interface CategoryDao {
    public void addCategory(Category category) throws SQLException;
      public List<Category> getCategories() throws SQLException;
      public Category getCategory(int id) throws SQLException;
}
