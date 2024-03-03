/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerClient;
import javax.swing.JOptionPane;
import model.Client;
import model.Logined;

public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    private final Client client;
    private String username;
    private String password;
    private String nama;
    private String alamat;
    public Profile() {
        initComponents();
        this.client = Logined.loginClient;
        this.username = this.client.getUsername();
        this.password = this.client.getPassword();
        this.nama = this.client.getNama();
        this.alamat = this.client.getAlamat();
        
        setTeks();
    }
    
    private void setTeks(){
        labelNama.setText(this.nama);
        labelAddress.setText(this.alamat);
        labelUsername.setText(this.username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelInformasiakun = new javax.swing.JLabel();
        nameProfile = new javax.swing.JLabel();
        usernameProfile = new javax.swing.JLabel();
        passwordProfile = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        editAddress = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        editPassword = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        editUsername = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        editName = new javax.swing.JButton();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        seePass = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        title2.setFont(new java.awt.Font("Cascadia Code", 1, 24)); // NOI18N
        title2.setText("HYDRA CORP.");

        Back.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        Back.setText("<-BACK");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(title2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title2)
                    .addComponent(Back))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setLayout(null);

        labelInformasiakun.setFont(new java.awt.Font("Cascadia Mono", 1, 36)); // NOI18N
        labelInformasiakun.setText("My Profile");
        jPanel2.add(labelInformasiakun);
        labelInformasiakun.setBounds(80, 0, 240, 60);
        jPanel2.add(nameProfile);
        nameProfile.setBounds(210, 80, 0, 0);
        jPanel2.add(usernameProfile);
        usernameProfile.setBounds(210, 120, 0, 0);
        jPanel2.add(passwordProfile);
        passwordProfile.setBounds(210, 160, 0, 0);
        jPanel2.add(jLabel8);
        jLabel8.setBounds(210, 230, 0, 0);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editAddress.setText("Edit Address");
        editAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAddressActionPerformed(evt);
            }
        });
        jPanel3.add(editAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 120, 20));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel4.setText("Address ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 20));

        editPassword.setText("Edit Password");
        editPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPasswordActionPerformed(evt);
            }
        });
        jPanel3.add(editPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 120, 20));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel3.setText("Password ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 20));

        editUsername.setText("Edit Username");
        editUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUsernameActionPerformed(evt);
            }
        });
        jPanel3.add(editUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 120, 20));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel2.setText("Username ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 20));

        labelAddress.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        labelAddress.setText("Address");
        jPanel3.add(labelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 210, 20));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel1.setText(":");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 20, 20));

        labelNama.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        labelNama.setText("Nama");
        jPanel3.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 210, 20));

        editName.setText("Edit Name");
        editName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNameActionPerformed(evt);
            }
        });
        jPanel3.add(editName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 120, 20));

        labelUsername.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        labelUsername.setText("Username");
        jPanel3.add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 210, 20));

        labelPassword.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        labelPassword.setText("****************");
        jPanel3.add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 210, 20));

        jLabel10.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel10.setText("Name ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, 20));

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel11.setText(":");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 20, 20));

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel12.setText(":");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 20, 20));

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 1, 13)); // NOI18N
        jLabel13.setText(":");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 20, 20));

        seePass.setText("See Password");
        seePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                seePassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                seePassMouseReleased(evt);
            }
        });
        jPanel3.add(seePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 120, 20));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, 40));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        jPanel2.add(jPanel3);
        jPanel3.setBounds(60, -20, 540, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int idClient = Logined.loginClient.getIdclient();
        
        new ControllerClient(null, null).clientUpdate(idClient, username, password, nama, alamat);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void editNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNameActionPerformed
        // TODO add your handling code here:
        this.nama = JOptionPane.showInputDialog(this, "Inputkan nama baru: ");
        setTeks();
    }//GEN-LAST:event_editNameActionPerformed

    private void seePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seePassMousePressed
        // TODO add your handling code here:
        labelPassword.setText(Logined.loginClient.getPassword());
    }//GEN-LAST:event_seePassMousePressed

    private void seePassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seePassMouseReleased
        // TODO add your handling code here:
        labelPassword.setText("****************");
    }//GEN-LAST:event_seePassMouseReleased

    private void editUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUsernameActionPerformed
        // TODO add your handling code here:
        this.username = JOptionPane.showInputDialog(this, "Inputkan username baru: ");
        setTeks();
    }//GEN-LAST:event_editUsernameActionPerformed

    private void editPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPasswordActionPerformed
        // TODO add your handling code here:
        this.password = JOptionPane.showInputDialog(this, "Inputkan password baru: ");
        setTeks();
    }//GEN-LAST:event_editPasswordActionPerformed

    private void editAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAddressActionPerformed
        // TODO add your handling code here:
        this.alamat = JOptionPane.showInputDialog(this, "Inputkan alamat baru: ");
        setTeks();
    }//GEN-LAST:event_editAddressActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Logined.loginClient = null;
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton editAddress;
    private javax.swing.JButton editName;
    private javax.swing.JButton editPassword;
    private javax.swing.JButton editUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelInformasiakun;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel nameProfile;
    private javax.swing.JLabel passwordProfile;
    private javax.swing.JButton seePass;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel usernameProfile;
    // End of variables declaration//GEN-END:variables
}
