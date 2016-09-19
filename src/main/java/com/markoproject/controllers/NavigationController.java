/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.DaoFactory;
import com.markoproject.table.Category;
import com.markoproject.table.Product;
import com.markoproject.table.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
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
public class NavigationController {
     @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm( Map<String, Object> model) {
        User user=new User();
        model.put("user",user);
		return "registration";
	}
        
          @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm( Map<String, Object> model) {
        User user=new User();
        model.put("user",user);
		return "login";
	}
          @RequestMapping(value = "/stores", method = RequestMethod.GET)
	public String showProducts( Map<String, Object> model) throws SQLException {

		return "store";
	}
        
        
}
