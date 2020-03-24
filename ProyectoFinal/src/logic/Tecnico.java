package logic;

public class Tecnico extends Personal {
	private String area;

	public Tecnico(String cedula, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, int edad, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, int categoriaLicencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String area) {
		super(cedula, name, apellido, sexo, nacionalidad, ciudad, direccion, edad, telefono, correo,
				yearExperiencia, vehiculo, categoriaLicencia, dispViajar, mudarse, contratado, estudiosComplementarios);
		// TODO Auto-generated constructor stub
		
		this.area = area;
	}
	
	@Override
	void insertarIdioma(String aux){
		idiomas.add(aux); 
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	//Probando
	
}
