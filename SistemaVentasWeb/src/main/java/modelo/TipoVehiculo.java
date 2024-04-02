/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class TipoVehiculo {
    
     private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String descripcion;
    private int idadmin;
    private int estadoTipoVehiculo;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int idTipoVehiculo, String nombreTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }
    

    public TipoVehiculo(int idTipoVehiculo, String nombreTipoVehiculo, String descripcion, int idadmin, int estadoTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.descripcion = descripcion;
        this.idadmin = idadmin;
        this.estadoTipoVehiculo = estadoTipoVehiculo;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getEstadoTipoVehiculo() {
        return estadoTipoVehiculo;
    }

    public void setEstadoTipoVehiculo(int estadoTipoVehiculo) {
        this.estadoTipoVehiculo = estadoTipoVehiculo;
    }
    
    public String toString(){
        return idTipoVehiculo +"- " +nombreTipoVehiculo;
    }
    
}
