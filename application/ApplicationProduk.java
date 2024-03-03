/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produk;
import model.Size;

public class ApplicationProduk {
    public void addProduk(String idProduk, String namaProduk, int harga, int size, int stok, String path){
        Database db = new Database();
        
        db.openConnection();
        
        path = path.replace("\\", "\\\\");
        String query = "INSERT INTO produk (idProduk, namaproduk, harga, path) "
                + "VALUES ('%s', '%s', '%d', '%s')";
        query = String.format(query, idProduk, namaProduk, harga, path);
        db.queryPutData(query);
        
        query = "INSERT INTO size (idproduk, size, stok) "
                + "VALUES ('%s', '%d', '%d')";
        query = String.format(query, idProduk, size, stok);
        db.queryPutData(query);
        
        db.closeConnection();
    }
    
    public void deleteProduk(String idProduk, ArrayList<Size> listSize){
        Database db;
        
        db = new Database();
        for(Size size: listSize){
            db.openConnection();
            db.queryPutData("DELETE FROM size WHERE idsize='"+size.getIdsize()+"'");
            db.closeConnection();
        }
        
        db = new Database();
        db.openConnection();
        db.queryPutData("DELETE FROM produk WHERE idproduk='"+idProduk+"'");
        db.closeConnection();
    }
    
    public void updateProduk(String idProduk, int idSize, String nama, int harga, int stok, int size, String path){
        Database db = new Database();
        
        db.openConnection();
        path = path.replace("\\", "\\\\");
        String query = "UPDATE produk SET "
                + "namaproduk='%s', "
                + "harga='%d', "
                + "path='%s' WHERE idproduk='%s'";
        query = String.format(query, nama, harga, path, idProduk);
        db.queryPutData(query);
        
        query = "UPDATE size SET "
                + "size='%d', "
                + "stok='%d' WHERE idsize='%d'";
        query = String.format(query, size, stok, idSize);
        db.queryPutData(query);
        db.closeConnection();
    }
    
    public ArrayList<Produk> getProduk(){
        ArrayList<Produk> listProduk = null;
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM produk");
            
            listProduk = new ArrayList<>();
            while(rs.next()){
                Produk produk = new Produk();
                String idproduk = rs.getString("idproduk");
                
                produk.setHarga(rs.getInt("harga"));
                produk.setIdproduk(idproduk);
                produk.setNamaproduk(rs.getString("namaproduk"));
                produk.setPath(rs.getString("path"));
                produk.setSizeProduk(new ApplicationSize().getSize(idproduk));
               
                listProduk.add(produk);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return listProduk;
    }
    
    public Produk getProdukId(String idProduk){
        Produk produk = null;
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM produk WHERE idproduk='"+idProduk+"'");
            
            if(rs.next()){
                produk = new Produk();
                String idproduk = rs.getString("idproduk");
                
                produk.setHarga(rs.getInt("harga"));
                produk.setIdproduk(idproduk);
                produk.setNamaproduk(rs.getString("namaproduk"));
                produk.setPath(rs.getString("path"));
                produk.setSizeProduk(new ApplicationSize().getSize(idproduk));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return produk;
    }
}
