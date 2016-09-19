/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao;

import com.markoproject.table.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface UserDao {
      public void addUser(User user) throws SQLException;
    public void deleteUser(int id) throws SQLException;
    public User getUser(String login) throws SQLException;
    public Boolean verifyUser(String login,String password) throws SQLException;
    public List<User> getUsers() throws SQLException;
}
