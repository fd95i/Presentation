package vistas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Handler.PanelManager;
import controladoresFTP.Ftp;
import entidades.Conexion;
import exceptions.ConexionException;


public class ConexionSimple extends PanelCancelable {
	private static final long serialVersionUID = 1L;

	private JFrame mainFrame;

	private JPanel currentPanel;

	private PanelManager panelManager;

	private Ftp ftp;

	private JLabel lblIp;
	private JLabel lblUser;
	private JLabel lblPass;

	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtUser;
	private JTextField txtPass;

	private JButton btnConectar = new JButton("Conectar");
	private JButton cancelarBtn = new JButton("Cancelar");

	private boolean startup = true;

	public ConexionSimple(PanelManager panelManager) {
		this.panelManager = panelManager;
		this.setLayout(new GridLayout(10, 4));
		this.createAllComponents();
		this.addAllComponentsToLayout();
		this.setListeners();
	}

	private void createAllComponents(){
		lblIp = new JLabel("Servidor: ");
		lblUser = new JLabel("Usuario: ");
		lblPass = new JLabel("Contrase�a: ");

		txtIp = new JTextField(20);
		txtPort = new JTextField(20);
		txtUser = new JTextField(20);
		txtPass = new JPasswordField(20);
	}

	private void addAllComponentsToLayout(){
		this.add(lblIp); // Agrega label de Servidor
		this.add(txtIp); // Agrega campo de texto para servidor
		this.add(lblUser); // Agrega label de Usuario
		this.add(txtUser); // Agrega campo de texto para usuario
		this.add(lblPass); // Agrega label de Contrase�a
		this.add(txtPass); // Agrega campo de texto para contrase�a

		this.add(btnConectar);
		this.add(cancelarBtn);
	}

	private void setListeners(){
		btnConectar.addActionListener(e -> {
			Conexion p1 = new Conexion(0, txtIp.getText(), txtPort.getText(), txtUser.getText(), txtPass.getText());
			this.conectarA(p1);
		});
		cancelarBtn.addActionListener(e -> irAPrincipal());
	}

	public void irAPrincipal() {
		panelManager.cancelarPrincipal();
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

	protected void conectarA(Conexion datosDeConexion) {
		this.validarConexion(datosDeConexion);
		ftp = new Ftp(datosDeConexion);
		ftp.connect();

		if (ftp.getConnected()) {
			currentPanel = new FTPView(this,mainFrame,ftp);
			this.iniciarLayoutFTP();
			mainFrame.repaint();
		} else {
			JOptionPane.showMessageDialog(null,"Falló la conexion con el servidor.");
		}
	}

	private void iniciarLayoutFTP() {
		GridBagConstraints constraints = new GridBagConstraints();

		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setSize(600, 500);
		mainFrame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {
	        	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         }
	     });

		Label lblHeader = new Label("Cliente FTP");
		lblHeader.setAlignment(Label.CENTER);

		JPanel panelHeader = new JPanel();

		panelHeader.setSize(600, 100);
		panelHeader.setLayout(new BorderLayout());
		panelHeader.add(lblHeader, BorderLayout.CENTER);
		panelHeader.setVisible(true);

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = .5;
		constraints.weighty = .1;
		mainFrame.add(panelHeader, constraints);

		if(startup) {
			startup = false;
		}

		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = .5;
		constraints.weighty = .9;
		mainFrame.add(currentPanel, constraints);
		mainFrame.setVisible(true);

		this.add(mainFrame);
	}
}
