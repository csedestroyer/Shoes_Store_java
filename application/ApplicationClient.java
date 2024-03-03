/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Client;

public class ApplicationClient {
    
    //Function login untuk client
    public Client loginClient(String username, String password){
        //Variable untuk database helper
        Database db = new Database();
        
        //membuat koneksi/komunikasi dari java ke database
        db.openConnection();
        
        //variable untuk menyinpan data dari database ke java
        ResultSet rs = db.queryGetData("SELECT * FROM client WHERE "
                + "username='"+username+"' AND password='"+password+"'");
        
        //membuat client untuk dikembalikan nilainya
        try {
            //mengecek apakah data dari database ada atau tidak
            if(rs.next()){
                //membuat client untuk dikembalikan nilainya
                Client client = new Client();
                
                //mengisikan data data client
                client.setAlamat(rs.getString("alamat"));
                client.setIdclient(rs.getInt("idclient"));
                client.setNama(rs.getString("nama"));
                client.setPassword(rs.getString("password"));
                client.setUsername(rs.getString("username"));
                
                //mengembalikan nilai client
                return client;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //menutup koneksi/komunikasi dari java ke database
        db.closeConnection();
        
        //jika kosong, maka null dikembalikan
        return null;
    }
    
    public void registerClient(String nama, String username, String password, String alamat){
        Database db = new Database();
        
        db.openConnection();
        String query = "INSERT INTO client(username, password, nama, alamat) "
            + "VALUES('%s', '%s', '%s', '%s')";
        query = String.format(query, username, password, nama, alamat, "");
        db.queryPutData(query);
        db.closeConnection();
    }
    
    public void updateClient(int idClient, String username, String password, String nama, String alamat){
        Database db = new Database();
        
        db.openConnection();
        String query = "UPDATE client SET "
                + "username='%s', "
                + "password='%s', "
                + "nama='%s', "
                + "alamat='%s' WHERE idclient='%d'";
        query = String.format(query, username, password, nama, alamat, idClient);
        db.queryPutData(query);
        db.closeConnection();
    }
}
