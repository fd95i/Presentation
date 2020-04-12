package vistas;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Handler.PanelManager;
import entidades.Conexion;
import service.ConexionService;

public class GrillaConexion extends PanelCancelable implements  Printable {
	private static final long serialVersionUID = 1L;

	private ConexionService conexionService = new ConexionService();

	private JTable tablaConexion;
	private ConexionTableModel modeloConexion;
	private PanelManager panelManager;
	private ConexionSimple conexionSimple = new ConexionSimple(panelManager);
	private List<Conexion> listaDeConexiones;

	private JScrollPane scrollPaneParaTabla;
	private JButton botonLlenar = new JButton("Cargar");
	private JButton botonModificar = new JButton("Modificar");
	private JButton btnConectar = new JButton("Conectar");
	private JButton btnCancelar = new JButton("Cancelar");

	public GrillaConexion(PanelManager m) {
		super();
		this.panelManager = m;
	}

	public void irAPrincipal() {
		panelManager.cancelarPrincipal();
	}

	public void PanelGrillaConexion() {
		this.createAllComponents();
		this.setAllComponentsValues();
		this.setListeners();
		this.addAllComponentsToPanel();

		// TODO no sé por qué está este jajaja
		// 		final JTable tabla = new JTable(new ConexionTableModel(getListaDeConexiones()));
	}

	private void createAllComponents(){
		modeloConexion = new ConexionTableModel();
		tablaConexion = new JTable(modeloConexion);
		scrollPaneParaTabla = new JScrollPane(tablaConexion);
	}

	private void setAllComponentsValues(){
		setBounds(100, 100, 600, 600);
	}

	private void addAllComponentsToPanel() {
		this.add(scrollPaneParaTabla);
		this.add(botonLlenar);
		this.add(botonModificar);
		this.add(btnConectar);
		this.add(btnCancelar);
	}

	private void setListeners(){
		botonModificar.addActionListener(e -> {
//			TODO hacer update en la DAO y en la tabla
		});

		botonLlenar.addActionListener(e -> {
			if (e.getSource() == botonLlenar) {
				List<Conexion> lista = new ArrayList<>();
//			try {
//				lista.addAll(conexionService.getAllConexiones());
//			} catch (ServiceException e1) {
//			} TODO SACAR COMMENT MAS QUE NADA PORQUE NO ESTOY USANDO SQLSERVER
				lista.add(new Conexion(0, "ftp.drivehq.com", "", "avozella", "ITALIA7A"));
				modeloConexion.setFilas(lista);
				modeloConexion.fireTableDataChanged();
			}
		});

		btnConectar.addActionListener(e -> {
			Conexion con = this.getRegistroSeleccionadoEnTabla();
			conexionSimple.conectarA(con);
		});

		btnCancelar.addActionListener(e -> this.irAPrincipal());
	}

	private Conexion getRegistroSeleccionadoEnTabla(){
		int index = tablaConexion.getSelectedRow();
		ConexionTableModel ctm = (ConexionTableModel) tablaConexion.getModel();
		return ctm.getValueAt(index);
	}

	public int print(Graphics arg0, PageFormat arg1, int arg2) throws PrinterException {
		return 0;
	}

	public List<Conexion> getListaDeConexiones() {
		return listaDeConexiones;
	}
}