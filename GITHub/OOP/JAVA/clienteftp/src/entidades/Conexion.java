package entidades;

public class Conexion {

	private int id;
	private String ip;
	private String port;
	private String user;
	private String pass;
	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getip() {
		return ip;
	}

	public void setip(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Conexion() {
		
	}

	//Constructor
	public Conexion(int id, String ip, String port, String user, String pass) {
		this.id = id;
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.pass = pass;
	}
	
	

	public String toString() {
		return	"id" + id
				+ "ip=" + ip
				+ ", port=" + port 
				+ ", user=" + user 
				+ ", pass=" + pass + "]\n";
	}


}