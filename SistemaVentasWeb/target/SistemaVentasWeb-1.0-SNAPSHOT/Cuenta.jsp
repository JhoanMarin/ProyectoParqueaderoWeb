<%-- 
    Document   : Cuenta
    Created on : 28/03/2024, 3:39:10 p. m.
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    </head>
    <body>
                      <div class="card-body">
                    <form action="Controlador?menu=Cuenta" Method="POST" onsubmit="return validarFormulario()" >
                        
                        <div class="form-group">
                        
                            <label>Primer Nombre</label>
                            <input type="text" value="${clientelogueado.primerNombre}" name="txtname1" class="form-control">
                        </div>
                        
                       
                         <br>
                          <br>
        
                        <div class="form-group">
                            <label>Segundo Nombre</label>
                            <input type="text" value="${clientelogueado.segundoNombre}" name="txtname2" class="form-control" >
                        </div>
                         <br>
                         <br>
                        <div class="form-group">
                            <label>Primer Apellido</label>
                            <input type="text" value="${clientelogueado.primerApellido}" name="txtsurname1" class="form-control">

                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label>Segundo Apellido</label>
                            <input type="text" value="${clientelogueado.segundoApellido}" name="txtsurname2" class="form-control">
                        </div>
                        
                        <br>
                        <br>
                        
                        <div class="form-group">
                            <label>Tipo Documento</label>
                            <input type="text" value="${clientelogueado.tipoDocumento}" name="txttipodocu" class="form-control" readonly>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label>Número identificación</label>
                            <input type="number" value="${clientelogueado.numeroidentificacion}" name="txtidentification" class="form-control" readonly>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label>Correo Eléctronico</label>
                            <input type="email" value="${clientelogueado.correoElectronico}" name="txtemail" class="form-control" >
                        </div>
                         <br>
                         <div class="form-group">
                            <label>Celular</label>
                            <input type="number" value="${clientelogueado.celular}" name="txtnumber" class="form-control" >
                        </div>
                        
                        
                        <br>
                        
                        <br>
                         <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${clientelogueado.contraseña}" name="txtpassword" class="form-control">
                        </div>
                        
                        
                        <br>
                        
                        
                        <input type="submit" name="accion" value="Modificar" class="btn btn-info">
                        
                     </form>

                </div>  

            </div>
     <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
       
            
<script>
    function validarFormulario() {
        // Obtener los valores de los campos
        var primerNombre = document.getElementsByName("txtname1")[0].value;
        var segundoNombre = document.getElementsByName("txtname2")[0].value;
        var primerApellido = document.getElementsByName("txtsurname1")[0].value;
        var segundoApellido = document.getElementsByName("txtsurname2")[0].value;
        var correoElectronico = document.getElementsByName("txtemail")[0].value;
        var celular = document.getElementsByName("txtnumber")[0].value;
        var contraseña = document.getElementsByName("txtpassword")[0].value;

        // Validar que los campos no estén vacíos
        if (primerNombre.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Primer Nombre es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (segundoNombre.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Segundo Nombre es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (primerApellido.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Primer Apellido es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (segundoApellido.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Segundo Apellido es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (correoElectronico.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Correo Electrónico es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (celular.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Celular es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        if (contraseña.trim() === '') {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'El campo Contraseña es obligatorio'
            });
            return false; // Detener el envío del formulario
        }
        
        // Confirmar antes de enviar el formulario
        Swal.fire({
            icon: 'question',
            title: '¿Está seguro/a de modificar sus datos personales?',
            showCancelButton: true,
            confirmButtonText: 'Sí',
            cancelButtonText: 'No'
        }).then((result) => {
            if (result.isConfirmed) {
                // Si el usuario confirma, establecer la acción del formulario y enviarlo
                document.forms[0].setAttribute('action', 'Controlador?menu=Cuenta&accion=Modificar');
                document.forms[0].submit();

                // Alerta de modificación exitosa
Swal.fire({
    icon: 'success',
    title: 'Modificación exitosa',
    text: 'La modificación se realizó con éxito.',
    willClose: () => {
        window.location.href = 'Controlador?menu=Cuenta&accion=Cargar'; // Reemplaza 'URL_DESTINO' con la URL a la que deseas redirigir al usuario
    }
});
            }
        });

        // Detener el envío del formulario de manera predeterminada
        return false;
    }
</script>


<script>
    <% Boolean modificacionExitosa = (Boolean) request.getSession().getAttribute("modificacionExitosa"); %>
    <% if (modificacionExitosa != null && modificacionExitosa) { %>
        Swal.fire({
            icon: 'success',
            title: 'Modificación exitosa',
            text: 'La modificación se realizó con éxito.'
        });
    <% request.getSession().removeAttribute("modificacionExitosa"); %>
    <% } %>
</script>




    </body>
</html>

