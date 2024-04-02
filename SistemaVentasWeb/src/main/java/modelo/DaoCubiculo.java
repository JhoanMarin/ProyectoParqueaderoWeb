/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jhoan
 */
public class DaoCubiculo extends Conexion {
    
    public List<Cubiculo> CargarTablaDisponibilidadCubiculo(int tipoVehiculo) {
        List<Cubiculo> lista = new ArrayList<>();
    try {
        Connection con = getConexion();
        String sql = "SELECT  idCubiculo,tamaño, precioHora, nomenclaturaUbicación FROM Cubiculo where idTipoVehiculo=? and Disponibilidad=1 AND EstadoCubiculo=1 ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, tipoVehiculo);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
                int idCubiculo = rs.getInt("idCubiculo");
                String tamanio = rs.getString("tamaño");
                Double preciohora = rs.getDouble("precioHora");
                String nomenclaturaUbicación = rs.getString("nomenclaturaUbicación");
                

                Cubiculo cubiculo = new Cubiculo();

                cubiculo.setIdcubiculo(idCubiculo);
                cubiculo.setTamaño(tamanio);
                cubiculo.setPrecioHora(preciohora);
                cubiculo.setNomenclaturaUbicacion(nomenclaturaUbicación);
                

                lista.add(cubiculo);
            }
        
        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}
    
    public boolean modificarCubiculoPorReserva(Cubiculo cubiculo) {
         PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="UPDATE Cubiculo SET Disponibilidad=0 "
                + "WHERE idCubiculo=? ";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setInt(1, cubiculo.getIdcubiculo());
            ps.execute();
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Error de actualización" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            try{
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }    
    
    public boolean CambiarDisponibilidad(Cubiculo cubiculo) {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();

        String sql = "UPDATE Cubiculo SET Disponibilidad=1 "
                + "WHERE idCubiculo=?";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, cubiculo.getIdcubiculo());
            ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de actualización" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
