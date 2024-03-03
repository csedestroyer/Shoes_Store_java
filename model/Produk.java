/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Produk {
    private String idproduk;
    private String namaproduk;
    private ArrayList<Size> sizeProduk;
    private int harga;
    private String path;

    public String getIdproduk() {
        return idproduk;
    }

    public void setIdproduk(String idproduk) {
        this.idproduk = idproduk;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public ArrayList<Size> getSizeProduk() {
        return sizeProduk;
    }

    public void setSizeProduk(ArrayList<Size> sizeProduk) {
        this.sizeProduk = sizeProduk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
