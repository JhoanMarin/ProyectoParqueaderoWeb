<%-- 
    Document   : Vehiculo
    Created on : 28/03/2024, 3:38:18 p. m.
    Author     : jhoan
--%>


<%@page import="modelo.Vehiculo"%>
<%@page import="modelo.DaoTipovehiculo"%>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    
    </head>
    <body>
        
        <style>
  .btn-group {
  display: flex;
  justify-content-end;
}
</style>

        <h1>Gestionar Vehiculos</h1>
        <div class="d-flex">



            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador?menu=Vehiculo" Method="POST">
                        <div class="form-group">
                        
                            <label>Número Placa</label>
                            <input type="text" value="${vehicul.getPlaca()}" name="txtplaca" class="form-control">
                        </div>
                        
                        
        
                        <div class="form-group">
                            <label>Marca</label>
                            <input type="text" value="${vehicul.getMarca()}" name="txtmarca" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Modelo</label>
                            <input type="text" value="${vehicul.getModelo()}" name="txtmodelo" class="form-control">

                        </div>
                        <br>
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" value="${vehicul.getDescripción()}" name="txtdescripcion" class="form-control">
                        </div>
                        <br>
                        <select class="form-select" name="tipoVehiculo" aria-label="Default select example">
                            <option selected>Seleccione tipo de vehehículo</option>
                            <%
                            DaoTipovehiculo tipo= new DaoTipovehiculo();
                            out.println(tipo.obtenerTipoVehiculo());
                            
                            %>
                            
                        </select>
                        
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                     </form>

                </div>  

            </div>
            
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>id Vehiculo</th>
                            <th>Placa</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Descripción</th>
                            <th>idTipoVehiculo</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Vehiculo> vehiculos = (List<Vehiculo>) request.getAttribute("vehiculos");
                            if (vehiculos != null && !vehiculos.isEmpty()) {
                                for (Vehiculo vehiculo : vehiculos) {
                        %>
                        <tr>
                            <td><%= vehiculo.getId()%></td>
                            <td><%= vehiculo.getPlaca()%></td>
                            <td><%= vehiculo.getMarca()%></td>
                            <td><%= vehiculo.getModelo()%></td>
                            <td><%= vehiculo.getDescripción()%></td>
                            <td><%= vehiculo.getTipo()%></td>
                            <td><%= vehiculo.getEstado()%></td>
                            <td>

                                <div class="btn-group">
                                    <a class="btn btn-warning btn-sm mr-2" href="Controlador?menu=Vehiculo&accion=Editar&id=<%= vehiculo.getId()%>">Editar</a>
                                    <a class="btn btn-danger btn-sm" href="Controlador?menu=Vehiculo&accion=Eliminar&id=<%= vehiculo.getId()%>">Eliminar</a>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="8">No hay vehículos disponibles</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>


            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
