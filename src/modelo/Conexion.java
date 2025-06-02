/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author nahuel lozano
 */
public class Conexion {
      
     public static Connection getConnexion() {
       Connection conexion = null;
       var baseDatos ="gymf";
       var url = "jdbc:mysql://localhost:3306/" + baseDatos;
       var usuario = "root";
       var password = "";
       var Driver = "com.mysql.cj.jdbc.Driver";
       try {
           Class.forName(Driver);
           conexion = DriverManager.getConnection(url, usuario, password);

       } catch (Exception e) {
           System.out.println("error en la base de datos" + e.getMessage());
       }
   return conexion;
   }

   public static  void main(String[] args){
       var conexion = getConnexion();
       if (conexion!= null){
           System.out.println("conexion exitosa "+ conexion);
       }else
           System.out.println("error al conectarce");
   }
   
}
