/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.ApplicationProduk;
import application.ApplicationWishlist;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Produk;
import model.Size;
import view.BoxProduk;
import view.Home;

public class ControllerProduk {
    private Home home;
    
    public ControllerProduk(Home home){
        this.home = home;
    }
    
    public void showProduk(JPanel panel){
        panel.setLayout(new GridLayout(0, 4));
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        for(Produk produk: new ApplicationProduk().getProduk()){
            panel.add(new BoxProduk(produk));
        }
    }
    
    public void setWishlist(JLabel labelNama, JLabel labelHarga, 
            JLabel labelStok, JLabel iconWishlist, JLabel imageProduk, 
            JComboBox chooseSize, Produk produk){
        int stok = produk.getSizeProduk().get(0).getStok();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Locale indo = new Locale("in", "ID");
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(indo);
        
        if(stok != 0){
            labelHarga.setText(formatRp.format(produk.getHarga()));
        }else{
            labelHarga.setForeground(Color.red);
            labelHarga.setText("SOLD OUT");
        }
        
        for(Size size: produk.getSizeProduk()){
            model.addElement(size.getSize());
        }
        chooseSize.setModel(model);
        
        labelNama.setText(produk.getNamaproduk());
        labelStok.setText(String.valueOf(stok));
        
        if(new ApplicationWishlist().cekWishlist(produk.getIdproduk())){
            //set icon tidak untuk wishlist
            ImageIcon icon = new ImageIcon("C:\\TubesHydraCorp\\image\\wishlished.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            iconWishlist.setIcon(scaledIcon);
        }else{
            //set icon untuk mengwishlist
            ImageIcon icon = new ImageIcon("C:\\TubesHydraCorp\\image\\wishlish.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            iconWishlist.setIcon(scaledIcon);
        }
        
        //set Image produk
        ImageIcon icon = new ImageIcon(produk.getPath());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(253, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageProduk.setIcon(scaledIcon);
    }
    
    public void refreshStok(JComboBox chooseSize, JLabel labelStok, JLabel labelHarga, Produk produk){
        if(chooseSize.getSelectedIndex() != -1){
            int stok = produk.getSizeProduk().get(chooseSize.getSelectedIndex()).getStok();
            
            if(stok != 0){
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                Locale indo = new Locale("in", "ID");
                NumberFormat formatRp = NumberFormat.getCurrencyInstance(indo);
                
                labelHarga.setForeground(Color.black);
                labelHarga.setText(formatRp.format(produk.getHarga()));
                labelStok.setText(String.valueOf(stok));
            }else{
                labelStok.setText(String.valueOf(stok));
                labelHarga.setForeground(Color.red);
                labelHarga.setText("SOLD OUT");
            }
            
        }
    }
    
    public void updateWishlist(JLabel iconWishlist, Produk produk){
        if(new ApplicationWishlist().cekWishlist(produk.getIdproduk())){
            new ApplicationWishlist().deleteWishlist(produk.getIdproduk());
            JOptionPane.showMessageDialog(null, (produk.getNamaproduk() + " terhapus di wishlist"));
            
            //set icon tidak untuk wishlist
            ImageIcon icon = new ImageIcon("C:\\TubesHydraCorp\\image\\wishlish.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            iconWishlist.setIcon(scaledIcon);
        }else{
            new ApplicationWishlist().insertWishlist(produk.getIdproduk());
            JOptionPane.showMessageDialog(null, (produk.getNamaproduk() + " ditambahkan ke wishlist"));
            
            //set icon untuk mengwishlist
            ImageIcon icon = new ImageIcon("C:\\TubesHydraCorp\\image\\wishlished.png");
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            iconWishlist.setIcon(scaledIcon);
        }
    }
}
