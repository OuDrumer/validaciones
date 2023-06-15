package cl.awakelab.prevencion.controlador.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.prevencion.controlador.implementacion.CapacitacionController;

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
 * Servlet implementation class ServletListarCapacitaciones
 */
@WebServlet("/ServletListarCapacitaciones")
public class ServletListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	  @Override
	  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		//Creacion manual de la lista que se enviará al JSP
//		List<Capacitacion> capacitaciones = new ArrayList<>(); 
//		capacitaciones.add(new Capacitacion("23.232.878-k","Miercoles","20:00","Clinica de PDI", "1 hora", 35));
//		capacitaciones.add(new Capacitacion("28.873.115-8","Sabado","12:30","Hospital de Carabineros", "2 horas y 30 minutos", 12));
//		capacitaciones.add(new Capacitacion("19.992.431-4","Lunes","15:00","Clinica Central ACHS", "3 horas", 20));
//		capacitaciones.add(new Capacitacion("13.420.790-1","Martes","14:00","Campus Central Universidad del Obrero", "1 hora 30 minutos", 20));
//		capacitaciones.add(new Capacitacion("19.120.283-k","Sabado","10:00","Hospital General", "2 horas", 20));
		  		  
		  
	    CapacitacionController capacitacion = new CapacitacionController(); //
//	    System.out.println("Servlet Listar Capacitaciones inside");
	  
	    //Asignación del nombre del atributo que recibirá la informacion en la vista JSP
//	    request.setAttribute("capacitaciones", capacitaciones);
	    request.setAttribute("capacitaciones", capacitacion.findAllTraining()); //Esta Recibe la información desde la base de datos
	    // reenviar esta informacion a un JSP
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-capacitaciones.jsp");
	    dispatcher.forward(request, response);
	  }

}
