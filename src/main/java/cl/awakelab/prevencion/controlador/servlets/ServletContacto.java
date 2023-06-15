package cl.awakelab.prevencion.controlador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.prevencion.controlador.implementacion.ContactoController;
import cl.awakelab.prevencion.modelo.Contacto;

/**
 * EjercicioGrupal 6 - Modulo 5 
 * Integrantes:
 * -Cesar Albornoz
 * -Catalina Muñoz
 * -Jaime Godoy
 * -Anthony Flores
 * 
 *  */

/**
 * Servlet implementation class ServletContacto
 */
@WebServlet("/ServletContacto")
public class ServletContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		System.out.println("Servlet Registro de Contacto");
		
		ContactoController contactoController = new ContactoController();
		String nombreCompleto = request.getParameter("nombreCompleto");
		String email = request.getParameter("email");
		String asunto = request.getParameter("asunto");
		String mensaje = request.getParameter("mensaje");
		
		Contacto newContacto = new Contacto();
		newContacto.setNombreCompleto(nombreCompleto);
		newContacto.setEmail(email);
		newContacto.setAsunto(asunto);
		newContacto.setMensaje(mensaje);
		System.out.println(newContacto);
		
		contactoController.registroContacto(
				newContacto.getNombreCompleto(), 
				newContacto.getEmail(),
				newContacto.getAsunto(),
				newContacto.getMensaje());
		
		
		response.sendRedirect("index.jsp");
	}

}
