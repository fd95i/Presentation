package Handler;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistas.AltaConexion;
import vistas.BajaConexion;
import vistas.BarraMenu;
import vistas.ConexionSimple;
import vistas.GrillaConexion;
import vistas.ModificarConexion;



public class PanelManager {

	private JFrame frame;
	private BarraMenu menuOpciones;
	
	private AltaConexion altaConexion;
	private BajaConexion bajaConexion;
	private ModificarConexion modificarConexion;
	private GrillaConexion grillaConexion;
	private ConexionSimple conexionSimple;
	
	public PanelManager() {
	}
	
	public void armarManager() {
		frame = new JFrame("Vozilla");
		frame.setBounds(100, 100, 600, 600);

		menuOpciones = new BarraMenu();
		menuOpciones.armarBarra();
		menuOpciones.setManager(this);
		frame.setJMenuBar(menuOpciones);
		
		altaConexion = new AltaConexion(this);
		altaConexion.PanelAltaConexion();
		
		bajaConexion = new BajaConexion(this);
		bajaConexion.PanelBajaConexion();
		
		modificarConexion = new ModificarConexion(this);
		modificarConexion.PanelModificacionConexion();
		
		grillaConexion = new GrillaConexion(this);
		grillaConexion.PanelGrillaConexion();
		
		conexionSimple = new ConexionSimple(this);
	
	}

	public void showFrame() {
		frame.setVisible(true);
	}

	public void mostrarSalir() {
		int response = JOptionPane.showConfirmDialog(frame, "Desea Salir?");
		if (response == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	public void cancelarPrincipal() {
		frame.getContentPane().removeAll();
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	
	}
	
	public void PanelAlta() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(altaConexion);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

	}
	
	public void PanelBaja() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(bajaConexion);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}
	
	public void PanelModificacion() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(modificarConexion);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}

	public void mostrarGrillaPanel() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(grillaConexion);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}

	public void conexionSimple() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(conexionSimple);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
	}
	
}

