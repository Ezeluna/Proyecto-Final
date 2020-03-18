package logic;

import java.util.ArrayList;

public class Tecnico extends Personal {
	private String area;

	public Tecnico(String id, String name, String apellido, String sexo, String nacionalidad, String ciudad,
			String direccion, ArrayList<String> idiomas, String fechaNacimiento, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, boolean licencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String estudiosComplementarios, String area) {
		super(id, name, apellido, sexo, nacionalidad, ciudad, direccion, idiomas, fechaNacimiento, telefono, correo,
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

	
}
