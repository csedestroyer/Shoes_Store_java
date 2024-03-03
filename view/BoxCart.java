/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.ApplicationSize;
import controller.ControllerProduk;
import java.awt.Color;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Size;
import model.Cart;

public class BoxCart extends javax.swing.JPanel {

    /**
     * Creates new form BoxWishlist
     */
    private final Home home;
    private final view.Cart cartPage;
    private final Cart cart;
    public BoxCart(Home home, view.Cart cartPage, Cart cart) {
        initComponents();
        this.home = home;
        this.cart = cart;
        this.cartPage = cartPage;
        
        setCart();
    }
    
    private void setCart(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Locale indo = new Locale("in", "ID");
        int stok = this.cart.getSize().getStok();
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(indo);
        
        if(stok != 0){
            labelHarga.setText(formatRp.format(this.cart.getProduk().getHarga()));
        }else{
            labelHarga.setForeground(Color.red);
            labelHarga.setText("SOLD OUT");
        }
        
        for(Size size: new ApplicationSize().getSize(this.cart.getProduk().getIdproduk())){
            model.addElement(size.getSize());
        }
        chooseSize.setModel(model);
        
        //set Image produk
        ImageIcon icon = new ImageIcon(this.cart.getProduk().getPath());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(110, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageProduk.setIcon(scaledIcon);
        
        labelNama.setText(this.cart.getProduk().getNamaproduk());
        labelStok.setText(String.valueOf(stok));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCart = new javax.swing.JPanel();
        imageProduk = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelSize = new javax.swing.JLabel();
        labelStok = new javax.swing.JLabel();
        chooseSize = new javax.swing.JComboBox<>();
        countQyt = new javax.swing.JSpinner();
        labelStok1 = new javax.swing.JLabel();
        labelStok2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCart.setBackground(new java.awt.Color(255, 255, 255));
        panelCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCartMousePressed(evt);
            }
        });
        panelCart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCart.add(imageProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 80));

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNama.setText("Nama Produk");
        panelCart.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 40));

        labelHarga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelHarga.setText("Label Harga");
        panelCart.add(labelHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 260, 20));

        labelSize.setText("Size:");
        panelCart.add(labelSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 30, 20));

        labelStok.setText("stok");
        panelCart.add(labelStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 30, 20));

        chooseSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseSizeActionPerformed(evt);
            }
        });
        panelCart.add(chooseSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 50, 20));
        panelCart.add(countQyt, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 110, 110, 30));

        labelStok1.setText("Qty: ");
        panelCart.add(labelStok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 30, 30));

        labelStok2.setText("Stok:");
        panelCart.add(labelStok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 30, 20));

        add(panelCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void chooseSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseSizeActionPerformed
        // TODO add your handling code here:
        new ControllerProduk(this.home).refreshStok(chooseSize, labelStok, labelHarga, this.cart.getProduk());
    }//GEN-LAST:event_chooseSizeActionPerformed

    private void panelCartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCartMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            if((int)countQyt.getValue() > 0){
                this.cartPage.setBuyProduk(this.cart);
                this.cartPage.setBuyText((int) countQyt.getValue());
            }else{
                JOptionPane.showMessageDialog(null, "Masukkan banyaknya barang");
            }
        }
    }//GEN-LAST:event_panelCartMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chooseSize;
    private javax.swing.JSpinner countQyt;
    private javax.swing.JLabel imageProduk;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelStok;
    private javax.swing.JLabel labelStok1;
    private javax.swing.JLabel labelStok2;
    private javax.swing.JPanel panelCart;
    // End of variables declaration//GEN-END:variables
}