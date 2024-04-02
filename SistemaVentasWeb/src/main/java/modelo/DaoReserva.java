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
public class DaoReserva extends Conexion {
    
    public boolean registrar(Reserva reserva) {
        
          PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="INSERT INTO Reserva (fechaAReservar,HoraAReservar,Estado,idVehiculo,idCubiculo,Fecha_Hora_Checkout)"
                + "VALUES (?,?,1,?,?,NULL)";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, reserva.getFechaAReservar());
            ps.setString(2, reserva.getHoraAReservar());
            ps.setInt(3, reserva.getIdVehiculo());
            ps.setInt(4, reserva.getIdCubiculo());
            ps.execute();
            
            return true;
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(), "Error de inserción" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        } finally{
            try{
                con.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "No se puede cerrar la conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public List<Reserva> listarReservasPorCliente(int idCliente) {
        List<Reserva> reservas = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conexion.getConexion();
            String sql = "SELECT r.idReserva, r.fechaAReservar, r.HoraAReservar, r.FechaRealizacionReserva, v.marca AS Vehiculo, cu.nomenclaturaUbicación AS CubiculoAsignado,r.idCubiculo " +
                         "FROM Cliente c " +
                         "INNER JOIN Vehiculo v ON c.idCliente = v.idCliente " +
                         "INNER JOIN Reserva r ON v.idVehiculo = r.idVehiculo " +
                         "INNER JOIN cubiculo cu ON cu.idCubiculo = r.idCubiculo " +
                         "WHERE c.idCliente = ? AND Estado = 1";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                // Asigna los valores de la reserva
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setFechaAReservar(rs.getString("fechaAReservar"));
                reserva.setHoraAReservar(rs.getString("HoraAReservar"));
                reserva.setFechaRealizacionReserva(rs.getString("FechaRealizacionReserva"));
                reserva.setVehiculo(rs.getString("Vehiculo"));
                reserva.setCubiculo(rs.getString("CubiculoAsignado"));
                reserva.setIdCubiculo(rs.getInt("idCubiculo"));
                // Agrega la reserva al ArrayList
                reservas.add(reserva);
            }

            // Cierra las conexiones
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservas;
    }

    
        public boolean inhabilitarReserva(Reserva reserva) {
           PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
       String sql = "UPDATE Reserva SET Estado=0 "
            + "WHERE idReserva=?";
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setInt(1, reserva.getIdReserva());
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
    
    
}
