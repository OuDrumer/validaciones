package cl.awakelab.prevencion.controlador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.prevencion.controlador.implementacion.AdministrativoController;
import cl.awakelab.prevencion.controlador.implementacion.ClienteController;
import cl.awakelab.prevencion.controlador.implementacion.ProfesionalController;
import cl.awakelab.prevencion.controlador.implementacion.UsuarioController;
import cl.awakelab.prevencion.modelo.Administrativo;
import cl.awakelab.prevencion.modelo.Cliente;
import cl.awakelab.prevencion.modelo.Profesional;
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
 * Servlet implementation class ServletCrearUsuario
 */
@WebServlet("/ServletCrearUsuario")
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Servlet Registro Usuario");
		//Crear una instancia de tipo de usuario para "atrapar" el valor de los parametros del front-end

		UsuarioController usuarioController = new UsuarioController();
		ClienteController clienteController = new ClienteController();
		ProfesionalController profesionalController = new ProfesionalController();
		AdministrativoController administrativoController = new AdministrativoController();
		
		int telefono = 0;
		String afp = null;
		String sistemaSalud = null;
		String direccion = null;
		String comuna = null;
		int edad = 0;
		String title = null;
		String fechaIngreso = null;
		String area = null;
		String experienciaPrevia = null;		
		
		String usuario			 = request.getParameter("usuario");
		String password			 = request.getParameter("password");
		String run				 = request.getParameter("run");
		String fechaNacimiento	 = request.getParameter("fechaNacimiento");
		String nombre			 = request.getParameter("nombre");
		String apellido			 = request.getParameter("apellido");
		String tipoUsuario		 = request.getParameter("tipoUsuario");
		if(tipoUsuario =="Cliente") {
			telefono			 = Integer.parseInt(request.getParameter("telefono"));
			afp					 = request.getParameter("afp");
			sistemaSalud		 = request.getParameter("sistemaSalud");
			direccion			 = request.getParameter("direccion");
			comuna				 = request.getParameter("comuna");
			edad				 = Integer.parseInt(request.getParameter("edad"));			
		}else if (tipoUsuario =="Profesional") {
			title				 = request.getParameter("titulo");
			fechaIngreso		 = request.getParameter("fechaIngreso");			
		}else if(tipoUsuario =="Administrativo") {
			area				 = request.getParameter("area");
			experienciaPrevia	 = request.getParameter("experienciaPrevia");			
		}
		
		Usuario newUsuario = new Usuario(usuario, password, run, fechaNacimiento, nombre, apellido, tipoUsuario);
		usuarioController.registroUsuario(newUsuario.getUsuario(), newUsuario.getPassword(), newUsuario.getRun(), newUsuario.getFechaNacimiento(), 
					newUsuario.getNombre(), newUsuario.getApellido(),newUsuario.getTipoUsuario());
		
		
		switch (tipoUsuario) {
		case "Cliente": {
			Cliente newCliente = new Cliente(telefono, afp, sistemaSalud, direccion, comuna, edad);
			
			clienteController.registroCliente(newCliente.getTelefono(), newCliente.getAfp(), newCliente.getSistemaSalud(), 
					newCliente.getDireccion(), newCliente.getComuna(), newCliente.getEdad());
			
			break;
		}
		case "Profesional": {
			Profesional newProfesional = new Profesional(title,fechaIngreso);
			profesionalController.registroProfesional(newProfesional.getTitulo(), newProfesional.getFechaIngreso());
			break;
		}
		case "Administrativo": {
			Administrativo newAdministrativo = new Administrativo(area, experienciaPrevia);
			administrativoController.registroAdministrativo(newAdministrativo.getArea(), newAdministrativo.getExperienciaPrevia());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoUsuario);
		}

		response.sendRedirect("index.jsp");		
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher requestDispatcher;
		 requestDispatcher = request.getRequestDispatcher("index.jsp");
		 requestDispatcher.forward(request, response);
	}

}
