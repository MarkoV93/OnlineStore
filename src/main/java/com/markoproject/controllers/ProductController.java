/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.DaoFactory;
import com.markoproject.table.Category;
import com.markoproject.table.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Marko
 */
@Controller
@SessionAttributes({"categories"})
@RequestMapping(value = "/products")
public class ProductController {

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String getCart(@PathVariable("category") String name, Map<String, Object> model,@RequestParam(required=false) Integer page) throws SQLException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        Category category = daoFactory.getCategoryDao().getCategoryByName(name);
        List<Product> products = daoFactory.getProductDao().getByCategory(category,page);
        model.put("products", products);
        model.put("path", name);
        int count = daoFactory.getProductDao().getCountOfProducts(category);
         int pages = count / 10;
         System.out.println(count);
         System.out.println(count % 10 != 0);
       if (count % 10 == 0) {
            pages--;
        }
       // count++;
        model.put("pages", pages);
        return "store";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getCartt(Map<String, Object> model, @RequestParam(required=false) Integer page) throws SQLException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        List<Category> categories = daoFactory.getCategoryDao().getCategories();
        model.put("categories", categories);
        List<Product> products = daoFactory.getProductDao().getProducts(page);
        model.put("products", products);
         model.put("path", "all");
        int count = daoFactory.getProductDao().getCountOfProducts(null);
        int pages = count / 10;
        if (count % 10 == 0) {
            pages--;
        }
      //  count++;
        model.put("pages", pages);
        return "store";
    }

    @RequestMapping(value = "/showProduct/{productId}", method = RequestMethod.GET)
    public String showProduct(@PathVariable("productId") int productId, Map<String, Object> model) throws SQLException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        Product product = daoFactory.getProductDao().getProduct(productId);
        model.put("product", product);
        return "product";
    }

}
