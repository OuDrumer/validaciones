package cl.awakelab.prevencion.controlador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.prevencion.controlador.implementacion.CapacitacionController;
import cl.awakelab.prevencion.modelo.Capacitacion;

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
 * Servlet implementation class ServletCrearCapacitacion
 */
@WebServlet("/ServletCrearCapacitacion")
public class ServletCrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Servlet Registro Capacitación");
		//Crear una instancia de capacitación para "atrapar" el valor de los parametros del front-end
		CapacitacionController capacitacionController = new CapacitacionController();
		String rutcliente = request.getParameter("rutCliente");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		String duracion = request.getParameter("duracion");
		int cantasistentes = Integer.parseInt(request.getParameter("cantAsistentes"));
		

		
		Capacitacion newCapacitacion = new Capacitacion();
		newCapacitacion.setRutCliente(rutcliente);
		newCapacitacion.setDia(dia);
		newCapacitacion.setHora(hora);
		newCapacitacion.setLugar(lugar);
		newCapacitacion.setDuracion(duracion);
		newCapacitacion.setCantidadDeAsistentes(cantasistentes);
		System.out.println(newCapacitacion);
		
		//Registro de capacitacion a la base de datos.
		capacitacionController.registroCapacitacion(
				newCapacitacion.getRutCliente(), 
				newCapacitacion.getDia(), 
				newCapacitacion.getHora(), 
				newCapacitacion.getLugar(), 
				newCapacitacion.getDuracion(), 
				newCapacitacion.getCantidadDeAsistentes());		
		
		
	    //Asignación del nombre del atributo que recibirá la informacion en la vista JSP(mensaje-capacitacion-creada.jsp)
	    request.setAttribute("capacitacion", newCapacitacion);
	    // reenviar esta informacion a un JSP
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/mensaje-capacitacion-creada.jsp");
	    dispatcher.forward(request, response);
		
//		response.sendRedirect("mensaje-capacitacion-creada.jsp");
		
	}
}
