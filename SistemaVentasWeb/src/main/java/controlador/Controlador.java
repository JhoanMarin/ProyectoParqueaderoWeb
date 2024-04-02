/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Cubiculo;
import modelo.DaoCliente;
import modelo.DaoCubiculo;
import modelo.DaoReserva;
import modelo.DaoVehiculo;
import modelo.Reserva;
import modelo.Vehiculo;


public class Controlador extends HttpServlet {

    DaoVehiculo daovehiculo=  new  DaoVehiculo();
    DaoCubiculo daocubiculo= new DaoCubiculo();
    DaoCliente daocliente= new DaoCliente();
    DaoReserva daoreserva= new DaoReserva();
    
    Reserva reserva= new Reserva();
    Cubiculo cubiculo= new Cubiculo();
    Cliente cliente= new Cliente();
    Vehiculo vehi= new Vehiculo ();
    Cliente cliente2= new Cliente();
    int idvehiculo;
    int idV;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        
         if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
        
            }
         
         
         if(menu.equals("Home")){
                request.getRequestDispatcher("Home.jsp").forward(request, response);
        
            }
        
        
         if(menu.equals("Vehiculo")){
                
               
          switch (accion){
            
              case "Listar":

                  HttpSession session = request.getSession();

                  // Obtener el ID del cliente de la sesión
                  int clienteId = (int) session.getAttribute("clienteId");

                  // Establecer el ID del cliente en el objeto cliente
                  cliente.setId(clienteId);
                  List lista = daovehiculo.listarVehiculo(cliente);
                  request.setAttribute("vehiculos", lista);
                  JOptionPane.showMessageDialog(null, lista.size());
                 
                  
                  
                  break;
                
                
            case "Agregar":
                
                 String placa1=request.getParameter("txtplaca");
                 String marca1=request.getParameter("txtmarca");
                 String modelo1=request.getParameter("txtmodelo");
                 String descrip1=request.getParameter("txtdescripcion");
                 int idTipoVehiculo = Integer.parseInt(request.getParameter("tipoVehiculo"));
                  HttpSession session1 = request.getSession();

                  // Obtener el ID del cliente de la sesión
                  int clienteId1 = (int) session1.getAttribute("clienteId");
                 vehi.setPlaca(placa1);
                 vehi.setMarca(marca1);
                 vehi.setModelo(modelo1);
                 vehi.setDescripción(descrip1);
                 vehi.setTipo(idTipoVehiculo);
                 vehi.setMipropietario(clienteId1);
                 daovehiculo.registrar(vehi);
                 request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
           
                break;
              
            case "Editar":
                idvehiculo=Integer.parseInt(request.getParameter("id"));
                vehi.setId(idvehiculo);
                Vehiculo vehiculo = daovehiculo.obtenerVehiculoPorId(vehi);
//                JOptionPane.showMessageDialog(null, vehiculo.size());
                request.setAttribute("vehicul", vehiculo);
                request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                
                break;
                
                
             case "Actualizar":
                 String placa=request.getParameter("txtplaca");
                 String marca=request.getParameter("txtmarca");
                 String modelo=request.getParameter("txtmodelo");
                 String descrip=request.getParameter("txtdescripcion");
                 Vehiculo v= new Vehiculo();
                 v.setId(idvehiculo);
                 v.setPlaca(placa);
                 v.setMarca(marca);
                 v.setModelo(modelo);
                 v.setDescripción(descrip);
                 daovehiculo.modificar(v);
                 request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                break;
                
            case "Eliminar":
                idvehiculo=Integer.parseInt(request.getParameter("id"));
                vehi.setId(idvehiculo);
                daovehiculo.inhabilitar(vehi);
                request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
          
            
           request.getRequestDispatcher("Vehiculo.jsp").forward(request, response);
          
            }
         
         
        
           if (menu.equals("Reserva")) {
          

            switch (accion) {

                case "Listar":
                 
                  
                    
                    

                  HttpSession session = request.getSession();

                  // Obtener el ID del cliente de la sesión
                  int clienteId = (int) session.getAttribute("clienteId");

                  // Establecer el ID del cliente en el objeto cliente
                  cliente.setId(clienteId);
                  List lista = daovehiculo.listarVehiculo(cliente);
                  request.setAttribute("vehiculos", lista);
                
                  JOptionPane.showMessageDialog(null, lista.size());
                 
                  
                  
                  break;
                  
                  
                case "Disponibilidad":
                    idV=Integer.parseInt(request.getParameter("idvehi"));
                    
                  
                  
                  idvehiculo=Integer.parseInt(request.getParameter("id"));
                  List listacubiculo = daocubiculo.CargarTablaDisponibilidadCubiculo(idvehiculo);
                  request.setAttribute("cubiculos", listacubiculo);
                  JOptionPane.showMessageDialog(null, listacubiculo.size());
                  request.getRequestDispatcher("Controlador?menu=Reserva&accion=Listar").forward(request, response);
                    
                    break;

                case "Reservar":
                   
                    
                    int idcubiculo=Integer.parseInt(request.getParameter("id"));
                    Cubiculo cubiculo= new Cubiculo();
                    cubiculo.setIdcubiculo(idcubiculo);
                    reserva.setIdCubiculo(idcubiculo);
                    reserva.setFechaAReservar(request.getParameter("txtfecha"));
                    JOptionPane.showMessageDialog(null, reserva.getFechaAReservar());
                    reserva.setHoraAReservar(request.getParameter("txthora"));
//                    reserva.setFechaAReservar("2024-03-30");
//                    reserva.setHoraAReservar("12:30:00");
                    reserva.setIdVehiculo(idV);
//                    daoreserva.registrar(reserva);
                    
                     if (daoreserva.registrar(reserva))
        {
            JOptionPane.showMessageDialog(null, "¡Reserva Realizada Exitosamente!");
            DaoCubiculo daoCu= new DaoCubiculo();
            daoCu.modificarCubiculoPorReserva(cubiculo);
            
            
           
        }else{ 
            JOptionPane.showMessageDialog(null, "Error al guardar la reserva");
        
            }  
                     request.getRequestDispatcher("Controlador?menu=Reserva&accion=Listar").forward(request, response);
                    break;

                case "Editar":

                    break;

                case "Eliminar":

                    break;
                default:
                    throw new AssertionError();
            }
            
            
            
            request.getRequestDispatcher("Reserva.jsp").forward(request, response);

        }
            
           
           
           
           
             if(menu.equals("MisReservas")){
               
                          switch (accion){
            
            case "Listar":
                HttpSession session = request.getSession();

                  // Obtener el ID del cliente de la sesión
                  int clienteId = (int) session.getAttribute("clienteId");

                  // Establecer el ID del cliente en el objeto cliente
                  
                  List listaReservas = daoreserva.listarReservasPorCliente(clienteId);
                  request.setAttribute("misReservas", listaReservas);
                  JOptionPane.showMessageDialog(null, listaReservas.size());
                 
                break;
                
                
            case "Agregar":
           
                break;
              
            case "Editar":
                
                break;
                
            case "Eliminar":
                
                
                 int idReserva=Integer.parseInt(request.getParameter("id"));
                 int idCubiculo=Integer.parseInt(request.getParameter("idcubiculo"));
                 JOptionPane.showMessageDialog(null, idReserva);
                 JOptionPane.showMessageDialog(null, idCubiculo);
                 

                 reserva.setIdReserva(idReserva);
                 cubiculo.setIdcubiculo(idCubiculo);
                 daoreserva.inhabilitarReserva(reserva);
                 daocubiculo.CambiarDisponibilidad(cubiculo);
                
                request.getRequestDispatcher("Controlador?menu=MisReservas&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
                
         request.getRequestDispatcher("MisReservas.jsp").forward(request, response);
            }
           
           
             if(menu.equals("Historial")){
                request.getRequestDispatcher("Historial.jsp").forward(request, response);
                          switch (accion){
            
            case "Listar":
                
                break;
                
                
            case "Agregar":
           
                break;
              
            case "Editar":
                
                break;
                
            case "Eliminar":
                
                break;
            default:
                throw new AssertionError();
        }
                
        
            }
             
             
             
             if(menu.equals("Cuenta")){
                
                
                
                
                 switch (accion) {

                     case "Cargar":

                         request.getRequestDispatcher("Cuenta.jsp").forward(request, response);

                         break;

                     case "Agregar":
//                 request.getRequestDispatcher("Controlador?menu=Cuenta&accion=Cargar").forward(request, response);

                         break;

                     case "Modificar":
                         String name1 = request.getParameter("txtname1");
                         String name2 = request.getParameter("txtname2");
                         String surname1 = request.getParameter("txtsurname1");
                         String surname2 = request.getParameter("txtsurname2");
                         String tipodocu = request.getParameter("txttipodocu");
                         String identification = request.getParameter("txtidentification");
                         String email = request.getParameter("txtemail");
                         String cellphone = request.getParameter("txtnumber");
                         String password = request.getParameter("txtpassword");

                         cliente2.setPrimerNombre(name1);
                         cliente2.setSegundoNombre(name2);
                         cliente2.setPrimerApellido(surname1);
                         cliente2.setSegundoApellido(surname2);
                         cliente2.setTipoDocumento(tipodocu);
                         cliente2.setNumeroidentificacion(identification);
                         cliente2.setCorreoElectronico(email);
                         cliente2.setCelular(cellphone);
                         cliente2.setContraseña(password);

                         if (daocliente.modificar(cliente2)) {
                             HttpSession session = request.getSession();
                             session.setAttribute("modificacionExitosa", true); // Atributo que indica que la modificación fue exitosa
                             session.setAttribute("clientelogueado", cliente2);
                         } else {
                             request.setAttribute("errorModificar", true); // Atributo que indica que hubo un error al modificar
                         }

                         request.getRequestDispatcher("Cuenta.jsp").forward(request, response);
                         break;

                     case "Eliminar":

                         break;
                     default:
                         throw new AssertionError();
                 }

            
        
            }
             
             
             
//        switch (accion){
//            
//            case "Vehiculo":
//                request.getRequestDispatcher("Vehiculo.jsp").forward(request, response);
//                break;
//                
//            case "Reserva":
//                request.getRequestDispatcher("Reserva.jsp").forward(request, response);
//                break;
//            
//            case "Historial":
//                request.getRequestDispatcher("Historial.jsp").forward(request, response);
//                break;  
//                
//            case "Cuenta":
//                request.getRequestDispatcher("Cuenta.jsp").forward(request, response);
//                break;   
//                
//            case "Home":
//                request.getRequestDispatcher("Home.jsp").forward(request, response);
//                break;       
//        }
        
//               String accion=request.getParameter("accion");
//        if(accion.equals("Ingresar")){
//            
//            String correo=request.getParameter("txtcorreologin");
//            String pass=request.getParameter("txtpass");
//            
// 
//            
//            cliente.setCorreoElectronico(correo);
//            cliente.setContraseña(pass);
//            r=daocliente.IniciarSesion(cliente);
//            if(r==1){
//                request.getRequestDispatcher("Principal.jsp").forward(request, response);
//                JOptionPane.showMessageDialog(null, "Pasate por acá");
//                
//            }else{
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                
//            }
//            
//            
//        }else{
//            
//        }
    }
    


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
//        String accion=request.getParameter("register");
//        
//        if(accion.equalsIgnoreCase("Registrar")){
//         String nom1=request.getParameter("first_name");
//         String nom2=request.getParameter("last_name");
//         String apell1=request.getParameter("first_surname");
//         String apell2=request.getParameter("last_surname");
//         String tipodocu=request.getParameter("tipodocu");
//         String identi=request.getParameter("identification");
//         String correo=request.getParameter("correo");
//         String celular=request.getParameter("celular");
//         String pass=request.getParameter("pass");
//         
//         Cliente clientenuevo= new Cliente();
//         DaoCliente daclien= new DaoCliente();
//         
//         clientenuevo.setPrimerNombre(nom1);
//         clientenuevo.setSegundoNombre(nom2);
//         clientenuevo.setPrimerApellido(apell1);
//         clientenuevo.setSegundoApellido(apell2);
//         clientenuevo.setTipoDocumento(tipodocu);
//         clientenuevo.setNumeroidentificacion(identi);
//         clientenuevo.setCorreoElectronico(correo);
//         clientenuevo.setCelular(celular);
//         clientenuevo.setContraseña(pass);
//         
//         if(daclien.registrar(clientenuevo)){
//             
//             JOptionPane.showMessageDialog(null, "Registro exitoso");
//         }else{
//             
//             JOptionPane.showMessageDialog(null, "Error al registrar");
//         }
//        
//        }
        
         
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
