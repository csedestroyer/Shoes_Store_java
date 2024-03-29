/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProduk;
import controller.ControllerWishlist;
import model.Produk;

public class BoxProduk extends javax.swing.JPanel {

    /**
     * Creates new form BoxProduk
     */
    private final Produk produk;
    
    public BoxProduk(Produk produk) {
        initComponents();
        this.produk = produk;
        
        new ControllerProduk(null).setWishlist(
                labelNama,
                labelHarga,
                labelStok,
                iconWishlist,
                imageProduk,
                chooseSize,
                this.produk
        );
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageProduk = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        iconWishlist = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chooseSize = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        labelStok = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(imageProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 280, 280));

        labelHarga.setText("Label Price");
        add(labelHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 250, 20));

        labelNama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelNama.setText("Nama Produk");
        add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 250, 20));

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        add(btnBuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 60, 20));

        iconWishlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconWishlistMouseClicked(evt);
            }
        });
        add(iconWishlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 20, 20));

        jLabel2.setText("Size:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, 20));

        chooseSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseSizeActionPerformed(evt);
            }
        });
        add(chooseSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 60, -1));

        jLabel3.setText("Stok:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, 20));

        labelStok.setText("count");
        add(labelStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void iconWishlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconWishlistMouseClicked
        // TODO add your handling code here:
        new ControllerProduk(null).updateWishlist(iconWishlist, produk);
    }//GEN-LAST:event_iconWishlistMouseClicked

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        int idSize = this.produk.getSizeProduk().get(chooseSize.getSelectedIndex()).getIdsize();
        new ControllerWishlist(null, null).addCheckOut(this.produk, idSize);
    }//GEN-LAST:event_btnBuyActionPerformed

    private void chooseSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseSizeActionPerformed
        // TODO add your handling code here:
        new ControllerProduk(null).refreshStok(chooseSize, labelStok, labelHarga, produk);
    }//GEN-LAST:event_chooseSizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JComboBox<String> chooseSize;
    private javax.swing.JLabel iconWishlist;
    private javax.swing.JLabel imageProduk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelStok;
    // End of variables declaration//GEN-END:variables
}
