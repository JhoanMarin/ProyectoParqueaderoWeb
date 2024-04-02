/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DaoCliente;

/**
 *
 * @author jhoan
 */
public class Registro extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//           /** out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Registro</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//            * */
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
        
          String accion1=request.getParameter("register");
        
        if(accion1.equalsIgnoreCase("Registrar")){
         String nom1=request.getParameter("first_name");
         String nom2=request.getParameter("last_name");
         String apell1=request.getParameter("first_surname");
         String apell2=request.getParameter("last_surname");
         String tipodocu=request.getParameter("tipodocu");
         String identi=request.getParameter("identification");
         String correo=request.getParameter("correo");
         String celular=request.getParameter("celular");
         String pass=request.getParameter("pass");
         
         Cliente clientenuevo= new Cliente();
         DaoCliente daclien= new DaoCliente();
         
         clientenuevo.setPrimerNombre(nom1);
         clientenuevo.setSegundoNombre(nom2);
         clientenuevo.setPrimerApellido(apell1);
         clientenuevo.setSegundoApellido(apell2);
         clientenuevo.setTipoDocumento(tipodocu);
         clientenuevo.setNumeroidentificacion(identi);
         clientenuevo.setCorreoElectronico(correo);
         clientenuevo.setCelular(celular);
         clientenuevo.setContraseña(pass);
         
         if(daclien.registrar(clientenuevo)){
             
             JOptionPane.showMessageDialog(null, "Registro exitoso");
             request.getRequestDispatcher("index.jsp").forward(request, response);
         }else{
             
             JOptionPane.showMessageDialog(null, "Error al registrar");
             request.getRequestDispatcher("/Smart-Parking-System/signup.html").forward(request, response);
             

         }
        
        }
        
        
        
        
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
