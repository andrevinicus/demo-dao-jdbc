/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/**
 *
 * @author GCM_02
 */
public class DaoFactory {
    public static SellerDao creatSallerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
