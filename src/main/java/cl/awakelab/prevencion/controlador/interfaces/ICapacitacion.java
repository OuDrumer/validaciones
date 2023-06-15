package cl.awakelab.prevencion.controlador.interfaces;

import java.util.List;

import cl.awakelab.prevencion.modelo.Capacitacion;

public interface ICapacitacion {
	
	public List<Capacitacion> findAllTraining();
	void registroCapacitacion(String rutcliente, String dia, String hora, String lugar, String duracion, int cantidadasistentes);
}
