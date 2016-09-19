/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.CityDao;
import com.markoproject.dao.DaoFactory;
import com.markoproject.dao.UserDao;
import com.markoproject.dao.impl.UserDaoImpl;
import com.markoproject.table.City;
import com.markoproject.table.User;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Marko
 */
public class UserDaoImpl {
    
    @Test
    public void getUser() throws SQLException{
        System.out.println("asdasd");
        DaoFactory factory=DaoFactory.getInstance();
        CityDao users=factory.getCityDao();
       City city= users.getCity(1);
      
        Assert.assertEquals(city.getName(), "NY");
       
    }
}
