package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import entidades.Conexion;
import exceptions.ConexionException;
//import sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl;
import DB.DBManager;

//NUEVO
public class ConexionDAOImpl implements ConexionDAO {

	private static ConexionDAOImpl instancia;

	public static ConexionDAOImpl getInstancia() {
		if (instancia == null) {
			instancia = new ConexionDAOImpl();
		}
		return instancia;
	}

	//

	@Override
	public void crearConexion(Conexion conexion) throws ConexionException {
		String sql = "INSERT INTO FTP.dbo.Conexion (Ip, Port, Usr, Pass) VALUES ('" + conexion.getip() + "', '"
				+ conexion.getPort() + "', '" + conexion.getUser() + "', '" + conexion.getPass() + "')";
		Connection c = DBManager.connect(); // Conexion con base de datos
		// Si hay un error con la conexion lo atrapo.
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) { // Al atrapar el error hago un rollback
			try {
				c.rollback();
				e.printStackTrace();
				throw new ConexionException("Error al ingresar una nueva conexion.");
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al intentar hacer rollback.");
			} finally { // Siempre cierra la conexion.
				try {
					c.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new ConexionException("Error al cerrar base de datos...");
				}
			}
		}
	}

	@Override
	public void borrarConexion(Conexion conexion) throws ConexionException {
		//String sql = "DELETE FROM FTP.dbo.Conexion WHERE ip = '" + conexion.getip() + "'";
		String sql = "DELETE FROM FTP.dbo.Conexion WHERE id = '" + conexion.getId() + "'";
		Connection c = DBManager.connect(); // Conexion con base de datos
		// Si hay un error con la conexion lo atrapo.
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) { // Al atrapar el error hago un rollback
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al borrar conexion");
			} finally { // Siempre cierra la conexion.
				try {
					c.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new ConexionException("Error al cerrar base de datos...");
				}
			}
		}
	}

	/*
	 * @Override public void updateConexion(Conexion conexion) throws
	 * ConexionException { String sql = "UPDATE FTP.dbo.Conexion SET ip = '" +
	 * conexion.getip() + "', Port = '" + conexion.getPort() + "', Usr = '" +
	 * conexion.getUser() + "', Pass = '" + conexion.getPass() + "'" +
	 * "WHERE ip = '" + conexion.getip() + "'"; Connection c = DBManager.connect();
	 * try { Statement s = c.createStatement(); s.executeUpdate(sql); c.commit(); }
	 * catch (SQLException e) { try { c.rollback(); e.printStackTrace(); } catch
	 * (SQLException e1) { e1.printStackTrace(); throw new
	 * ConexionException("Error al actualizar conexion."); } } finally { try {
	 * c.close(); } catch (SQLException e1) { e1.printStackTrace(); throw new
	 * ConexionException("Error al cerrar base de datos..."); } } }
	 */

	@Override
	public void updateConexion(Conexion conexion) throws ConexionException {
		Connection c = DBManager.connect();
		try {
			PreparedStatement ps = c
					.prepareStatement("UPDATE FTP.dbo.Conexion SET Ip = ?, port = ?, Usr = ?, Pass = ? WHERE Id = ?");
			ps.setString(1, conexion.getip());
			ps.setString(2, conexion.getPort());
			ps.setString(3, conexion.getUser());
			ps.setString(4, conexion.getPass());
			ps.setInt(5, conexion.getId());
			/*MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest("lalalal".getBytes());
			String hasheado = new String(digest);*/
			ps.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al actualizar conexion.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al cerrar base de datos...");
			}
		}
	}

	/******************************************
	 * /*****Metodo para obtener una conexion***** /
	 ******************************************/

	@Override
	public Conexion getConexion(int id) throws ConexionException {
		Conexion con = new Conexion();
		String sql = "SELECT * FROM FTP.dbo.Conexion WHERE Id = 5"; /*+ id;*/	
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
			con.setId(rs.getInt("Id"));
			con.setip(rs.getString("IP"));
			con.setPort(rs.getString("Port"));
			con.setUser(rs.getString("Usr"));
			con.setPass(rs.getString("Pass"));	
			
			}
		}

	catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("No se pudo consultar");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("No se pudo cerrar base de datos...");
			}
		}
		return con;
	}


	
	
/*

	@Override
	public Conexion getConexion(Conexion conexion) throws ConexionException {
		Conexion retorna = null;
		String sql = "SELECT * FROM FTP.dbo.Conexion WHERE Id = '" + conexion.getId() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//PreparedStatement ps = c
		//			.prepareStatement("SELECT Port, Usr, Pass FROM FTP.dbo.Conexion WHERE IP = ?");
		//	ps.setString(1, conexion.getip());
		//	ps.executeQuery();
			//Statement s = c.createStatement();
			//ResultSet rs = s.executeQuery();
			while (rs.next()) {
				/*String ip = rs.getString("IP");
				String port = rs.getString("Port");
				String user = rs.getString("Usr");
				String pass = rs.getString("Pass");
				retorna = new Conexion();
				retorna.setip(ip);
				retorna.setPort(port);
				retorna.setUser(user);
				retorna.setPass(pass);*/
			//	Conexion conAux = new Conexion(ip, port, user, pass);		
/*			retorna.setId(rs.getInt("Id"));
			retorna.setip(rs.getString("IP"));
			retorna.setPort(rs.getString("Port"));
			retorna.setUser(rs.getString("Usr"));
			retorna.setPass(rs.getString("Pass"));			
			
			}
		}

	catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("No se pudo consultar");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("No se pudo cerrar base de datos...");
			}
		}
		return retorna;
	}


	/******************************************
	 * /*Metodo para obtener todas las conexiones* /
	 ******************************************/

	@Override
	public List<Conexion> getAllConexiones() throws ConexionException {
		Conexion retorna = null;
		List<Conexion> listaDeConexiones = new LinkedList<Conexion>();
		String sql = "SELECT * FROM FTP.dbo.Conexion";
		Connection c = DBManager.connect();

		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("Id");
				String ip = rs.getString("IP");
				String port = rs.getString("Port");
				String user = rs.getString("Usr");
				String pass = rs.getString("Pass");
				retorna = new Conexion();
				retorna.setId(id);
				retorna.setip(ip);
				retorna.setPort(port);
				retorna.setUser(user);
				retorna.setPass(pass);
				listaDeConexiones.add(retorna);
			}
			return listaDeConexiones;

		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al obtener todas las conexiones.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new ConexionException("Error al cerrar base de datos...");
			}
		}
		return listaDeConexiones;
	}
}