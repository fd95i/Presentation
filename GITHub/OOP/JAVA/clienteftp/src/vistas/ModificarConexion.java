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

public class ModificarConexion extends PanelCancelable {
	private static final long serialVersionUID = 1L;

	private ConexionService conexionService = new ConexionService();

	private JLabel lblId;
	private JLabel lblIp;
	private JLabel lblPort;
	private JLabel lblUser;
	private JLabel lblPass;

	private JTextField txtId;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtUser;
	private JTextField txtPass;

	private JButton btnCargar = new JButton("Cargar");
	private JButton btnActualizar = new JButton("Actualizar");
	private JButton btnCancelar = new JButton("Cancelar");

	private PanelManager panelManager;

	public ModificarConexion(PanelManager panelManager) {
		super();
		this.panelManager = panelManager;
	}

	public void irAPrincipal() {
		panelManager.cancelarPrincipal();
	}

	public void PanelModificacionConexion() {
		this.setLayout(new GridLayout(8, 2));
		this.createAllComponents();
		this.camposEditables(false);
		this.addAllComponentsToPanel();
		this.setListeners();
	}

	private void createAllComponents(){
		lblId = new JLabel("Id: ");
		lblIp = new JLabel("Servidor: ");
		lblPort = new JLabel("Puerto: ");
		lblUser = new JLabel("Usuario: ");
		lblPass = new JLabel("Contrasenia: ");

		txtId = new JTextField(20);
		txtIp = new JTextField(20);
		txtPort = new JTextField(20);
		txtUser = new JTextField(20);
		txtPass = new JPasswordField(20);
	}


	private void addAllComponentsToPanel(){
		this.add(lblId); // Agrega label de Servidor
		this.add(txtId); // Agrega campo de texto para servidor
		this.add(lblIp); // Agrega label de Servidor
		this.add(txtIp); // Agrega campo de texto para servidor
		this.add(lblPort); // Agrega label de Puerto
		this.add(txtPort); // Agrega campo de texto para puerto
		this.add(lblUser); // Agrega label de Usuario
		this.add(txtUser); // Agrega campo de texto para usuario
		this.add(lblPass); // Agrega label de Contrase�a
		this.add(txtPass); // Agrega campo de texto para contrase�a

		this.add(btnCargar);
		this.add(btnActualizar);
		this.add(btnCancelar);
	}

	private void setListeners(){
		btnCargar.addActionListener( e -> {
			Conexion con = conexionService.getConexion(this.validarId()); // "Conexion adquirida!"
			this.validarConexion(con);

			this.camposEditables(true);
			txtIp.setText(con.getip());
			txtPort.setText(con.getPort());
			txtUser.setText(con.getUser());
			txtPass.setText(con.getPass());
		});

		btnActualizar.addActionListener(e -> {
			Conexion con = new Conexion();
			this.cargarDatosConexion(con);
			this.validarConexion(con);
			conexionService.updateConexion(con); // "Modificacion Realizada!");
		});

		btnCancelar.addActionListener(e -> this.irAPrincipal());
	}

	private void camposEditables(boolean value){
		txtIp.setEditable(value);
		txtPort.setEditable(value);
		txtUser.setEditable(value);
		txtPass.setEditable(value);
	}

	private int validarId(){
		try {
			return Integer.parseInt(txtId.getText());
		} catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null,"Debe ingresar un número en el campo ID");
			return -1;
		}
	}

	private void validarConexion(Conexion conexion) {
		try {
			if (conexion.getId() < 0) {
				throw new ConexionException("El campo ID está incorrecto");
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

	private void cargarDatosConexion(Conexion con){
		con.setip(txtIp.getText());
		con.setPort(txtPort.getText());
		con.setUser(txtUser.getText());
		con.setPass(txtPass.getText());
	}
}

//TODO revisar si se pueden borrar los métodos comentados
/*
	 * private void agregarDatosUsuario(){ getip.
	 * getNombre().setText(getUser().getUsername()); getNombre().setEnabled(false);
	 * getEmail().setText(getUser().getUsername());
	 * getPass().setText(getUser().getUsername()); }
	 */

/*
		buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConexionService conexionService = new ConexionService();
				Conexion p1 = new Conexion();
				if (e.getSource() == buscar) {
					p1.setip(txtIp.getText());
					p1.setPort(txtPort.getText());
					p1.setUser(txtUser.getText());
					p1.setPass(txtPass.getText());

					try {
						if (txtIp == null)
							JOptionPane.showMessageDialog(Panelconexion, "La conexion no existe");
						else
							conexionService.getConexiones(p1);

					} catch (ServiceException e1) {
						JOptionPane.showMessageDialog(Panelconexion, "Hubo un error en la base de datos", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
					}

					// "Modificacion Realizada!");

				}
			}
		});*/
