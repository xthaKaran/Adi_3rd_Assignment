/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conteroller;

import Database.DatabaseConnection;
import Model.Manifest;
import Model.Shipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShipmentController {
      
    DatabaseConnection db;
    Connection con;
    PreparedStatement pst;
    
    
    public ShipmentController(){
         db = new DatabaseConnection();
        con = db.getConnection();
    
    }
    
     public int InsertShipment(Shipment s) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "INSERT INTO shipment(`sid`,`pid`,`internalCost`,`customercost`) VALUES(NULL, ?,?,?)";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, s.getPid());
            pst.setFloat(2, s.getInternalcost());
            pst.setFloat(3,s.getCustomerCost());
                    
            
            res = pst.executeUpdate();          
        } catch (SQLException e) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
     
     
     public ResultSet  SearchCost(String location) {
            ResultSet rs=null;
            
        try {
            String sql = "select * from cost where location=? ";
            pst = con.prepareStatement(sql);
              pst.setString(1, location);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ManifestController.class.getName()).log(Level.SEVERE, null, ex);
        }
           return rs;   
    }
    
    
}
