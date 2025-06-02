/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Usuario {
      private int idUsuario;
      private String nombre;
      private String apellido;
      private int dni;
      private String email;
      private String nombreUsuario;
      private String contraseña;
    
    // contructor basio 
    public Usuario(){
        
    }
    
    //contructor para buscar por nombre
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    
      //contructor para buscar por Dni
    

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
   

    public Usuario(int idUsuario, String nombre, String apellido, int dni, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }
//CONSTRUCTOR PARA MODIFICAR
    
    public Usuario(String nombre, String apellido, int dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }
    
    
    //contrsctor OBTEBNER TODO
    public Usuario( String nombre, String apellido,int dni, String email,String nombreUsuario){
     
        this.nombre= nombre;
        this.apellido= apellido;
        this.dni = dni;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
              
    }

    //constructor para mostrar EL DE PAGO
    public Usuario(int idUsuario, String nombre, String apellido, int dni, String email, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
    }
    
    
    //contructor para guardar usuario
    public Usuario( String nombre, String apellido,int dni, String email, String nombreUsuario,String contraseña){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", nombreUsuario=" + nombreUsuario +'}';
    }
    
   
         
    
}
