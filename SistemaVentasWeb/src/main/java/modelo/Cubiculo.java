/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Cubiculo {
    
     private int idcubiculo;
    private String tamaño;
    private double precioHora;
    private String nomenclaturaUbicacion;
    private int idTipoVehiculo;
    private int disponibilidad;
    private int estadoCubiculo;

    public Cubiculo() {
    }

    public Cubiculo(String tamaño, float precioHora, String nomenclaturaUbicacion, int disponibilidad) {
        this.tamaño = tamaño;
        this.precioHora = precioHora;
        this.nomenclaturaUbicacion = nomenclaturaUbicacion;
        this.disponibilidad = disponibilidad;
    }

   

    public int getIdcubiculo() {
        return idcubiculo;
    }

    public void setIdcubiculo(int idcubiculo) {
        this.idcubiculo = idcubiculo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public String getNomenclaturaUbicacion() {
        return nomenclaturaUbicacion;
    }

    public void setNomenclaturaUbicacion(String nomenclaturaUbicacion) {
        this.nomenclaturaUbicacion = nomenclaturaUbicacion;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getEstadoCubiculo() {
        return estadoCubiculo;
    }

    public void setEstadoCubiculo(int estadoCubiculo) {
        this.estadoCubiculo = estadoCubiculo;
    }

    
}
