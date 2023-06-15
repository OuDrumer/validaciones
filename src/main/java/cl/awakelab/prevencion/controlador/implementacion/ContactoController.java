package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;

import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.controlador.interfaces.IContacto;

public class ContactoController implements IContacto{

	@Override
	public void registroContacto(String nombreCompleto, String email, String asunto, String mensaje) {
		DBConnection conexion = DBConnection.getInstance();
		String sql = "INSERT INTO contacto(nombrecompleto, email, asunto, mensaje)";
		
		try {
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, nombreCompleto);
			statement.setString(2, email);
			statement.setString(3, asunto);
			statement.setString(4, mensaje);	
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
