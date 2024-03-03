/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

public class ApplicationAdmin {
    public Admin loginAdmin(String username, String password){
        Database db = new Database();
        Admin admin = null;
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM admin "
                    + "WHERE username='"+username+"' AND password='"+password+"'");
            if(rs.next()){
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("idadmin"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return admin;
    }
}
