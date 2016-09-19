/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao;

import com.markoproject.table.City;
import com.markoproject.table.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface CityDao {
     public void addCity(City city) throws SQLException;
      public List<City> getCitys() throws SQLException;
      public City getCity(int id) throws SQLException;
       public void deleteCity(int id ) throws SQLException;
}
