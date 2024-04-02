<%-- 
    Document   : Principal
    Created on : 14/03/2024, 6:25:08 p. m.
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <title>JSP Page</title>
  <style>
    .navbar-nav {
      /* Move items to the left */
      justify-content: flex-start;
    }
    .dropdown {
      /* Move dropdown to the right */
      margin-left: auto;
    }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Features</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Pricing</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" aria-disabled="true">Disabled</a>
          </li>
        </ul>
        <div class="dropdown">
          <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown button
          </button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>

--%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Bienvenidos a Aparcarte</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="Css/style.css" rel="stylesheet" type="text/css"/>
  <style>
    /* Add positioning styles for the navbar */
    nav {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      margin-top: 0px;
      padding: 10px 30px;
      /* Adjust background color or transparency as needed */
      background-color: rgba(0, 0, 0, 0.8);  /* Semi-transparent black */
    }
  </style>
</head>
<body>
    
     <%
    Boolean sesionIniciada = (Boolean) session.getAttribute("sesionIniciada");
    if (sesionIniciada != null && sesionIniciada) {
    %>
    
     <div class="m-4" style="height: 550px; width: 100%;">
                <iframe name="myFrame" style="height: 100%; width: 100%; border:none" src="Home.jsp"></iframe>
            </div>
    
    <%
    } else {
        // Aquí podrías mostrar un mensaje o redirigir al usuario a iniciar sesión
    }
    %>
    
    
    
  <nav class="d-flex justify-content-start">  <a href="Controlador?menu=Home" target="myFrame">Home <span></span></a>
    <a href="Controlador?menu=Vehiculo&accion=Listar" target="myFrame">Mis Vehículos <span></span></a>
    <a href="Controlador?menu=Reserva&accion=Listar" target="myFrame">Reservas <span></span></a>
    <a href="Controlador?menu=MisReservas&accion=Listar" target="myFrame">Mis Reservas <span></span></a>
    <a href="Controlador?menu=Historial" target="myFrame">Historial <span></span></a>
    <a href="Controlador?menu=Cuenta&accion=Cargar" target="myFrame">Cuenta <span></span></a>
    
    <div class="dropdown ms-auto">  <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
        ${usuario.getPrimerNombre()} ${usuario.getSegundoNombre()}
      </button>
        <ul class="dropdown-menu dropdown-menu-start text-center">  <li><a class="dropdown-item" href="#">
                    <img src="img/avatar.png" alt="60" width="60"/>
                </a></li>
            <li><a class="dropdown-item" href="#">Cliente Aparcarte</a></li>
            <li><a class="dropdown-item" href="#">${usuario.getCorreoElectronico()}</a></li>
            <div class="dropdown-divider"></div>
            <form action="Validar" method="POST">
                <li><button name="accion" value="salir" class="dropdown-item" href="">Cerrar Sesión</button></li>
            </form>
            
        </ul>
    </div>
  </nav>
            <%-- 
            <div class="m-4" style="height: 550px; width: 100%;">
                <iframe name="myFrame" style="height: 100%; width: 100%; border:none"></iframe>
            </div>
  --%>
  
  
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>


