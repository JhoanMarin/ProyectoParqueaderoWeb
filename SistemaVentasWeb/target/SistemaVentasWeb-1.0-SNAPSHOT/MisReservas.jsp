<%-- 
    Document   : MisReservas
    Created on : 1/04/2024, 5:28:01 p. m.
    Author     : jhoan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Reserva"%>
<%@page import="modelo.DaoReserva"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <br>
    <h1 class="h3 text-center fw-bold text-white py-3" style="background: linear-gradient(to right, #0077ff, #00ccff); margin-top: -13.75px;">Mis Reservas Activas</h1>

    <br>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>id Reserva</th>
                <th>Fecha Reservada</th>
                <th>Hora Reservada</th>
                <th>Realización Reserva</th>
                <th>Vehículo</th>
                <th>Cubículo Seleccionado</th>
                <th>id Cubículo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Reserva> misreservas = (List<Reserva>) request.getAttribute("misReservas");
                if (misreservas != null && !misreservas.isEmpty()) {
                    for (Reserva reserva : misreservas) {
            %>
            <tr>
                <td><%= reserva.getIdReserva() %></td>
                <td><%= reserva.getFechaAReservar() %></td>
                <td><%= reserva.getHoraAReservar() %></td>
                <td><%= reserva.getFechaRealizacionReserva() %></td>
                <td><%= reserva.getVehiculo() %></td>
                <td><%= reserva.getCubiculo() %></td>
                <td><%= reserva.getIdCubiculo() %></td>

                <td>
                    <div class="btn-group">
                        <a class="btn btn-warning btn-sm mr-2" href="Controlador?menu=MisReservas&accion=Eliminar&id=<%= reserva.getIdReserva()%>&idcubiculo=<%= reserva.getIdCubiculo()%>" onclick="return confirm('¿Está seguro de eliminar la reserva? Esta acción no se puede deshacer.')">Eliminar</a>
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

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>



