/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Marko
 */
@Entity
@Table(name = "user")
public class User {
       @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
         @NotEmpty(message = "Please enter your name.")
    @Column(name="name")
    private String name;
    
          @NotEmpty(message = "Please enter your name.")
    @Column(name="surname")
    private String surname;
         
     @NotEmpty(message = "Please enter your login.")
     @Column(name="login" ,unique = true)
    private String login;
     
       @NotEmpty(message = "Please enter your password.")
      @Column(name="password")
    private String password;

      @NotEmpty(message = "Please enter your phone.")
      @Column(name="phone")
    private String phone;
      
         @NotEmpty(message = "Please enter your @mail.")
      @Column(name="email")
    private String email;
         

      @Column(name="active_status")
    private boolean activeStatus;
          

      @Column(name="admin_status")
    private boolean adminStatus;

    public int getId() {
        return id;
    }
  


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(boolean adminStatus) {
        this.adminStatus = adminStatus;
    }
      
      
}
