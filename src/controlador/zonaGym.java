/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.UsuarioDAO;
import modelo.Conexion;
import modelo.PagoDAO;
import vista.Menu;
import java.sql.Connection;
/**
 *
 * @author nahuel lozano
 */
public class zonaGym {

    public static void main (String []args){
        // Establece la conexión a la base de datos
        Connection cone = Conexion.getConnexion();
        // MODELO: Instancia los objetos de acceso a datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PagoDAO pagoDAO = new PagoDAO (cone);
        // VISTA: Crea la ventana principal del menú
        Menu vistaMenu = new Menu();
        // CONTROLADOR: Une la vista y el modelo (no es necesario usar la variable)
        new Controlador(vistaMenu,usuarioDAO,pagoDAO);
        // Muestra la interfaz gráfica al usuario
        vistaMenu.setVisible(true);
    }
    
}
