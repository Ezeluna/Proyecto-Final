package logic;


//jeje
public class Universitario extends Personal {
	
	private static final long serialVersionUID = 1L;
	private String carrera;
	private boolean postGrado;

	public Universitario(String cedula, String name, String apellido, String sexo, String nacionalidad, String provincia,
			String ciudad, String sector, String calle, String numeroCasa,String referencia, int edad, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, int categoriaLicencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String carrera, boolean postGrado) {
		super(cedula, name, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, edad, telefono, correo,
				yearExperiencia, vehiculo, categoriaLicencia, dispViajar, mudarse, contratado, estudiosComplementarios);
		// TODO Auto-generated constructor stub
		
		this.carrera = carrera;
		this.postGrado = postGrado;
	}
	
	@Override
	void insertarIdioma(String aux){
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
	
	//Probando

	
}
