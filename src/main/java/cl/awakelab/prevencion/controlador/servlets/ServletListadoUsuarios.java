package cl.awakelab.prevencion.controlador.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.prevencion.controlador.implementacion.UsuarioController;
import cl.awakelab.prevencion.modelo.Usuario;

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
 * Servlet implementation class ServletListadoUsuarios
 */
@WebServlet("/ServletListadoUsuarios")
public class ServletListadoUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String tipoUsuario = request.getParameter("tipousuario");
		 
		//Creacion manual de la lista que se enviará al JSP
		List<Usuario> usuarios = new ArrayList<>(); 
		usuarios.add(new Usuario("usuario1","usuarioPass1","17.243.346-k","19-01-1978", "Juan Pablo","Fernandez Jimenez"));
		usuarios.add(new Usuario("usuario2","usuarioPass2","15.501.283-4","30-06-1963", "David Luis","Boligni Maldini"));
		usuarios.add(new Usuario("usuario3","usuarioPass3","23.511.210-7","28-11-2000", "Luis Fernando","Ramirez Crucero"));
		usuarios.add(new Usuario("usuario4","usuarioPass4","28.422.301-9","01-03-2005", "Eddy Martin","Ramos Blanco"));
		
		  
	    UsuarioController usuario = new UsuarioController(); //
//	    System.out.println("Servlet Listar Capacitaciones inside");
	  
	    //Asignación del nombre del atributo que recibirá la informacion en la vista JSP
//	    request.setAttribute("usuarios", usuarios);
//	    request.setAttribute("usuarios", usuario.findAllUsers()); //Esta Recibe la información desde la base de datos
	    request.setAttribute("usuarios", usuario.listarUsuariosPorTipo(tipoUsuario)); //Esta Recibe la información desde la base de datos por tipo de usuario
	    // reenviar esta informacion a un JSP
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-usuarios.jsp");
	    dispatcher.forward(request, response);
	  }

}
