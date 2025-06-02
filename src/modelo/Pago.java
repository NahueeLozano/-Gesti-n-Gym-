/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author nahuel lozano
 */
public class Pago {
    private int idPago;
    private double monto;
    private String estado;
    private Date fecha_pago;
    private Usuario usuario; 
    private Membresia Membresia;

    public Pago() {
    }

    public Pago(int idPago) {
        this.idPago = idPago;
    }
    
    public Pago (int idPago, Usuario usuario, String estado, Date fecha_pago){
        this.idPago = idPago;
        this.estado = estado;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
        this.usuario = usuario;
        
    }
    

    public Pago(Usuario usuario, Membresia membresia ) {
        this.usuario = usuario;
        this.Membresia = membresia;
    }

    public Pago(double monto, String estado, Date fecha_pago, Usuario usuario, Membresia Membresia) {
        this.monto = monto;
        this.estado = estado;
        this.fecha_pago = fecha_pago;
        this.usuario = usuario;
        this.Membresia = Membresia;
    }

    
   
    public Pago(int idPago, double monto, String estado, Date fecha_pago, Usuario usuario, Membresia Membresia) {
        this.idPago = idPago;
        this.monto = monto;
        this.estado = estado;
        this.fecha_pago = fecha_pago;
        this.usuario = usuario;
        this.Membresia = Membresia;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Membresia getMembresia() {
        return Membresia;
    }

    public void setMembresia(Membresia Membresia) {
        this.Membresia = Membresia;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", monto=" + monto + ", estado=" + estado + ", fecha_pago=" + fecha_pago + ", usuario=" + usuario + ", Membresia=" + Membresia + '}';
    }
    
            
    
   
    
    
}
