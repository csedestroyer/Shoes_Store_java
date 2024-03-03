/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.*;

public class Database {
    private final String url = "jdbc:mysql://localhost/hydracorp";
    
    private Connection con;
    private Statement stm;
    
    //Membuat komunikasi/koneksi dari database ke java
    public void openConnection(){
        try{
            this.con = DriverManager.getConnection(url, "root", "");
            this.stm = this.con.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Prosedur untuk mengupdate, mengdeletem, menambahkan data dari java ke database
    public void queryPutData(String query){
        try{
            this.stm.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Function untuk mengambil data dari database ke java
    public ResultSet queryGetData(String query){
        try{
            return this.stm.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    //Menutup komunikasi/koneksi dari database ke java
    public void closeConnection(){
        try{
            this.stm.close();
            this.con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
