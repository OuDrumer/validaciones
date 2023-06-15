package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;

import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.modelo.Administrativo;

public class AdministrativoController extends UsuarioController{
	DBConnection conexion = DBConnection.getInstance();//Crear la conexion a la base de datos		
	
	public void registroAdministrativo(String area, String experienciaPrevia) {
		
		String sql = "SET @ultimo_id = LAST_INSERT_ID();"
				+ "INSERT INTO usuario_administrativo(id_usuario,area, experiencia_previa) VALUES (@ultimo_id,?,?)";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			statement.setString(2, area);
			statement.setString(3, experienciaPrevia);
			
			statement.executeUpdate();
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public Administrativo updateAdministrativo(Administrativo administrativo) {
	    
	    String sql = "UPDATE usuario_administrativo SET area = ?, experiencia_previa = ? WHERE id = ?";
	    
	    try {
	      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
	      statement.setString(1, administrativo.getArea());
	      statement.setString(2, administrativo.getExperienciaPrevia());
	      statement.setInt(3, administrativo.getId());
	      
	      // statement.executeQuery(); // aqui estaba el error!! es Update
	      statement.executeUpdate();
	      
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	    
	    return administrativo;
  }
}
