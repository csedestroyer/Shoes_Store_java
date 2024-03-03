/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.ApplicationProduk;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.Produk;
import model.Size;
import view.Admin;

public class ControllerAdmin {
    private final Admin admin;
    private ArrayList<Produk> listProduk;
    
    public ControllerAdmin(Admin admin){
        this.admin = admin;
        this.listProduk = new ApplicationProduk().getProduk();
    }
    
    public void addProduk(String idProduk, String namaProduk, int harga, int size, int stok, String path){
        new ApplicationProduk().addProduk(idProduk, namaProduk, harga, size, stok, path);
        
        JOptionPane.showMessageDialog(this.admin, "Data ditambahkan");
        this.admin.clearText();
        new Admin().setVisible(true);
        this.admin.dispose();
    }
    
    public void showDataProduk(JList listUpdate, JList listShow){
        DefaultListModel<String> modelUpdate = new DefaultListModel<>();
        DefaultListModel<String> modelShow = new DefaultListModel<>();
        
        for(Produk produk: this.listProduk){
            modelUpdate.addElement(produk.getNamaproduk());
            modelShow.addElement(produk.getNamaproduk());
        }
        
        listUpdate.setModel(modelUpdate);
        listShow.setModel(modelShow);
    }
    
    public void updateProduk(String idProduk, int idSize, String nama, int harga, int stok, int size, String path){
        new ApplicationProduk().updateProduk(idProduk, idSize, nama, harga, stok, size, path);
        
        JOptionPane.showMessageDialog(this.admin, "Update data berhasil");
        new Admin().setVisible(true);
        this.admin.dispose();
    }
    
    public void deleteProduk(String idProduk, ArrayList<Size> listSize){
        int cek = JOptionPane.showConfirmDialog(this.admin, "Hapus Produk?");
        
        if(cek == 0){
            new ApplicationProduk().deleteProduk(idProduk, listSize);
            
            JOptionPane.showMessageDialog(this.admin, "Produk terhapus");
            
            new Admin().setVisible(true);
            this.admin.dispose();
        }
    }
    
    public ArrayList<Produk> getAllProduk(){
        return this.listProduk;
    }
}
