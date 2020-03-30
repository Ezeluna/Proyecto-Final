package logic;


public class SolicitudUniversitario extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private String carrera;
	private boolean postGrado;

	public SolicitudUniversitario(float cantVacantes, Empresa empresa, String localidad, int edadMax, 
			int edadMin, int yearExperience, String tipoContrato, boolean vehiculoPropio, 
			int categoriaLicencia, boolean mudarse, String carrera, boolean postGrado) {
		super(cantVacantes, empresa, localidad, edadMax, edadMin, yearExperience,
				tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
		this.carrera = carrera; 
		this.postGrado = postGrado; 
	}

	@Override
	void insertarIdioma(String aux) {
		idiomas.add(aux); 
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
