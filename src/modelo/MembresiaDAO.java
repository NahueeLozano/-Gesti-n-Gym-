/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static modelo.Conexion.getConnexion;

public class MembresiaDAO  {

   
    public int obtenerIdMembresiaPorUsuario(int idUsuario) {
        
         String query = "SELECT idMembresia FROM Membresias WHERE idUsuario = ? AND estado = 'activo' LIMIT 1";
        try (Connection con = getConnexion();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("idMembresia"); // Retorna el ID de la membresía existente
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar membresía: " + e.getMessage());
        }
        return -1; // Retorna -1 si no tiene membresía activa
    }
        
       
   


    
    
  public int crearNuevaMembresiaManual(int idUsuario, String nombreMembresia) throws SQLException {
     String query = "INSERT INTO Membresias (nombre,estado,fecha_inicio,fecha_fin,idUsuario) VALUES (?, 'activo', NOW(),DATE_ADD(NOW(),INTERVAL 1 MONTH),?)";
     try(Connection con = getConnexion();
         PreparedStatement ps= con.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)){
         ps.setString(1, nombreMembresia);
         ps.setInt(2, idUsuario);
         ps.executeUpdate();
         try(ResultSet rs= ps.getGeneratedKeys()){
             if(rs.next()){
                 return rs.getInt(1);
             }
         }
     }catch(Exception e){
         System.out.println("error al crear nueva membresia: " + e.getMessage());
     }
     return -1;
  }
}

 



