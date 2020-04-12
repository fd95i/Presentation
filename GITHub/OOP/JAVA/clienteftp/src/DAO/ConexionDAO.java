package DAO;

import java.util.List;
import entidades.Conexion;
import exceptions.ConexionException;

public interface ConexionDAO {

    
	void crearConexion(Conexion conexion) throws ConexionException;
	void borrarConexion(Conexion conexion) throws ConexionException;
    void updateConexion(Conexion conexion) throws ConexionException;
	List<Conexion> getAllConexiones() throws ConexionException;
	Conexion getConexion(int id) throws ConexionException;	
	

}
