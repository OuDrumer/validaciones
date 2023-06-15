package cl.awakelab.prevencion.modelo;

public class Administrativo extends Usuario {
	private int idAdministrativo;
	private String area;
	private String experienciaPrevia;

	/**
	 * Constructor Vacio.
	 */
	public Administrativo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param area
	 * @param experienciaPrevia
	 */
	public Administrativo(String area, String experienciaPrevia) {
		super();
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}



	/**
	 * @param nombre Nombre del Usuario.
	 * @param apellido Apellido del Usuario.
	 * @param fechaDeNacimiento Fecha de Nacimiento del Usuario.
	 * @param run Rut del Usuario.
	 * @param area Área de trabajo a la cual pertenece el Administrativo.
	 * @param experienciaPrevia Experiencia en otros trabajos del Administrativo.
	 * 
	 */
	public Administrativo(String usuario, String password, String run, String fechaNacimiento, String nombre,
			String apellido, String tipoUsuario, String area, String experienciaPrevia) {
		super(usuario, password, run, fechaNacimiento, nombre, apellido, tipoUsuario);
		this.area=area;
		this.experienciaPrevia=experienciaPrevia;
	}
	
	/**
	 * @param nombre Nombre del Usuario.
	 * @param apellido Apellido del Usuario.
	 * @param fechaDeNacimiento Fecha de Nacimiento del Usuario.
	 * @param run Rut del Usuario.
	 * @param area Área de trabajo a la cual pertenece el Administrativo.
	 * @param experienciaPrevia Experiencia en otros trabajos del Administrativo.
	 * 
	 */
	public Administrativo(int id, String usuario, String password, String run, String fechaNacimiento, String nombre,
			String apellido, String tipoUsuario, int idAdministrativo, String area, String experienciaPrevia) {
		super(id, usuario, password, run, fechaNacimiento, nombre, apellido, tipoUsuario);
		this.idAdministrativo = idAdministrativo;
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}	
	
	public int getIdAdministrativo() {
		return idAdministrativo;
	}

	public String getArea() {
		return area;
	}
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}
	@Override
	public String toString() {
		return "Administrativo [area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
	}
	
	
	
}
