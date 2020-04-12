package service;

import java.util.ArrayList;
import java.util.List;

import DAO.ConexionDAO;
import DAO.ConexionDAOImpl;
import entidades.Conexion;
import exceptions.ConexionException;

import javax.swing.*;


public class ConexionService {
	private ConexionDAO conexionDAO = new ConexionDAOImpl();

	public void altaConexion (Conexion con){
		try{
			conexionDAO.crearConexion(con);
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null,ce.getMessage());
		}
	}

	public void eliminarConexion(Conexion con){
		try{
			conexionDAO.borrarConexion(con);
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null,ce.getMessage());
		}
	}

	public void updateConexion(Conexion con) {
		try{
			conexionDAO.updateConexion(con);
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null,ce.getMessage());
		}
	}
	

	public Conexion getConexion(int id) {
		try{
			return conexionDAO.getConexion(id);
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null,ce.getMessage());
			return new Conexion();
		}
	}

	public List<Conexion> getAllConexiones() {
		try{
			return conexionDAO.getAllConexiones();
		} catch (ConexionException ce) {
			JOptionPane.showMessageDialog(null, ce.getMessage());
			return new ArrayList<>();
		}
	}
}
