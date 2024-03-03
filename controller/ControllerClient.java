/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.ApplicationAdmin;
import application.ApplicationClient;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Client;
import model.Logined;
import view.Admin;
import view.Home;
import view.Login;
import view.Profile;
import view.Register;

public class ControllerClient {
    private final Login login;
    private final Register register;
    
    //kontruksi untuk ngeset jframe
    public ControllerClient(Login login, Register register) {
        this.login = login;
        this.register = register;
    }
    
    //Prosedur untuk client login, dengan parameter username, password dan label
    public void clientLogin(String username, String password, JLabel warningLabel){
        //set warna label
        warningLabel.setForeground(Color.red);
        
        //cek apakah username atau password kosong
        if(username.equals("") || password.equals("")){
            //jika kosong maka set label dengan teks yang diinginkan
            warningLabel.setText("Data kosong, Harap isi terlebih dahulu");
        }else{
            //membuat var client untuk mengambil nilai dari function loginclient
            Client client = new ApplicationClient().loginClient(username, password);
            
            //cek apakah clientnya null, artinya jika null maka tidak ditemukannya 
            //username dan password yang user inputkan sebelumnya
            if(client != null){
                //jika client ditemukan
                //maka mengeluarkan dialog infomasi
                JOptionPane.showMessageDialog(this.login, "Login berhasil");
                
                
                //set client yang login
                Logined.loginClient = client;
                
                //menampilkan page home
                new Home().setVisible(true);
                //menutup page login
                this.login.dispose();
            }else{
                //jika client tidak ditemukan
                //maka set label dengan teks yang diinginkan
                model.Admin admin = new ApplicationAdmin().loginAdmin(username, password);
                
                if(admin != null){
                    new Admin().setVisible(true);
                    this.login.dispose();
                }else{
                    warningLabel.setText("Username atau Password salah");
                }
            }
        }
    }
    
    public void clientRegister(String nama, String username, String password, String retypePassword, String alamat, JLabel warningLabel){
        warningLabel.setForeground(Color.red);
        //cek nama atau username atau password atau retypepassword atau alamat
        if(nama.equals("") || username.equals("") || password.equals("") || alamat.equals("") || retypePassword.equals("")){
            //jika kosong maka set label
            warningLabel.setText("Data kosong, Harap isi terlebih dahulu");
        }else{
            //jika tidak
            //mengecek password apakah sama dengan retype password
            if(password.equals(retypePassword)){
                //jika sama, maka pembuatan client/registrasi client dilakukan
                new ApplicationClient().registerClient(nama, username, password, alamat);
                
                JOptionPane.showMessageDialog(this.register, "Registrasi berhasil");
                
                new Login().setVisible(true);
                this.register.dispose();
            }else{
                //jika berbeda, maka set label
                warningLabel.setText("Pengetikan ulang password salah");
            }
        }
    }
    
    public void clientUpdate(int idClient, String username, String password, String nama, String alamat){
        if(username.equals("") || password.equals("") || nama.equals("") || alamat.equals("")){
            JOptionPane.showMessageDialog(null, "Data kosong");
        }else{
            new ApplicationClient().updateClient(idClient, username, password, nama, alamat);
            
            JOptionPane.showMessageDialog(null, "Update profile client berhasil");
            
            Logined.loginClient = new ApplicationClient().loginClient(username, password);
            new Profile().setVisible(true);
        }
    }
    
    
}
