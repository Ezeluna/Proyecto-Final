package logic;

import java.util.ArrayList;

public class Universitario extends Personal {
	private String carrera;
	private boolean postGrado;

	public Universitario(String id, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, ArrayList<String> idiomas, String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String carrera, boolean postGrado) {
		super(id, name, apellido, sexo, nacionalidad, ciudad, direccion, idiomas, fechaNacimiento, telefono, correo,
				yearExperiencia, vehiculo, licencia, dispViajar, mudarse, contratado, estudiosComplementarios);
		// TODO Auto-generated constructor stub
		
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
