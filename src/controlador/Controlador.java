/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import modelo.PagoDAO;
import modelo.UsuarioDAO;
import vista.Menu;


public class Controlador {
   
    private Menu menu;
   
    private UsuarioDAO usuarioDAO;
   
    private PagoDAO pagoDAO;
    
    //  recibe la vista y los modelos
    public Controlador(Menu menu, UsuarioDAO usuarioDAO, PagoDAO pagoDAO){
        this.menu = menu;
        this.usuarioDAO = usuarioDAO;
        this.pagoDAO = pagoDAO;
    }
    //  solo para gestión de usuarios
    public Controlador(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }

}
