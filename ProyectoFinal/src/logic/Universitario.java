package logic;



public class Universitario extends Personal {
	private String carrera;
	private boolean postGrado;

	public Universitario(String cedula, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String carrera, boolean postGrado) {
		super(cedula, name, apellido, sexo, nacionalidad, ciudad, direccion,fechaNacimiento, telefono, correo,
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
	
	//Probando

	
}
