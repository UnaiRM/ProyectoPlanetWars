
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBDD {

	// PREGUNTAR SI PUEDES SER ESTATICA
	private Connection con;
	private String ip = "@192.168.40.2";
	private String usuario = "alumnoAMS8";
	private String contrasena = "alumnoAMS8";
	
	
	public ConnectionBDD() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:"+ip+":1521:orcl", usuario, contrasena);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean initalizeBDD() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call INITALIZE_04(0)}");
			cst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean resetBDD() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call INITALIZE_04(1)}");
			cst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
