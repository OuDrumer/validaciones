package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.controlador.interfaces.IUsuario;
import cl.awakelab.prevencion.modelo.Administrativo;
import cl.awakelab.prevencion.modelo.Cliente;
import cl.awakelab.prevencion.modelo.Profesional;
import cl.awakelab.prevencion.modelo.Usuario;


public class UsuarioController implements IUsuario{

	@Override
	public List<Usuario> findAllUsers() {
		List<Usuario> usuarios = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
		String sql = "SELECT * FROM usuario";
		
		try {
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();			
			
			while(rs.next()) {			
				
				int id 						= rs.getInt("id");
				String user 				= rs.getString("usuario");
				String password 			= rs.getString("password");
				String run 					= rs.getString("run");
				String fechaNacimiento		= rs.getString("fecha_nacimiento");
				String nombre 				= rs.getString("nombre");
				String apellido				= rs.getString("apellido");				
				String tipo_usuario			= rs.getString("tipo_usuario");				
				
				Usuario usuario = new Usuario(id,user,password,run,fechaNacimiento,nombre,apellido, tipo_usuario);
				usuarios.add(usuario);
				
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}		
		return usuarios;		
	}

	@Override
	public List<Usuario> listarUsuariosPorTipo(String tipoUsuario) {
		
		List<Usuario> usuarios = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
		
		if(tipoUsuario == "1") {
			String sql = "SELECT u.*, uc.* FROM usuario u LEFT JOIN usuario_cliente uc ON u.usuario_cliente_id = uc.id WHERE tipo_usuario = 'Cliente'";
			
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {				
					int id 						= rs.getInt("u.id");
					String user 				= rs.getString("u.usuario");
					String password 			= rs.getString("u.password");
					String run 					= rs.getString("u.run");
					String fechaNacimiento		= rs.getString("u.fecha_nacimiento");
					String nombre 				= rs.getString("u.nombre");
					String apellido				= rs.getString("u.apellido");
					String tipo_usuario			= rs.getString("u.tipo_usuario");		
					int idCliente				= rs.getInt("uc.id");					
					int telefono				= rs.getInt("uc.telefono");
					String afp					= rs.getString("uc.afp");
					String sistemaSalud			= rs.getString("uc.sistema_salud");
					String direccion			= rs.getString("uc.direccion");
					String comuna				= rs.getString("uc.comuna");
					int edad					= rs.getInt("uc.edad");
					
					Cliente cliente = new Cliente(id,user,password,run,fechaNacimiento,nombre,apellido, tipo_usuario, 
							idCliente,telefono, afp, sistemaSalud, direccion, comuna, edad);
					usuarios.add(cliente);
				}								
			} catch (Exception e) {				
				System.out.println(e.getMessage());
			}
			
		}else if(tipoUsuario == "2"){
			String sql = "SELECT u.*, up.* FROM usuario u LEFT JOIN usuario_profesional up ON u.usuario_profesional_id = up.id WHERE tipo_usuario = 'Profesional'";
			
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {				
					int id 						= rs.getInt("u.id");
					String user 				= rs.getString("u.usuario");
					String password 			= rs.getString("u.password");
					String run 					= rs.getString("u.run");
					String fechaNacimiento		= rs.getString("u.fecha_nacimiento");
					String nombre 				= rs.getString("u.nombre");
					String apellido				= rs.getString("u.apellido");
					String tipo_usuario			= rs.getString("u.tipo_usuario");
					int idProfesional			= rs.getInt("uc.id");			
					String titulo				= rs.getString("uc.dtitulo");
					String fechaIngreso			= rs.getString("uc.fecha_ingreso");					
					
					Profesional profesional = new Profesional(id,user,password,run,fechaNacimiento,nombre,apellido,tipo_usuario, 
							idProfesional,titulo, fechaIngreso);
					usuarios.add(profesional);
				}								
			} catch (Exception e) {				
				System.out.println(e.getMessage());
			}
			
		}else if(tipoUsuario == "3") {
			String sql = "SELECT u.*, ua.* FROM usuario u LEFT JOIN usuario_administrativo ua ON u.usuario_administrativo_id = ua.id WHERE tipo_usuario = 'Administrativo'";
			
			try {
				PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {				
					int id 						= rs.getInt("u.id");
					String user 				= rs.getString("u.usuario");
					String password 			= rs.getString("u.password");
					String run 					= rs.getString("u.run");
					String fechaNacimiento		= rs.getString("u.fecha_nacimiento");
					String nombre 				= rs.getString("u.nombre");
					String apellido				= rs.getString("u.apellido");
					String tipo_usuario			= rs.getString("u.tipo_usuario");
					int idAdministrativo		= rs.getInt("ua.id");					
					String area					= rs.getString("ua.area");
					String experienciaPrevia	= rs.getString("ua.experiencia_previa");	
					
					Administrativo administrativo = new Administrativo(id,user,password,run,fechaNacimiento,nombre,apellido, tipo_usuario,
							idAdministrativo, area, experienciaPrevia);
					usuarios.add(administrativo);
				}								
			} catch (Exception e) {				
				System.out.println(e.getMessage());
			}			
		}
		return usuarios;
	}
	
	@Override
	public void registroUsuario(String usuario, String password, String run, String fechaNacimiento, String nombre,
			String apellido, String tipoUsuario) {
		DBConnection conexion = DBConnection.getInstance();//Crear la conexion a la base de datos		
		String sql = "INSERT INTO usuario(usuario,password,run,fecha_nacimiento,nombre,apellido,tipo_usuario) VALUES (?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, usuario);
			statement.setString(2, password);
			statement.setString(3, run);
			statement.setString(4, fechaNacimiento);
			statement.setString(5, nombre);
			statement.setString(6, apellido);
			statement.setString(7, tipoUsuario);
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void registroProfesional(String usuario, String password, String run, String fechaNacimiento, String nombre,
			String apellido, String titulo, String fechaIngreso) {
			//
	}

	@Override
	public void registroAdministrativo(String usuario, String password, String run, String fechaNacimiento,
			String nombre, String apellido, String area, String experienciaPrevia) {
			//	
	}

	@Override
	public void registroCliente(String usuario, String password, String run, String fechaNacimiento, String nombre,
			String apellido, int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
			//
	}

}
