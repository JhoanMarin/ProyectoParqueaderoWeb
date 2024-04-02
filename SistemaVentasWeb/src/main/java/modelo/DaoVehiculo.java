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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhoan
 */
public class DaoVehiculo extends Conexion {
    
    
    public List<Vehiculo> listarVehiculo(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = (Connection) getConexion();

        List<Vehiculo> lista = new ArrayList<>();

        try {

            String sql = "SELECT idVehiculo, placa, marca, modelo, descripcion, idTipoVehiculo, EstadoVehiculo FROM vehiculo WHERE idCliente=? and EstadoVehiculo=1";

            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();

            while (rs.next()) {
                int idvehiculo = rs.getInt("idVehiculo");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                int idTipovehiculo = rs.getInt("idTipoVehiculo");
                int EstadoVehiculo = rs.getInt("EstadoVehiculo");

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setId(idvehiculo);
                vehiculo.setPlaca(placa);
                vehiculo.setMarca(marca);
                vehiculo.setModelo(modelo);
                vehiculo.setDescripción(descripcion);
                vehiculo.setTipo(idTipovehiculo);
                vehiculo.setEstado(EstadoVehiculo);

                lista.add(vehiculo);
            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar");
            return null;
        }

    }
    
    
    
    
    
    
    public List<Vehiculo> listarVehiculoId(Vehiculo vehicu) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = (Connection) getConexion();

        List<Vehiculo> lista = new ArrayList<>();

        try {

            String sql = "SELECT idVehiculo, placa, marca, modelo, descripcion, idTipoVehiculo, EstadoVehiculo FROM vehiculo WHERE idVehiculo=? and EstadoVehiculo=1";

            ps = con.prepareStatement(sql);
            ps.setInt(1, vehicu.getId());
            rs = ps.executeQuery();

            while (rs.next()) {
                int idvehiculo = rs.getInt("idVehiculo");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                int idTipovehiculo = rs.getInt("idTipoVehiculo");
                int EstadoVehiculo = rs.getInt("EstadoVehiculo");

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setId(idvehiculo);
                vehiculo.setPlaca(placa);
                vehiculo.setMarca(marca);
                vehiculo.setModelo(modelo);
                vehiculo.setDescripción(descripcion);
                vehiculo.setTipo(idTipovehiculo);
                vehiculo.setEstado(EstadoVehiculo);

                lista.add(vehiculo);
            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar");
            return null;
        }

    }
        
        
        
    public Vehiculo obtenerVehiculoPorId(Vehiculo vehiculo) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = (Connection) getConexion();

        try {
            String sql = "SELECT idVehiculo, placa, marca, modelo, descripcion, idTipoVehiculo, EstadoVehiculo FROM vehiculo WHERE idVehiculo=? and EstadoVehiculo=1";

            ps = con.prepareStatement(sql);
            ps.setInt(1, vehiculo.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                int idvehiculo = rs.getInt("idVehiculo");
                String placa = rs.getString("placa");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                int idTipoVehiculo = rs.getInt("idTipoVehiculo");
                int EstadoVehiculo = rs.getInt("EstadoVehiculo");

                Vehiculo vehiculoEncontrado = new Vehiculo();

                vehiculoEncontrado.setId(idvehiculo);
                vehiculoEncontrado.setPlaca(placa);
                vehiculoEncontrado.setMarca(marca);
                vehiculoEncontrado.setModelo(modelo);
                vehiculoEncontrado.setDescripción(descripcion);
                vehiculoEncontrado.setTipo(idTipoVehiculo);
                vehiculoEncontrado.setEstado(EstadoVehiculo);

                return vehiculoEncontrado;
            } else {
                return null; // No se encontró ningún vehículo con el ID especificado
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener vehículo por ID");
            return null;
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            // Esto es importante para liberar recursos y evitar posibles fugas de memoria

        }
    }

    
    public boolean registrar(Vehiculo vehiculo){
        
       
        PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="INSERT INTO Vehiculo (placa,marca,modelo,descripcion,idCliente,idTipoVehiculo,EstadoVehiculo)"
                + "VALUES (?,?,?,?,?,?,1)";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getDescripción());
            ps.setInt(5,vehiculo.getMipropietario());
            ps.setInt(6, vehiculo.getTipo());

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

   
    public boolean buscar(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public boolean modificar(Vehiculo vehiculo) {
        
                PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
        String sql="UPDATE Vehiculo SET placa=?, marca=?, modelo=?, descripcion=? "
                + "WHERE idVehiculo=? ";
        
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getDescripción());
            ps.setInt(5, vehiculo.getId());

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

    public boolean inhabilitar(Vehiculo vehiculo) {
           PreparedStatement ps=null;
        Connection con= (Connection) getConexion();
        
       String sql = "UPDATE Vehiculo SET EstadoVehiculo=0 "
            + "WHERE idVehiculo=?";
        try{
            
         
            ps= con.prepareStatement(sql);
            ps.setInt(1, vehiculo.getId());
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
