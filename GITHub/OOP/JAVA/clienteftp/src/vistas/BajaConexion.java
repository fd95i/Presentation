package vistas;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Handler.PanelManager;
import entidades.Conexion;
import service.ConexionService;


public class BajaConexion extends PanelCancelable {
	private static final long serialVersionUID = 1L;

	private ConexionService conexionService = new ConexionService();

	private PanelManager panelManager;
	private JLabel lblId;
	private JTextField txtId;

	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	public BajaConexion(PanelManager panelManager) {
		super();
		this.panelManager = panelManager;
	}

	public void irAPrincipal() {
		panelManager.cancelarPrincipal();
	}
	
	public void PanelBajaConexion() {
		this.setLayout(new GridLayout(8,2));
		this.createAllComponents();
		this.addAllComponentsToPanel();
		this.setListeners();
	}


	private void createAllComponents(){
		lblId = new JLabel("Id: ");
		txtId = new JTextField(20);
	}

	private void addAllComponentsToPanel(){
		this.add(lblId);
		this.add(txtId);
		this.add(btnAceptar);
		this.add(btnCancelar);
	}

	private void setListeners(){
		btnAceptar.addActionListener(e -> {
			Conexion con = new Conexion();
			this.validarId();
			con.setId(Integer.parseInt(txtId.getText()));
			conexionService.eliminarConexion(con);
			JOptionPane.showMessageDialog(this, "Alta Realizada!");
		});
		
		btnCancelar.addActionListener(e -> this.irAPrincipal());
	}

	private void validarId(){
		try{
			if(txtId.getText().equals("")){
				throw new NullPointerException("Se debe completar el campo ID");
			}
			Integer.parseInt(txtId.getText());
		}catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null,npe.getMessage());
		}catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,"El campo ID debe ser un número");
		}
	}
}
