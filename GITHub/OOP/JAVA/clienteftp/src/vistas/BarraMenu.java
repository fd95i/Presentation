package vistas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Handler.PanelManager;

public class BarraMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private PanelManager manager;
	
	public BarraMenu() {
	}
	
	public void setManager(PanelManager handler) {
		this.manager = handler;
	}
	
	public void armarBarra() {
		JMenu archivo = new JMenu("Archivo");
		
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.mostrarSalir();
			}
		});
		
		archivo.add(salir);
		
		JMenu paneles = new JMenu("Acciones");
		
		JMenuItem mostrarUnPanel = new JMenuItem("Alta Conexion");
		mostrarUnPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.PanelAlta();
			}
		});
		
		paneles.add(mostrarUnPanel);
		
		JMenuItem mostrarOtroPanel = new JMenuItem("Baja Conexion");
		mostrarOtroPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.PanelBaja();
			}
		});
		paneles.add(mostrarOtroPanel);
		

		JMenuItem mostrarModificarConexion = new JMenuItem("Modificar Conexion");
		mostrarModificarConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.PanelModificacion();
			}
		});
		paneles.add(mostrarModificarConexion);
		
		
		
		JMenuItem mostrarGrillaConexion = new JMenuItem("Conexiones Existentes");
		mostrarGrillaConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.mostrarGrillaPanel();
			}
		});
		paneles.add(mostrarGrillaConexion);
		
		JMenuItem conexionSimple = new JMenuItem("Conexion Simple");
		conexionSimple.addActionListener(e -> {
			manager.conexionSimple();
		});
		paneles.add(conexionSimple);
		
		add(archivo);
		add(paneles);
	
	}

}


