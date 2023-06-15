package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;

import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.modelo.Cliente;

public class ClienteController extends UsuarioController{
	DBConnection conexion = DBConnection.getInstance();//Crear la conexion a la base de datos		
	
	public void registroCliente(int telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad) {
		
		String sql = "SET @ultimo_id = LAST_INSERT_ID();"
				+ "INSERT INTO usuario_cliente(id_usuario, telefono, afp, sistema_salud, direccion, comuna, edad) VALUES (@ultimo_id,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		
			statement.setInt   (2, telefono);
			statement.setString(3, afp);
			statement.setString(4, sistemaSalud);
			statement.setString(5, direccion);
			statement.setString(6, comuna);
			statement.setInt   (7, edad);
			
			statement.executeUpdate();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public Cliente updateCliente(Cliente cliente) {
	    
	    String sql = "UPDATE usuario_cliente SET telefono = ?, afp = ? , sistema_salud = ? , direccion = ? , comuna = ? , edad = ? WHERE id = ?";
	    
	    try {
	      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	      statement.setInt(1, cliente.getTelefono());
	      statement.setString(2, cliente.getAfp());
	      statement.setString(3, cliente.getSistemaSalud());
	      statement.setString(4, cliente.getDireccion());
	      statement.setString(5, cliente.getComuna());
	      statement.setInt(6, cliente.getEdad());
	      statement.setInt(7, cliente.getId());
	      
	      // statement.executeQuery(); // aqui estaba el error!! es Update
	      statement.executeUpdate();
	      
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	    
	    return cliente;
  }
}
