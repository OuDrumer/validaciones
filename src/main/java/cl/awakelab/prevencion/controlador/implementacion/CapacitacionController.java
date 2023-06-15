package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.controlador.interfaces.ICapacitacion;
import cl.awakelab.prevencion.modelo.Capacitacion;

public class CapacitacionController implements ICapacitacion{

	@Override	
	public List<Capacitacion> findAllTraining() {
		
		List<Capacitacion> capacitaciones = new ArrayList<>();
		DBConnection conexion = DBConnection.getInstance();
		String sql = "SELECT * FROM capacitacion";
		
		try {
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();			
			
			while(rs.next()) {				
				
				int id 					= rs.getInt("id");
				String rut 				= rs.getString("rutcliente");
				String dia 				= rs.getString("dia");
				String hora 			= rs.getString("hora");
				String lugar			= rs.getString("lugar");
				String duracion 		= rs.getString("duracion");
				int cantAsistentes		= rs.getInt("cantidadasistentes");
				
				Capacitacion capacitacion = new Capacitacion(id,rut,dia,hora,lugar,duracion,cantAsistentes);
				capacitaciones.add(capacitacion);
				
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}		
		return capacitaciones;		
	}

	@Override
	public void registroCapacitacion(String rutcliente, String dia, String hora, String lugar, String duracion, int cantidadasistentes) {
		
		DBConnection conexion = DBConnection.getInstance();//hacer o crear la conexion a la base de datos
		
		String sql = "INSERT INTO capacitacion(rutcliente, dia, hora, lugar, duracion, cantidadasistentes) VALUES (?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			statement.setString(1, rutcliente);
			statement.setString(2, dia);
			statement.setString(3, hora);
			statement.setString(4, lugar);
			statement.setString(5, duracion);
			statement.setInt(6, cantidadasistentes);
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
