/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DaoCliente;

/**
 *
 * @author jhoan
 */
public class Validar extends HttpServlet {
    
    DaoCliente daocliente= new DaoCliente();
    Cliente cliente= new Cliente ();
    


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Validar</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        processRequest(request, response);
        
        
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            
            String correo=request.getParameter("txtcorreologin");
            String pass=request.getParameter("txtpass");
            
                    // Verificar si los campos están vacíos
        if (correo.isEmpty() || pass.isEmpty()) {
            // Si alguno de los campos está vacío, redirige de nuevo a la página de inicio de sesión
            request.setAttribute("mensaje", "Por favor, ingrese correo y contraseña.");
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return; // detener el flujo del método para evitar continuar con la autenticación
        }
            
            cliente.setCorreoElectronico(correo);
            cliente.setContraseña(pass);
            
            if(daocliente.IniciarSesion(cliente)){
                
                
                session.setAttribute("clienteId", cliente.getId());
                session.setAttribute("clientelogueado", cliente);
                request.setAttribute("usuario", cliente);
                session.setAttribute("sesionIniciada", true);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
            
            
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
        
        
        
        
      
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
