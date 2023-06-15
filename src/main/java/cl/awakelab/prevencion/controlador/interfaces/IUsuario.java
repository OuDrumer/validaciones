package cl.awakelab.prevencion.controlador.interfaces;

import java.util.List;

import cl.awakelab.prevencion.modelo.Usuario;

public interface IUsuario {
	
	public List<Usuario> findAllUsers();
	
	void registroUsuario(String usuario, String password, String run, String fechaNacimiento, String nombre, String apellido, String tipoUsuario);
	
	void registroProfesional(String usuario, String password, String run, String fechaNacimiento, String nombre, String apellido, String titulo, String fechaIngreso);
	
	void registroAdministrativo(String usuario, String password, String run, String fechaNacimiento, String nombre, String apellido, 
			String area, String experienciaPrevia);
	
	void registroCliente(String usuario, String password, String run, String fechaNacimiento, String nombre, String apellido, 
			int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad);
	
	List<Usuario> listarUsuariosPorTipo(String tipoUsuario);
	
}

