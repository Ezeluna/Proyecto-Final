package logic;



public class Tecnico extends Personal {
	private String area;

	public Tecnico(String cedula, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String area) {
		super(cedula, name, apellido, sexo, nacionalidad, ciudad, direccion, fechaNacimiento, telefono, correo,
				yearExperiencia, vehiculo, licencia, dispViajar, mudarse, contratado, estudiosComplementarios);
		// TODO Auto-generated constructor stub
		
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	//Probando
	
}
