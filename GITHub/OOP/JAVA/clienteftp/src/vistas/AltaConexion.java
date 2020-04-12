package vistas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Handler.PanelManager;
import entidades.Conexion;
import exceptions.ConexionException;
import service.ConexionService;

public class AltaConexion extends PanelCancelable {
	private static final long serialVersionUID = 1L;

	private ConexionService conexionService = new ConexionService();

	private PanelManager panelManager;

	private JLabel lblIp;
	private JLabel lblPort;
	private JLabel lblUser;
	private JLabel lblPass;

	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtUser;
	private JTextField txtPass;

	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnCancelar = new JButton("Cancelar");

	public AltaConexion(PanelManager panelManager) {
		super();
		this.panelManager = panelManager;
	}

	public void irAPrincipal() {
		panelManager.cancelarPrincipal();
	}

	public void PanelAltaConexion() {
		this.setLayout(new GridLayout(10, 4));
		this.createAllComponents();
		this.addAllComponentsToPanel();
		this.setListeners();
	}

	private void createAllComponents(){
		lblIp = new JLabel("Servidor: ");
		lblPort = new JLabel("Puerto: ");
		lblUser = new JLabel("Usuario: ");
		lblPass = new JLabel("Contrasenia: ");

		txtIp = new JTextField(20);
		txtPort = new JTextField(20);
		txtUser = new JTextField(20);
		txtPass = new JPasswordField(20);
	}

	private void addAllComponentsToPanel(){
		this.add(lblIp);   //Agrega label de Servidor
		this.add(txtIp);    //Agrega campo de texto para servidor

		this.add(lblPort); //Agrega label de Puerto
		this.add(txtPort);  //Agrega campo de texto para puerto

		this.add(lblUser); //Agrega label de Usuario
		this.add(txtUser);  //Agrega campo de texto para usuario

		this.add(lblPass); //Agrega label de Contrase�a
		this.add(txtPass);  //Agrega campo de texto para contrase�a

		this.add(btnAceptar);
		this.add(btnCancelar);
	}

	private void setListeners(){
		btnAceptar.addActionListener(e -> {
			Conexion con = new Conexion();
			this.cargarDatosConexion(con);
			this.validarConexion(con);
			conexionService.altaConexion(con);
			JOptionPane.showMessageDialog(this, "Alta Realizada!");
		});

		btnCancelar.addActionListener(e -> this.irAPrincipal());
	}

	private void cargarDatosConexion(Conexion con){
		con.setip(txtIp.getText());
		con.setPort(txtPort.getText());
		con.setUser(txtUser.getText());
		con.setPass(txtPass.getText());
	}

	private void validarConexion(Conexion conexion) {
		try {
			if (conexion.getId() < 0) {
				throw new ConexionException("No se ha asignado una id al server");
			}
			if (conexion.getip().equals("")) {
				throw new ConexionException("El campo Host es requerido");
			}
			if (conexion.getUser().equals("")) {
				throw new ConexionException("El campo Usuario es requerido");
			}
			if (conexion.getPass().equals("")) {
				throw new ConexionException("El campo Password es requerido");
			}
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null, ce.getMessage());
		}
	}
}
