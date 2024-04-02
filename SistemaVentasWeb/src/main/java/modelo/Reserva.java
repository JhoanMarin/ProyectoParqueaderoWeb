/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Reserva {
    
     private int idReserva;
    private String fechaAReservar;
    private String horaAReservar;
    private String fechaRealizacionReserva;
    private int estadoReserva;
    private int idVehiculo;
    private int idCubiculo;
    private String fechaCheckin;
    private String frechaCheckOut;
    private String vehiculo;
    private String cubiculo;

    public Reserva() {
    }

    public Reserva(int idReserva, String fechaAReservar, String horaAReservar, String fechaRealizacionReserva, int estadoReserva, int idVehiculo, int idCubiculo, String fechaCheckin, String frechaCheckOut) {
        this.idReserva = idReserva;
        this.fechaAReservar = fechaAReservar;
        this.horaAReservar = horaAReservar;
        this.fechaRealizacionReserva = fechaRealizacionReserva;
        this.estadoReserva = estadoReserva;
        this.idVehiculo = idVehiculo;
        this.idCubiculo = idCubiculo;
        this.fechaCheckin = fechaCheckin;
        this.frechaCheckOut = frechaCheckOut;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaAReservar() {
        return fechaAReservar;
    }

    public void setFechaAReservar(String fechaAReservar) {
        this.fechaAReservar = fechaAReservar;
    }

    public String getHoraAReservar() {
        return horaAReservar;
    }

    public void setHoraAReservar(String horaAReservar) {
        this.horaAReservar = horaAReservar;
    }

    public String getFechaRealizacionReserva() {
        return fechaRealizacionReserva;
    }

    public void setFechaRealizacionReserva(String fechaRealizacionReserva) {
        this.fechaRealizacionReserva = fechaRealizacionReserva;
    }

    public int getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(int estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdCubiculo() {
        return idCubiculo;
    }

    public void setIdCubiculo(int idCubiculo) {
        this.idCubiculo = idCubiculo;
    }

    public String getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(String fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public String getFrechaCheckOut() {
        return frechaCheckOut;
    }

    public void setFrechaCheckOut(String frechaCheckOut) {
        this.frechaCheckOut = frechaCheckOut;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }
    
    
    
}
