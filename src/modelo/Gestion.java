/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author nahuel lozano
 */
//clase abtracta 
 abstract class  Gestion <T> {
   
     // metodo abtrascato y polimorfismo 
    public abstract List <T> obtenerTodo();
    
    
    
}
