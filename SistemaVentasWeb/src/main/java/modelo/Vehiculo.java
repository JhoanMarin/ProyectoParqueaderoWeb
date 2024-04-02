/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Vehiculo {
    
       private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String descripción;
    private int estado;
    public int mipropietario;
    public int tipo;
    

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String marca, String modelo, String descripción, int estado, int mipropietario, int tipo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.descripción = descripción;
        this.estado = estado;
        this.mipropietario = mipropietario;
        this.tipo = tipo;
    }

   



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMipropietario() {
        return mipropietario;
    }

    public void setMipropietario(int mipropietario) {
        this.mipropietario = mipropietario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
    

   
    

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", descripci\u00f3n=" + descripción + ", estado=" + estado + ", mipropietario=" + mipropietario + '}';
    }
    
    
    
}
