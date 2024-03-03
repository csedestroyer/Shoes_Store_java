/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Logined;
import model.Produk;
import model.Wishlist;


public class ApplicationWishlist {
    public boolean cekWishlist(String idproduk){
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM wishlist WHERE "
                    + "idproduk='"+idproduk+"' AND idclient='"+Logined.loginClient.getIdclient()+"'");
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return false;
    }
    
    public ArrayList<Wishlist> getAllWishlistClient(){
        ArrayList<Wishlist> listWishlist = null;
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM wishlist WHERE idclient='"+Logined.loginClient.getIdclient()+"'");
            listWishlist = new ArrayList();
            while(rs.next()){
                Wishlist wishlist = new Wishlist();
                wishlist.setIdwishlist(rs.getInt("idwishlist"));
                wishlist.setProduk(new ApplicationProduk().getProdukId(rs.getString("idproduk")));
                listWishlist.add(wishlist);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return listWishlist;
    }
    
    public void deleteWishlist(String idproduk){
        Database db = new Database();
        
        db.openConnection();
        db.queryPutData("DELETE FROM wishlist "
                + "WHERE idproduk='"+idproduk+"' AND idclient='"+Logined.loginClient.getIdclient()+"'");
        db.closeConnection();
    }
    
    public void insertWishlist(String idproduk){
        Database db = new Database();
        
        db.openConnection();
        db.queryPutData("INSERT INTO wishlist (idproduk, idclient) "
                + "VALUES('"+idproduk+"', '"+Logined.loginClient.getIdclient()+"')");
        db.closeConnection();
    }
    
    public void addCheckOut(Produk produk, int idSize){
        Database db = new Database();
        
        db.openConnection();
        String idProduk = produk.getIdproduk();
        int jumlah = 1;
        int totalHarga = jumlah * produk.getHarga();
        String query = "INSERT INTO cart (idproduk, idclient, idsize, jumlah, totalharga) "
                + "VALUES ('%s', '%d', '%d', '%d', '%d')";
        query = String.format(query, idProduk, Logined.loginClient.getIdclient(), idSize, jumlah, totalHarga);
        db.queryPutData(query);
        db.closeConnection();
        
        deleteWishlist(idProduk);
    }
}
