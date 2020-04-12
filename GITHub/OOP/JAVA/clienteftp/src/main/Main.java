package main;

import java.sql.SQLException;

import Handler.PanelManager;
//import TEST.Tablainicial;
import exceptions.ConexionException;
import exceptions.ServiceException;
import exceptions.dbException;

public class Main {
	
	private PanelManager manager;
	
	public static void main(String[] args) throws dbException, ConexionException, SQLException, ServiceException {
		
		Main ppal = new Main();
		ppal.iniciarManager();
		ppal.showFrame();
		/*
		ConexionDAOImpl cDAOI = new ConexionDAOImpl ();
	//	cDAOI.dropEmpleadoTable();
	//	cDAOI.CrearTablaEmpleado(null);
		
	//	Empleado P1 = new Empleado("Diego", "Garone",34137859," Segui 871", "42400689", "diego.garone@gmail.com",444444);
	//	Empleado P2 = new Empleado("Rocio", "Milio", 33980126," Pichincha 454", "42400689", "rociomilio22@hotmail.com",111111111);

		ConexionService insert = new ConexionService();
		insert.altaEmpleado(P1);
		insert.altaEmpleado(P2);

	
				
		TablaPmDaoImpl tm1 = new TablaPmDaoImpl();
		tm1.dropPmTable();
		tm1.CrearTablaPm(null);
		
		
		Pm m1 = new Pm(1,"Letici", "Marcec", 12370055, "Lanus", "4392821", "leti@gmail.com","Infraestructura",54);
		Pm m2 = new Pm(2,"Gabriela", "Failacce", 13577101, "Lomas", "4832732", "gabi@gmail.com","Seguridad Informatica",76);

		
		PmService insertarM = new PmService();
		insertarM.altaPm(m1);
		insertarM.altaPm(m2);
			
		
		TablaProyectoDaoImpl tm2 = new TablaProyectoDaoImpl();
		tm2.dropProyectoTable();
		tm2.CrearTablaProyecto(null);
		*/
	}
		
	public void iniciarManager() {
		manager = new PanelManager();
		manager.armarManager();
	}
	

	
	public void showFrame() {
		manager.showFrame();
	}
}
