package logic;



public class SolicitudTecnico extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private String area; 

	public SolicitudTecnico(float cantVacantes, Empresa empresa, String localidad, int edadMax, 
			int edadMin, int yearExperience, String tipoContrato, boolean vehiculoPropio, 
			int categoriaLicencia, boolean mudarse, String area) {
		super(cantVacantes, empresa, localidad, edadMax, edadMin, yearExperience,
				tipoContrato, vehiculoPropio, categoriaLicencia, mudarse);
		
		this.area = area;
	}

	@Override
	void insertarIdioma(String aux) {
		idiomas.add(aux); 
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	

}
