/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Size;


public class ApplicationSize {
    public ArrayList<Size> getSize(String idproduk){
        ArrayList<Size> listSize = null; 
        Database db = new Database();
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM size WHERE idproduk='"+idproduk+"'");
            
            listSize = new ArrayList<>();
            while(rs.next()){
                Size size = new Size();
                
                size.setIdsize(rs.getInt("idsize"));
                size.setSize(rs.getInt("size"));
                size.setStok(rs.getInt("stok"));
                
                listSize.add(size);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return listSize;
    }
    
    public Size getSizeId(int idSize){
        Database db = new Database();
        Size size = null;
        
        db.openConnection();
        try{
            ResultSet rs = db.queryGetData("SELECT * FROM size WHERE idsize='"+idSize+"'");
            
            if(rs.next()){
                size = new Size();
                
                size.setIdsize(rs.getInt("idsize"));
                size.setSize(rs.getInt("size"));
                size.setStok(rs.getInt("stok"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.closeConnection();
        return size;
    }
}
