package logic;

import java.util.ArrayList;

public class SolicitudBachiller extends Solicitud {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> habilidades; 

	public SolicitudBachiller( float cantVacantes, Empresa empresa, String localidad,
			int edadMax, int edadMin, int yearExperience, String tipoContrato, boolean vehiculoPropio, int categoriaLicencia,
			boolean mudarse, ArrayList<String> idiomas, ArrayList<String> habilidades) {
		super(cantVacantes, empresa, localidad, edadMax, edadMin, yearExperience,
				tipoContrato, vehiculoPropio, categoriaLicencia, mudarse, idiomas );
		
		this.habilidades = new ArrayList<>();
		for (String habili : habilidades) {
			this.habilidades.add(habili);
			
		}
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}
	
	

}
