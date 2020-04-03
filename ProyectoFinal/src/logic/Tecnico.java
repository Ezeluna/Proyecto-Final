package logic;

import java.time.LocalDate;

public class Tecnico extends Personal {
	//jeje
	private static final long serialVersionUID = 1L;
	private String area;

	public Tecnico(String cedula, String name, String apellido, String sexo, String nacionalidad,  String provincia,
			String ciudad, String sector, String calle, int numeroCasa, String referencia,  LocalDate fechaN, String telefono, String correo,
			int yearExperiencia, boolean vehiculo, int categoriaLicencia, boolean dispViajar, boolean mudarse,
			boolean contratado, String area) {
		super(cedula, name, apellido, sexo, nacionalidad, provincia, ciudad, sector, calle, numeroCasa, referencia, fechaN, telefono, correo,
				yearExperiencia, vehiculo, categoriaLicencia, dispViajar, mudarse, contratado);
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
