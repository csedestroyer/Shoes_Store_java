/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProduk;
import controller.ControllerWishlist;
import java.awt.Color;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import model.Size;
import model.Wishlist;

public class BoxWishlist extends javax.swing.JPanel {

    /**
     * Creates new form BoxWishlist
     */
    private final Wishlist wishlist;
    private final view.Wishlist viewWish;
    private Home home;
    public BoxWishlist(Home home, view.Wishlist viewWish, Wishlist wishlist) {
        initComponents();
        this.viewWish = viewWish;
        this.wishlist = wishlist;
        this.home = home;
        
        setWishlist();
    }
    
    private void setWishlist(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Locale indo = new Locale("in", "ID");
        int stok = this.wishlist.getProduk().getSizeProduk().get(0).getStok();
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(indo);
        
        if(stok != 0){
            labelHarga.setText(formatRp.format(this.wishlist.getProduk().getHarga()));
        }else{
            labelHarga.setForeground(Color.red);
            labelHarga.setText("SOLD OUT");
        }
        
        for(Size size: this.wishlist.getProduk().getSizeProduk()){
            model.addElement(size.getSize());
        }
        chooseSize.setModel(model);
        
        //set Image produk
        ImageIcon icon = new ImageIcon(this.wishlist.getProduk().getPath());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(110, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        imageProduk.setIcon(scaledIcon);
        
        labelNama.setText(this.wishlist.getProduk().getNamaproduk());
        labelStok.setText("Stok: " + String.valueOf(stok));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        imageProduk = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelSize = new javax.swing.JLabel();
        labelStok = new javax.swing.JLabel();
        buttonDelete = new javax.swing.JButton();
        buttonCO = new javax.swing.JButton();
        chooseSize = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(imageProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 80));

        labelNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNama.setText("Nama Produk");
        jPanel2.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 40));

        labelHarga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelHarga.setText("Label Harga");
        jPanel2.add(labelHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 160, 20));

        labelSize.setText("Size:");
        jPanel2.add(labelSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 30, 20));

        labelStok.setText("Stok:");
        jPanel2.add(labelStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 50, 20));

        buttonDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 70, 30));

        buttonCO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonCO.setText("Check Out");
        buttonCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCOActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCO, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 90, 30));

        chooseSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseSizeActionPerformed(evt);
            }
        });
        jPanel2.add(chooseSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 50, 20));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
        new ControllerWishlist(this.home, this.viewWish).deleteWishlist(this.wishlist.getProduk());
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void chooseSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseSizeActionPerformed
        // TODO add your handling code here:
        new ControllerProduk(this.home).refreshStok(chooseSize, labelStok, labelHarga, this.wishlist.getProduk());
    }//GEN-LAST:event_chooseSizeActionPerformed

    private void buttonCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCOActionPerformed
        // TODO add your handling code here:
        int idSize = this.wishlist.getProduk().getSizeProduk().get(chooseSize.getSelectedIndex()).getIdsize();
        new ControllerWishlist(this.home, this.viewWish).addCheckOut(this.wishlist.getProduk(), idSize);
    }//GEN-LAST:event_buttonCOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCO;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JComboBox<String> chooseSize;
    private javax.swing.JLabel imageProduk;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelSize;
    private javax.swing.JLabel labelStok;
    // End of variables declaration//GEN-END:variables
}
