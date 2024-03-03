/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Wishlist {
    private int idwishlist;
    private Produk produk;

    public int getIdwishlist() {
        return idwishlist;
    }

    public void setIdwishlist(int idwishlist) {
        this.idwishlist = idwishlist;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }
}
