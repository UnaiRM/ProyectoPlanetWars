
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

	// PREGUNTAR SI PUEDE SER ESTATICA
	private static Connection con;
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
			cst.close();
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
			cst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static int getShipMetalCost(int id) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call GET_SHIP_06(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.INTEGER);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);
			cst.execute();
			
			int metalCost = cst.getInt(3);
			cst.close();
			return metalCost;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int getShipDeuteriumCost(int id) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call GET_SHIP_06(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.INTEGER);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);
			cst.execute();
			
			int deuteriumCost = cst.getInt(5);
			cst.close();
			return deuteriumCost;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int getDefenseMetalCost(int id) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call GET_DEFENSE_05(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.INTEGER);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);
			cst.execute();
			
			int metalCost = cst.getInt(3);
			cst.close();
			return metalCost;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int getDefenseDeuteriumCost(int id) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call GET_DEFENSE_05(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.INTEGER);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);
			cst.execute();
			
			int deuteriumCost = cst.getInt(3);
			cst.close();
			return deuteriumCost;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int loginProcedure(String user, String password) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call LOGIN(?,?,?)}");
			cst.setString(1, user);
			cst.setString(2, password);
			
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			
			cst.execute();
			
			int resultado = cst.getInt(3);
			cst.close();
			return resultado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		}
	
	}
	
}
