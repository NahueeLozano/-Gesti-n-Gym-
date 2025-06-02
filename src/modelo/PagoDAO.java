/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Membresia;
import modelo.Pago;
import modelo.Usuario;

import static modelo.Conexion.getConnexion;
/**
 *
 * @author nahuel lozano
 */
public class PagoDAO  extends Gestion {
   private Connection Cone;
   
    public PagoDAO(Connection  cone ){
        this.Cone = cone;
    }
    
   
    public PagoDAO() {
    }

    @Override
    public List<Pago> obtenerTodo() {
        List<Pago> Pagos = new ArrayList<>();
        
        var query = "SELECT p.idPago, p.monto, p.estado, p.fecha_pago, " +
                   "u.idUsuario, u.nombre, u.apellido, u.dni, u.email, " +
                   "m.nombre AS nombreMembresia " +
                   "FROM Pagos p " +
                   "JOIN Usuarios u ON p.idUsuario = u.idUsuario " +
                   "JOIN Membresias m ON p.idMembresia = m.idMembresia";
        
        
        try(Connection con = getConnexion(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery();){
        
            while(rs.next()){
                Pago pago = new Pago(
                        
                        rs.getInt("idPago"),
                        rs.getInt("monto"),
                        rs.getString("estado"),
                        rs.getDate("Fecha_pago"),
                        new Usuario (
                                    rs.getInt("idUsuario"),
                                    rs.getString("nombre"), 
                                    rs.getString ("apellido"),
                                    rs.getInt("dni"),
                                    rs.getString("email")),
                        new Membresia (
                                    rs.getString("nombre"),
                                    rs.getString("estado"))
                );
                Pagos.add(pago);
                
            }
        } catch (Exception e) {
            System.err.println("Error al listar Usuario: " + e.getMessage());
        }
        
        return Pagos;
    }
    

  
    public List<Pago> listarPagoPorUsuario() {
      
        List<Pago> pagos = new ArrayList<>();
        
        var query ="SELECT * FROM pagos WHERE id_usuario =?";
        

        try(Connection con = getConnexion(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery();){
        
            
             
                while(rs.next()){ 
                    var pago = new Pago ();
                    pago.setIdPago(rs.getInt("idPago"));
                    pago.setMonto(rs.getInt("monto"));
                    pago.setEstado(rs.getString("estado"));
                    pago.setFecha_pago(rs.getDate("Fecha_pago"));
     

                        
                }
            
        } catch (Exception e) {
            System.err.println("Error al listar Usuario: " + e.getMessage());
        }
     
     return pagos;
        
        
    }

   
    public boolean resgistrarPago(Pago pago){
     
       var query ="INSERT INTO Pagos (idUsuario, monto, estado, fecha_pago, idMembresia) VALUES (?, ?, ?,?, ?)";

        var queryActualizarMembresia = "UPDATE membresia SET estado= 'activo' WHERE idMembresia=?";
    try (Connection con = getConnexion(); PreparedStatement ps = con.prepareStatement(query)) {
     ps.setInt(1, pago.getUsuario().getIdUsuario());
    ps.setDouble(2, pago.getMonto());
    ps.setString(3, pago.getEstado());
    ps.setDate(4, new java.sql.Date(pago.getFecha_pago().getTime())); // Conversión correcta
    ps.setInt(5, pago.getMembresia().getIdMembresia());

    ps.executeUpdate(); 
    return true; 
} catch (Exception e) {
    System.out.println("ERROR AL INSERTAR PAGO: " + e.getMessage());
    return false;
}
}


    
    
    
    
    
    
    
    
    
    



    
     
}
