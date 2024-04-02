<%-- 
    Document   : Reserva
    Created on : 28/03/2024, 3:38:39 p. m.
    Author     : jhoan
--%>

<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="modelo.Vehiculo"%>
<%@page import="modelo.DaoTipovehiculo"%>
<%@page import="modelo.Cubiculo"%>
<%@page import="modelo.DaoCubiculo"%>
<%@ page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<style>
  body {
    background-color: #ffffff; /* Fondo blanco */
    color: #000000; /* Texto negro */
    font-family: Arial, sans-serif;
  }

  label {
    font-size: 1.2em;
    color: #64ffda; /* Azul neón */
    
  }

  input[type="date"] {
    border: 2px solid #64ffda; /* Azul neón */
    background-color: #0a192f; /* Azul oscuro */
    color: #64ffda; /* Azul neón */
    padding: 8px;
    font-size: 1em;
    border-radius: 5px;
    width: 200px;
  }

  input[type="date"]::placeholder {
    color: #64ffda; /* Azul neón */
  }

  input[type="date"]::-webkit-calendar-picker-indicator {
    filter: invert(100%);
  }
</style>






     <style>
    body {
      
       background-color: #ffffff; /* Fondo blanco */
      color: #000000; /* Texto negro */
      font-family: Arial, sans-serif;
    }
    
    label {
      font-size: 1.2em;
    }
    
    input[type="time"] {
      border: 2px solid #64ffda; /* Azul neón */
      background-color: #0a192f; /* Azul oscuro */
      color: #64ffda; /* Azul neón */
      padding: 8px;
      font-size: 1em;
      border-radius: 5px;
      width: 200px;
    }
    
    input[type="time"]::placeholder {
      color: #64ffda; /* Azul neón */
    }
    
    input[type="time"]::-webkit-calendar-picker-indicator {
      filter: invert(100%);
    }
  </style>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #ffffff; /* Fondo blanco */
            color: #000000; /* Texto negro */
            font-family: Arial, sans-serif;
        }
        label {
            font-size: 1.2em;
        }
        input[type="date"] {
            border: 2px solid #64ffda; /* Azul neón */
            background-color: #0a192f; /* Azul oscuro */
            color: #64ffda; /* Azul neón */
            padding: 8px;
            font-size: 1em;
            border-radius: 5px;
            width: 200px;
        }
        input[type="date"]::placeholder {
            color: #64ffda; /* Azul neón */
        }
        input[type="date"]::-webkit-calendar-picker-indicator {
            filter: invert(100%);
        }
        input[type="time"] {
            border: 2px solid #64ffda; /* Azul neón */
            background-color: #0a192f; /* Azul oscuro */
            color: #64ffda; /* Azul neón */
            padding: 8px;
            font-size: 1em;
            border-radius: 5px;
            width: 200px;
        }
        input[type="time"]::placeholder {
            color: #64ffda; /* Azul neón */
        }
        input[type="time"]::-webkit-calendar-picker-indicator {
            filter: invert(100%);
        }
    </style>
</head>
<body>

<h1>Reservas</h1>
<div class="d-flex">
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
                    <a class="btn btn-warning btn-sm mr-2" href="Controlador?menu=Reserva&accion=Disponibilidad&id=<%= vehiculo.getTipo()%>&idvehi=<%= vehiculo.getId()%>">Disponibilidad</a>
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

    <div class="col-sm-8">
        <br>
        <form action="Controlador?menu=Reserva&accion=Reservar" method="post">
            <label for="fecha" style="color: #000000;">Fecha Actual:</label>
            <input type="date" id="fecha" name="txtfecha" value="<%= LocalDate.now().toString()%>" min="<%= LocalDate.now().toString()%>" max="<%= LocalDate.now().toString()%>" style="background-color: #000; color: #00FFFF; border: 1px solid #00FFFF;">
            <br>
            <br>
            <label for="hora" style="color: #000000;">Selecciona la hora:</label>
            <input type="time" id="hora" name="txthora" placeholder="HH:MM" required>
            <br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>id Cubiculo</th>
                    <th>tamaño</th>
                    <th>precioHora</th>
                    <th>nomenclaturaUbicación</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Cubiculo> cubiculos = (List<Cubiculo>) request.getAttribute("cubiculos");
                    if (cubiculos != null && !cubiculos.isEmpty()) {
                        for (Cubiculo cubiculo : cubiculos) {
                %>
                <tr>
                    <td><%= cubiculo.getIdcubiculo()%></td>
                    <td><%= cubiculo.getTamaño()%></td>
                    <td><%= cubiculo.getPrecioHora()%></td>
                    <td><%= cubiculo.getNomenclaturaUbicacion()%></td>
                    <td>
                        <!-- Campos ocultos para enviar el ID del cubículo -->
                        <input type="hidden" name="id" value="<%= cubiculo.getIdcubiculo()%>">
                        <!-- Aquí van los campos de fecha y hora -->
                        <button type="submit" class="btn btn-warning btn-sm mr-2">Reservar</button>
                        
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">Selecciona un vehiculo, se desplegarán los cubiculo optimos <br>para tu vehiculo, después desliza a la derecha para reservar <br>el cubiculo que deses</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>