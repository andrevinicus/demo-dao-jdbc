/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import com.mysql.cj.xdevapi.PreparableStatement;
import db.DB;
import db.DbException;
import java.sql.SQLException;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

/**
 *
 * @author GCM_02
 */
public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     @Override 
    public Seller findById(Integer id) {
        PreparableStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*,department.Name as depName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = Department.id "
                    + "WHERE seller.id = ? ");
            
            st.setInt(1,id);
            rs = st.executeQuery();
            
            if(rs.next()){
                Departament dep = new Departament();
                dep.setId(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("depName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary "));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setDepartament(dep);
                return obj;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
