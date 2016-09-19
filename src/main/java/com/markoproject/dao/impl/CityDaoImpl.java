/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.CityDao;
import com.markoproject.table.City;
import com.markoproject.table.Product;
import com.markoproject.table.User;
import com.markoproject.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Marko
 */
public class CityDaoImpl extends AbstractDao implements CityDao {

//    public CityDaoImpl(){
//        super();
//    }
    //   @Override
    public CityDaoImpl() {
        super();
    }

    public void addCity(City city) throws SQLException {
        super.saveOrUpdate(city);
    }

    //  @Override
    public List<City> getCitys() throws SQLException {
        List<City> citys = super.getAll(City.class);
        return citys;

    }

    // @Override
    public City getCity(int id) throws SQLException {
        return (City) super.get(City.class, id);
    }

    public void deleteCity(int id ) throws SQLException {
       super.delete(City.class,id);
    }

}
