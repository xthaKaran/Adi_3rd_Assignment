/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conteroller;

import Database.DatabaseConnection;
import Model.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karan
 */
public class CompanyController {
    DatabaseConnection db;
    Connection con;
    PreparedStatement pst;
    
    public CompanyController(){
        db = new DatabaseConnection();
        con = db.getConnection();
    }
    
    public int InsertCompany(Company c) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "INSERT INTO company(`cid`,`name`,`address`,`email`,`contact`) VALUES(NULL, ?, ?, ?,?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, c.getName());
            pst.setString(2, c.getAddress());
            pst.setString(3, c.getEmail());
            pst.setString(4, c.getContact());
            
            res = pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public ResultSet  getCompanyDetails(Company c) {
            ResultSet rs=null;
            int id=c.getId();
            
        try {
            String sql = "select * from company where cid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
      public ResultSet  getCompanyName(Company c) {
            ResultSet rs=null;
            String name=c.getName();
            
        try {
            String sql = "select * from company where name=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
    
    
     public ResultSet  companyId() {
            ResultSet rs=null;
            
        try {
            String sql = "select * from company ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
     
     public int UpdateCompany(Company c) {
        int res = 0;
        String sql = "";
        int id=c.getId();
        String name=c.getName();
        String address= c.getAddress();
        String email=c.getEmail();
        String contact= c.getContact();
        
        try {
              sql = "update company set name = '" + name + "' ,address = '"
                        + address + "' ,email = '" + email
                        + "' ,contact = '" + contact + "' where cid = '"
                        + id + "' ";
              pst = con.prepareStatement(sql);
            
            res = pst.executeUpdate();
            
        } catch (SQLException e) {
             Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }


     public int DeleteCompany(Company c) {
        int res = 0;
        String sql = "";
        int id= c.getId();
        try {
              sql = "Delete FROM company where cid=?;";
              pst = con.prepareStatement(sql);
              pst.setInt(1, id);
              res = pst.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
}
