package vistas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Conexion;

public class ConexionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private static final int COLUMNA_ID = 0;
	private static final int COLUMNA_SERVIDOR = 1;
	private static final int COLUMNA_PUERTO = 2;
	private static final int COLUMNA_USUARIO = 3;
	private static final int COLUMNA_CONTRASENIA = 4;
	private String[] nombresColumnas = { "Id", "Servidor", "Puerto", "Usuario", "Contrasenia" };

//	private Class[] tiposColumnas = {String.class,String.class, String.class,String.class};

	private List<Conexion> filas;

	/**
	 * CONSTRUCTOR VACIO
	 */
	public ConexionTableModel() {
		filas = new ArrayList<Conexion>();
	}

	/**
	 * CONSTRUCTOR CON CONTENIDO INICIAL
	 * 
	 * @param contenidoInicial
	 */
	public ConexionTableModel(List<Conexion> contenidoInicial) {
		filas = contenidoInicial;
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public int getColumnCount() {
		return nombresColumnas.length;
	}

	/**
	 * OTRO METODO QUE HAY QUE PISAR
	 */
	public int getRowCount() {
		return filas.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Conexion u = filas.get(row);

		Object result = null;
		switch (col) {
		case COLUMNA_ID:
			u.setId((Integer) value);
		case COLUMNA_SERVIDOR:
			u.setip((String) value);
			break;
		case COLUMNA_PUERTO:
			u.setPort((String) value);
			break;
		case COLUMNA_USUARIO:
			u.setUser((String) value);
			break;
		case COLUMNA_CONTRASENIA:
			u.setPass((String) value);
			break;

		}

		fireTableCellUpdated(row, col);
	}

	/**
	 * METODO QUE HAY QUE PISAR
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {

		Conexion c = getFilas().get(rowIndex);// filas.get(rowIndex);

		switch (columnIndex) {
		case COLUMNA_ID:
			return c.getId();
		case COLUMNA_SERVIDOR:
			return c.getip();
		case COLUMNA_PUERTO:
			return c.getPort();
		case COLUMNA_USUARIO:
			return c.getUser();
		case COLUMNA_CONTRASENIA:
			return c.getPass();

		default:
			return null;

		}

	}

	public Conexion getValueAt(int rowIndex) {
		Conexion c;

		try {
			c = this.getFilas().get(rowIndex);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		return c;
	}
	

	public String getColumnName(int col) {
		return nombresColumnas[col];
	}

	/*
	 * public Class getColumnClass(int col) { return tiposColumnas[col]; }
	 */

	/**
	 * GETTER DE MIS FILAS
	 * 
	 * @return
	 */

	public List<Conexion> getFilas() {
		return (List<Conexion>) filas;
	}

	/**
	 * SETTER DE MIS FILAS
	 * 
	 * @param filas
	 */

	public void setFilas(List<Conexion> filas) {
		this.filas = filas;
	}
	/*
	 * public boolean isCellEditable(int rowIndex, int columnIndex){ return true; }
	 */

	public void removeConexion(Conexion conexion) {
		filas.remove(conexion);
		fireTableDataChanged();
	}
}
