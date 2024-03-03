/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.ApplicationWishlist;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Produk;
import model.Wishlist;
import view.BoxWishlist;
import view.Home;

public class ControllerWishlist {
    private ArrayList<Wishlist> listWishlist;
    private view.Wishlist viewWish;
    private Home home;
    
    public ControllerWishlist(Home home, view.Wishlist viewWish){
        listWishlist = new ArrayList<>();
        this.viewWish = viewWish;
        this.home = home;
        this.listWishlist = new ApplicationWishlist().getAllWishlistClient();
    }
    
    public void deleteWishlist(Produk produk){
        new ApplicationWishlist().deleteWishlist(produk.getIdproduk());
        JOptionPane.showMessageDialog(null, (produk.getNamaproduk() + " terhapus di wishlist"));
        
        new view.Wishlist(this.home).setVisible(true);
        this.viewWish.dispose();
    }
    
    public void showWishlistClient(JPanel panel){
        panel.setLayout(new GridLayout(0, 2, 0, 0));
        for(Wishlist wishlist: this.listWishlist){
            panel.add(new BoxWishlist(this.home, this.viewWish, wishlist));
        }
    }
    
    public void addCheckOut(Produk produk, int idSize){
        new ApplicationWishlist().addCheckOut(produk, idSize);
        JOptionPane.showMessageDialog(null, "Data sudah ditambahkan ke CheckOut");
        
        if(this.viewWish != null){
            new view.Wishlist(this.home).setVisible(true);
            this.viewWish.dispose();
        }
    }
}
