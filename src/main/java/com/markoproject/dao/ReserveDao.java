/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao;

import com.markoproject.table.Reserve;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marko
 */
public interface ReserveDao {
      public void addReserve(Reserve reserve) throws SQLException;
    public void deleteReserve(int id) throws SQLException;
    public Reserve getReserve(int id) throws SQLException;
    public List<Reserve> getReserves() throws SQLException;
}
