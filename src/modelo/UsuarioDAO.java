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
import static modelo.Conexion.getConnexion;
import modelo.Usuario;



/*
 * Clase UsuarioDAO: Encargada de gestionar las operaciones CRUD sobre la tabla 'usuarios'.
 * Hereda de la clase abstracta Gestion.
 */
public class UsuarioDAO extends Gestion {

    // Constructor vacío
    public UsuarioDAO (){
        
    }
    // Implementación del método abstracto para obtener todos los usuarios
    @Override
    public List<Usuario> obtenerTodo(){
     // LOGICA DE LISTAR USUARIO
     List<Usuario> usuarios = new ArrayList<>();
     
     // Consulta SQL para obtener los datos de los usuarios
     String query = "SELECT idUsuario, nombre, apellido, dni, email, nombreUsuario FROM usuarios ";
      
    
        try (Connection con = getConnexion(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery();){
                while(rs.next()){ 
                    //crea una instacia de Usuario
                    Usuario usuario  = new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getString ("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("dni"),
                    rs.getString("email"),
                    rs.getString("nombreUsuario")
                    );
                     usuarios.add(usuario);
                }
               
            
        } catch (Exception e) {
            System.err.println("Error al listar Usuario: " + e.getMessage());
        }
     
     return usuarios;
     

    }
   
    // Método para agregar un nuevo usuario a la base de datos
    public boolean agregarUsuario(Usuario usuario) {
        PreparedStatement ps;
        var query = "INSERT INTO usuarios (nombre, apellido,dni,email,nombreUsuario,contraseña)" + "VALUES(?,?,?,?,?,?)";
           
                try{
                    Connection cone = getConnexion(); //llama a la conexion
                    ps =cone.prepareStatement(query);
                    ps.setString(1,usuario.getNombre());
                    ps.setString(2,usuario.getApellido());
                    ps.setInt(3, usuario.getDni());
                    ps.setString(4,usuario.getEmail());
                    ps.setString(5,usuario.getNombreUsuario());
                    ps.setString(6,usuario.getContraseña());
                    ps.execute();
                    return true;
                    
                }catch(Exception e){
                    System.out.println("error a insertar datos: "+ e);
                }
        return false;
    }

   
    // Método para modificar los datos de un usuario existente
    public boolean modificarUsuario(Usuario usuario) {
        PreparedStatement ps;
        var query ="UPDATE usuarios SET nombre=?, apellido =?, dni = ?,email =? WHERE idUsuario=?";
        try{
            Connection cone = getConnexion();
            ps = cone.prepareStatement(query);
            ps.setString(1,usuario.getNombre());
            ps.setString (2,usuario.getApellido());
            ps.setInt(3,usuario.getDni());
            ps.setString (4,usuario.getEmail());
            ps.setInt(5, usuario.getIdUsuario());
            ps.execute();
            return true;
            
        }catch(Exception e){
            System.out.println("error en actualizar los datos" + e);
          
        }
        return false;
    }


    // Método para eliminar un usuario por su ID
    public boolean eliminarUsuario(int id) {
        
        var query ="DELETE FROM Usuarios where idUsuario =?";
        
        try(Connection con = getConnexion(); PreparedStatement ps = con.prepareStatement(query)){
            
            ps.setInt(1,id);
           return  ps.executeUpdate()>0;
           
        }catch(Exception e){
            System.out.println("error al eliminar usuario" + e);
            return false;
        }
        
        
    }

    // Método para buscar un usuario por su ID y cargar sus datos en el objeto Usuario
    public boolean buscarUsuario(Usuario usuario) {
             PreparedStatement ps;
        ResultSet rs;
        var query = "SELECT * FROM usuarios WHERE idUsuario = ?";
        try {
              System.out.println(" Buscando usuario con idUsuario: " + usuario.getIdUsuario());
            Connection cone = getConnexion();
            ps = cone.prepareStatement(query);
            ps.setInt(1, usuario.getIdUsuario());
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("error al buscar usuario " + e);
        }
        return false;
    }
    

    // Método para buscar un usuario por su DNI
    public Usuario buscarUsuarioPorDni(int dni) {
        PreparedStatement ps;
        ResultSet rs;
        var query = "SELECT * FROM usuarios WHERE dni = ?";
        try {
            Connection cone = getConnexion();
            ps = cone.prepareStatement(query);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setDni(rs.getInt("dni"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                return usuario;
            }
        } catch (Exception e) {
            System.out.println("error al buscar usuario por dni " + e);
        }
        return null;
    }

   
  

   

}
