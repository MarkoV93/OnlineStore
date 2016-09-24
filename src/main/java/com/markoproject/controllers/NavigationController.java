/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.DaoFactory;
import com.markoproject.table.Category;
import com.markoproject.table.Product;
import com.markoproject.table.Reserve;
import com.markoproject.table.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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
public class NavigationController {
     @RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm( Map<String, Object> model) {
        User user=new User();
        model.put("user",user);
		return "registration";
	}
        
          @RequestMapping(value = "/loginn", method = RequestMethod.GET)
	public String loginForm( Map<String, Object> model) {
              Reserve r=new Reserve();
        User user=new User();
        model.put("user",user);
		return "login";
	}
        
//          @RequestMapping(value = "/store", method = RequestMethod.GET)
//	public String showProducts( Map<String, Object> model) throws SQLException {
//        model.put("page", 0);
//		return "redirect:products/all";
//	}
        
              @RequestMapping(value = "/showBasket", method = RequestMethod.GET)
 public String showBasket(Map<String, Object> model) throws SQLException  {
   return "basket";  
 }
  @RequestMapping(value = "/user/{userLogin}", method = RequestMethod.GET)
 public String userProFile(@PathVariable("userLogin") String login,Map<String, Object> model,HttpSession session) throws SQLException  {
   User user=new User();
        model.put("user",user);   
        return "userPage";
 }
}
