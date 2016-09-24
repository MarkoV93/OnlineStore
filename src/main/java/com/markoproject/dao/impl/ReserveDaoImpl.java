/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.markoproject.dao.impl;

import com.markoproject.dao.ReserveDao;
import com.markoproject.table.Reserve;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marko
 */
public class ReserveDaoImpl extends AbstractDao implements ReserveDao{

    @Override
    public void addReserve(Reserve reserve) throws SQLException {
        reserve.setStatus(0);
       super.saveOrUpdate(reserve);
    }

    @Override
    public void deleteReserve(int id) throws SQLException {
       super.delete(Reserve.class, id);
    }

    @Override
    public Reserve getReserve(int id) throws SQLException {
     return  (Reserve)super.get(Reserve.class, id);
    }

    @Override
    public List<Reserve> getReserves() throws SQLException {
       List<Reserve> reserves=super.getAll(Reserve.class);
       return reserves;
    }
    
}
