/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conteroller;

import Database.DatabaseConnection;
import Model.User;
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
public class UserController {
    DatabaseConnection db;
    Connection con;
    PreparedStatement pst;
    
    public UserController(){
        db = new DatabaseConnection();
        con = db.getConnection();
    }
            public int InsertUser(User u) {
        int res = 0;
        String sql = "";
        
        try {
            sql = "INSERT INTO login(`id`,`username`,`email`,`password`) VALUES(NULL, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            
            res = pst.executeUpdate();
            
        } catch (SQLException e) {
          Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return res;
    }
    
    public boolean Login(User u) {
        
        String sql = "";
        ResultSet rs = null;
        
        try {
            sql = "SELECT * FROM login WHERE email = ? and password = ?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getPassword());
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            
            
        } catch(SQLException e) {
           Logger.getLogger(CompanyController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        return false;
    }
}
