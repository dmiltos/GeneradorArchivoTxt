package py.com.xsys.generadorarchivo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBd {
	private static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//Cambiar por los valores de conexion a la BD
	protected String host = "localhost";
	protected String port = "1521";
	protected String dbname = "xe";
	protected String user = "system";
	protected String password = "manager";
	
	private static Logger logger = Logger.getLogger("DBAccessOracle");	
	private Connection conn;
	private PreparedStatement st = null;
	
	public Connection getConnection() throws SQLException{		
		try {
			Class.forName(ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "ClassNotFoundException: " + e.getMessage());
		}
		
//		String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbname;  //SID
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbname;  //SERVICE

		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

}
