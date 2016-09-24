/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.DaoFactory;
import com.markoproject.dao.UserDao;
import com.markoproject.table.Product;
import com.markoproject.table.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.TextNode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Marko
 */
@Controller
public class UserController {

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) throws SQLException {
        if (result.hasErrors()) {
            return "registration";
        } else {
            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.getUserDao();
            user.setActiveStatus(true);
            user.setAdminStatus(false);
            userDao.addUser(user);
            return "redirect:loginn";
        }
    }

 @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpSession session,Map<String, Object> model){
        session.setAttribute("user", null);
        return "redirect:products/all";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Map<String, Object> model) throws SQLException {
        if (result.getErrorCount() > 4) {
            System.out.println(result.getErrorCount());
            return "login";
        } else {
            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.getUserDao();
            if (userDao.verifyUser(user.getLogin(), user.getPassword())) {
                User u = userDao.getUser(user.getLogin());
                u.setPassword("");
                if (u.isActiveStatus() && u.isAdminStatus()) {
                    session.setAttribute("user", u);
                    return "adminPage";
                } else if (u.isActiveStatus() && !u.isAdminStatus()) {
                    session.setAttribute("user", u);
                    u.setPassword("");
                    return "redirect:products/all";

                } else {
                    model.put("message", "your account is banned");
                    return "error";
                }
            } else {
                model.put("message", "there is uncurrent pussword or login");
                return "login";
            }
        }
    }
     @RequestMapping(value = "/user/changePassword", method = RequestMethod.PUT)
     public @ResponseBody String addToBasket(@RequestBody String  oldPass, Map<String, Object> model, HttpSession session) throws SQLException, IOException {

         System.out.println(oldPass);
          return "qqq";
     }
}
