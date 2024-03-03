/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.ApplicationCart;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.BoxCart;
import view.Home;

public class ControllerCart {
    private final ArrayList<model.Cart> listCart;
    private Home home;
    private view.Cart cartPage;
    
    public ControllerCart(Home home, view.Cart cartPage){
        this.listCart = new ApplicationCart().getAllCart();
        this.home = home;
        this.cartPage = cartPage;
    }
    
    public void showCart(JPanel panel){
        panel.setLayout(new GridLayout(0, 1));
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for(model.Cart cart: this.listCart){
            panel.add(new BoxCart(this.home, this.cartPage, cart));
        }
    }
    
    public void buyCart(model.Cart cartP, int stokBeli){
        new ApplicationCart().buyCart(cartP, stokBeli);
        
        JOptionPane.showMessageDialog(this.cartPage, "Produk Terbeli");
        this.cartPage.setBuyProduk(null);
        this.cartPage.setBuyText(0);
    }
    
    public void deleteCart(int idCart){
        int cek = JOptionPane.showConfirmDialog(this.cartPage, "Delete produk cart?");
        
        if(cek == 0){
            new ApplicationCart().deleteCart(idCart);
            
            JOptionPane.showMessageDialog(this.cartPage, "Produk terhapus di cart");
            this.cartPage.setBuyProduk(null);
            this.cartPage.setBuyText(0);
        }
    }
}
