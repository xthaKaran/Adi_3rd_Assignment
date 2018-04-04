/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conteroller;

import Database.DatabaseConnection;
import Model.Company;
import Model.Manifest;
import Model.Product;
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
public class ProductController {
    
    
    DatabaseConnection db;
    Connection con;
    PreparedStatement pst;
    
    public ProductController(){
        db = new DatabaseConnection();
        con = db.getConnection();

    }
    
    public int InsertProduct(Product p) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "INSERT INTO product(`pid`,`mid`,`name`,`quantity`,`weight`,`destination`,`date`,`deliverydate`,`delivery`) VALUES(NULL, ?, ?, ?,?,?,?,?,'NO')";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, p.getMid());
            pst.setString(2, p.getName());
            pst.setInt(3, p.getQuantity());
            pst.setInt(4, p.getSize());
            pst.setString(5, p.getDestination());
             pst.setString(6, p.getDate());
            pst.setString(7, p.getDeliverydate());
            res = pst.executeUpdate();          
        } catch (SQLException e) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
     public ResultSet  ProductId() {
            ResultSet rs=null;
            
        try {
            String sql = "select * from product ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
     
     
     public ResultSet  DeliveryDetial() {
            ResultSet rs=null;
            
        try {
            String sql = "select * from product where delivery='NO'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
     
     public ResultSet  getProductName(Product p) {
            ResultSet rs=null;
            int id= p.getPid();
        try {
            String sql = "select * from product where pid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
     public int UpdateProduct(Product p) {
        int res = 0;
        String sql = "";
        int pid=p.getPid();
        int mid=p.getMid();
        String name= p.getName();
        int quantity= p.getQuantity();
        int weight=p.getSize();
        String destination= p.getDestination();
        String delivarydate=p.getDeliverydate();
        
        
     
        
        try {
              sql = "update Product set mid = '" + mid + "' ,name = '"
                        + name + "' ,quantity = '" + quantity
                        + "' ,weight = '" + weight + "',destination = '" + destination + "',deliverydate = '" + delivarydate + "'  where pid = '"
                        + pid + "' ";
              pst = con.prepareStatement(sql);
            
            res = pst.executeUpdate();
            
        } catch (SQLException e) {
             Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
     
     public int UpdateDeliver(Product p) {
        int res = 0;
        String sql = "";
        int pid=p.getPid();
        String deliver= "YES";
         System.out.println(pid +","+deliver);
        try {
              sql = "update Product set delivery = '" + deliver + "'  where pid = '"
                        + pid + "' ";
              pst = con.prepareStatement(sql);
            
            res = pst.executeUpdate();
            
        } catch (SQLException e) {
             Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
      public int DeleteProduct(Product p) {
        int res = 0;
        String sql = "";
        int id= p.getPid();
        try {
              sql = "Delete from Product where pid=?";
              pst = con.prepareStatement(sql);
              pst.setInt(1, id);
              res = pst.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
}
