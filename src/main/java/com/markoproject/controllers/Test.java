/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.CategoryDao;
import com.markoproject.dao.CityDao;
import com.markoproject.dao.DaoFactory;
import com.markoproject.dao.ProductDao;
import com.markoproject.dao.UserDao;
import com.markoproject.table.Category;
import com.markoproject.table.City;
import com.markoproject.table.Product;
import com.markoproject.table.User;
import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marko
 */
@Controller
public class Test {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Map<String, Object> model) throws SQLException {
//        Product product = new Product();
//        DaoFactory factory = DaoFactory.getInstance();    
//        product.setPrice("111");
//        product.setName("telephone");
//        product.setImage("image");
//        product.setDescription("aaaa");
//        ProductDao productDao = factory.getProductDao();
//        productDao.addProduct(product,1,1);
Product product=DaoFactory.getInstance().getProductDao().getProduct(1);
        System.out.println(product.getName());
      //  System.out.println(product.getCategory().getName()+"   "+product.getName()+"   "+product.getCity().getName());
        return "hello";
    }
}
