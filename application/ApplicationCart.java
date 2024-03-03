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
import model.Cart;
import model.Produk;

public class ApplicationCart {
    public ArrayList<Cart> getAllCart(){
        ArrayList<Cart> listCart = null;
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM cart WHERE idclient='"+Logined.loginClient.getIdclient()+"'");
            
            listCart = new ArrayList<>();
            while(rs.next()){
                Cart cart = new Cart();
                
                cart.setIdcart(rs.getInt("idcart"));
                cart.setProduk(new ApplicationProduk().getProdukId(rs.getString("idproduk")));
                cart.setSize(new ApplicationSize().getSizeId(rs.getInt("idsize")));
                cart.setJumlah(rs.getInt("jumlah"));
                cart.setTotalharga(rs.getInt("totalharga"));
                
                listCart.add(cart);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        
        return listCart;
    }
    
    public void deleteCart(int idCart){
        Database db = new Database();
        
        db.openConnection();
        db.queryPutData("DELETE FROM cart WHERE idcart='"+idCart+"'");
        db.closeConnection();
    }
    
    public void buyCart(Cart cartP, int stokBuy){
        Database db;
        
        db = new Database();
        db.openConnection();
        db.queryPutData("UPDATE size SET stok='"+(cartP.getSize().getStok() - stokBuy)+"' "
                + "WHERE idsize='"+cartP.getSize().getIdsize()+"'");
        db.closeConnection();
        
        db = new Database();
        db.openConnection();
        db.queryPutData("DELETE FROM cart WHERE idcart='"+cartP.getIdcart()+"'");
        db.closeConnection();
    }
}
