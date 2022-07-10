package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author numbe
 */
public class Conexion {
    Connection con;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/p","root","");
                                            // URL de la BD - USUARIO - CONTRASE:A
        }catch(Exception e){
            System.err.println("Error:" +e);
        }
        
    }
    
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try{
             st = cn.con.createStatement();
             rs = st.executeQuery("select * from Dormitorio");
             int i =0;
             
             while(rs.next()){
                 if(rs.getInt("id")==3){
                     System.out.println(rs.getInt("id") + " " + rs.getString("Objeto"));
             i++;}
             }
             
            
        }catch(Exception e){
            
        }
    }
    
}
