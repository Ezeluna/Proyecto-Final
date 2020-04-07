package logic;

import java.util.ArrayList;

public class SolicitudUniversitario extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private String carrera;
	private boolean postGrado;

	public SolicitudUniversitario(float cantVacantes, Empresa empresa, String localidad, int edadMax, 
			int edadMin, int yearExperience, String tipoContrato, boolean vehiculoPropio, 
			int categoriaLicencia, boolean mudarse, ArrayList<String> idiomas, String carrera, boolean postGrado, 
			float cantAux) {
		super(cantVacantes, empresa, localidad, edadMax, edadMin, yearExperience,
				tipoContrato, vehiculoPropio, categoriaLicencia, mudarse, idiomas, cantAux);
		
		this.carrera = carrera; 
		this.postGrado = postGrado; 
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public boolean isPostGrado() {
		return postGrado;
	}

	public void setPostGrado(boolean postGrado) {
		this.postGrado = postGrado;
	}
	
	

}
