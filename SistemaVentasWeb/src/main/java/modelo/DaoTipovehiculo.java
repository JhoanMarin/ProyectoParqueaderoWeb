/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jhoan
 */
public class DaoTipovehiculo extends Conexion {
    
    
    
    public String obtenerTipoVehiculo(){
        String elementos="";
        
        try{
            
        Connection con = getConexion();
        String sql = "SELECT * FROM tipovehiculo WHERE EstadoTipoVehiculo = 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            int id= rs.getInt("idTipoVehiculo");
            String nombre=rs.getString("Nombre");
            elementos+=  "<option value='"+id+"'>"+nombre+"</option>";
        }
        
            
            con.close();
        }catch(Exception e){
            
        }
        return elementos;
        
    }
    
    
    
    
    
}
