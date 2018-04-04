/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conteroller;

import Database.DatabaseConnection;
import Model.Company;
import Model.Manifest;
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
public class ManifestController {
    DatabaseConnection db;
    Connection con;
    PreparedStatement pst;
    public ManifestController(){
        db = new DatabaseConnection();
        con = db.getConnection();
    }
    
    public int InsertManifest(Manifest m) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "INSERT INTO manifest(`mid`,`cid`,`mname`,`description`,`date`) VALUES(NULL, ?, ?, ?,?)";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, m.getCid());
            pst.setString(2, m.getManifestName());
            pst.setString(3, m.getDescription());
            pst.setString(4, m.getDate());
            res = pst.executeUpdate();          
        } catch (SQLException e) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
        public int UpdateManifest(Manifest m) {
        int res = 0;
        String sql = "";
        String name= m.getManifestName();
        int id= m.getId();
        int cid= m.getCid();
        String desc=m.getDescription();
          
        try {
              sql = "update manifest set cid = '" +cid  + "' ,mname = '"
                        + name + "' ,description = '" + desc
                        + "'   where mid = '"
                        + id + "' ";
            pst = con.prepareStatement(sql);
            res = pst.executeUpdate();
            System.out.println(res);
            
        } catch (SQLException e) {
           Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
            public ResultSet  getManifestDetails(Manifest mani) {
            ResultSet rs=null;
            int id=mani.getId();
            
        try {
            String sql = "select * from manifest where mid=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
           return rs;   
    }
            public ResultSet  getManifestName(Manifest mani) {
            ResultSet rs=null;
            String name=mani.getManifestName();
            
        try {
            String sql = "select * from manifest where mname=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
    
     public ResultSet  ManifestId() {
            ResultSet rs=null;
            
        try {
            String sql = "select * from manifest ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
     
     public int DeleteManifest(Manifest m) {
        int res = 0;
        String sql = "";
        int id =m.getId();
        try {
              sql = "Delete from manifest where mid=?";
              pst = con.prepareStatement(sql);
              pst.setInt(1, id);
              res = pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return res;
    }
}
