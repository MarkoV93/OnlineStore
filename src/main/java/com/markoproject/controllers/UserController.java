/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.controllers;

import com.markoproject.dao.DaoFactory;
import com.markoproject.dao.UserDao;
import com.markoproject.table.User;
import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Marko
 */
@Controller
@SessionAttributes({"login"})
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
            return "hello";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) throws SQLException {
        if (result.getErrorCount() > 4) {
            System.out.println(result.getErrorCount());
            return "login";
        } else {
            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.getUserDao();
            if (userDao.verifyUser(user.getLogin(), user.getPassword())) {
                User u = userDao.getUser(user.getLogin());
                if (u.isActiveStatus()&&u.isAdminStatus()) {
                     model.put("login",u.getLogin());
                    return "adminPage";
                } else if(u.isActiveStatus()&&!u.isAdminStatus()){
                     model.put("login",u.getLogin());
                              return "userPage";
                            
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
}
