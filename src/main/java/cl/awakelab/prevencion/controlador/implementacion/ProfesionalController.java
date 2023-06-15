package cl.awakelab.prevencion.controlador.implementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cl.awakelab.bootcamp.model.entity.Student;
import cl.awakelab.prevencion.conexion.DBConnection;
import cl.awakelab.prevencion.modelo.Cliente;
import cl.awakelab.prevencion.modelo.Profesional;

public class ProfesionalController extends UsuarioController{
	
	DBConnection conexion = DBConnection.getInstance();//Crear la conexion a la base de datos		
	
	public void registroProfesional(String titulo, String fechaIngreso) {
		
		String sql = "SET @ultimo_id = LAST_INSERT_ID();"
				+ "INSERT INTO usuario_profesional(usuario,titulo, fecha_ingreso) VALUES (@ultimo_id,?,?)";
		
		try {
			
			PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
			
			statement.setString(2, titulo);
			statement.setString(3, fechaIngreso);
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	 public Profesional findByIdStudent(int id) {
		    
		 	Profesional profesional = null;
		    String sql = "SELECT * FROM students WHERE id = ?";
		    
		    try {
		      
		      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		      statement.setInt(1, id);
		      ResultSet rs = statement.executeQuery();
		      
		      if(rs.next()) {
		        String titulo = rs.getString("titulo");
		        String fechaIngreso = rs.getString("fecha_ingreso");		        
		        
		        Profesional = new Profesional(id, titulo,fechaIngreso );
		        
		      }
		    } catch (Exception e) {
		      System.out.println(e.getMessage());
		    }		    
		    return profesional;
		  }
		  
		  
		  public Student updateStudent(Student student) {
		    
		    String sql = "UPDATE students SET name = ?, lastname = ?, email = ? WHERE id = ?";
		    
		    try {
		      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		      statement.setString(1, student.getName());
		      statement.setString(2, student.getLastname());
		      statement.setString(3, student.getEmail());
		      statement.setInt(4, student.getId());
		      // statement.executeQuery(); // aqui estaba el error!! es Update
		      statement.executeUpdate();
		      
		    } catch (Exception e) {
		      System.out.println(e.getMessage());
		    }
		    
		    return student;
		  }
		  
	
	  public Profesional updateProfesional(Profesional profesional) {
		    
		    String sql = "UPDATE usuario_profesional SET titulo = ?, fecha_ingreso = ? WHERE id = ?";
		    
		    try {
		      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
		      statement.setString(1, profesional.getTitulo());
		      statement.setString(2, profesional.getFechaIngreso());
		      statement.setInt(3, profesional.getId());
		      
		      // statement.executeQuery(); // aqui estaba el error!! es Update
		      statement.executeUpdate();
		      
		    } catch (Exception e) {
		      System.out.println(e.getMessage());
		    }
		    
		    return profesional;
	  }
}
