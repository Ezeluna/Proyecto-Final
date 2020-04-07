package logic;

import java.util.ArrayList;
//hola
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Personal p1 = new Universitario("054-145","Juan","Perez","Masculino","Dominicano","Moca","Residencial Primaver","19 marzo","809-578-5034","juanperez21",5,true,true,false,false,true,"blabla","ITT",true);
	//	Personal p2 = new Tecnico("054-145","Juan","Perez","Masculino","Dominicano","Moca","Residencial Primaver","19 marzo","809-578-5034","juanperez21",5,true,true,false,false,true,"blabla","ITT");
	//	Personal p3 = new Tecnico("054-145","Juan","Perez","Masculino","Dominicano","Moca","Residencial Primaver","19 marzo","809-578-5034","juanperez21",5,true,true,false,false,true,"blabla","ITT");
	 //   p1.insertarIdioma("ingles, espanol");
	    
	//	Solicitud soli = new SolicitudBachiller(1, null, "si", 18, 20, 2, "largo", 	true, 0, true, null, null);
		Empresa empresa1 = new Empresa("1234", "Techdeb", "809-577-7305", "Moca", "Residencial Primavera", "Ingeniero", "Empresa12", 0, null, null, null);
		Bolsa_Laboral emp1 = new Bolsa_Laboral();
		emp1.insertEmpresa(empresa1);
//	    empresa1.insertarEmpleadoC(p1);
		//empresa1.insertarEmpleadoC(p2);
		//empresa1.insertarEmpleadoC(p3);
		
		System.out.println(emp1.CantTCon("1234"));
//		System.out.println(soli.getYearExperience());
		System.out.println(emp1.CantUCon("1234"));
		System.out.println(emp1.RetornarEmpresa("1234"));
	//	System.out.println(p1.getIdiomas());
		
		
	      
		
		
		
		
	}

}
