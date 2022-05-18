
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionBDD {

	// PREGUNTAR SI PUEDE SER ESTATICA
	private static Connection con;
	private String ip = "@192.168.40.2"; //"@192.168.40.2" instituto "@192.168.56.101" casa
	private String usuario = "alumnoAMS8";
	private String contrasena = "alumnoAMS8";
	private String tipo = "orcl"; // "orcl" instituto "xe" casa
	
	// CONSTANTES PARA EL PROGRAMA
	static int idUsuario = 0;
	static int idPlaneta = 0;
	
	
	public ConnectionBDD() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:"+ip+":1521:"+tipo, usuario, contrasena);
			System.out.println("Conexion creada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static Connection getCon() {
		return con;
	}



	public static void setCon(Connection con) {
		ConnectionBDD.con = con;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public static int getIdUsuario() {
		return idUsuario;
	}



	public static void setIdUsuario(int idUsuario) {
		ConnectionBDD.idUsuario = idUsuario;
	}



	public static int getIdPlaneta() {
		return idPlaneta;
	}



	public static void setIdPlaneta(int idPlaneta) {
		ConnectionBDD.idPlaneta = idPlaneta;
	}


	public static int newUser(String user, String password) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.INSERT_USER(?,?,?)}");
			cst.setString(1, user);
			cst.setString(2, password);
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.execute();
			
			int res = cst.getInt(3);
			
			cst.close();
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	

	public static boolean initalizeBDD() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.INITIALIZE_04(0)}");
			cst.execute();
			cst.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean resetBDD() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.INITIALIZE_04(1)}");
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
			cst = con.prepareCall("{call PLANET_WARS.GET_SHIP_06(?,?,?,?,?,?,?,?,?,?)}");
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
			cst = con.prepareCall("{call PLANET_WARS.GET_SHIP_06(?,?,?,?,?,?,?,?,?,?)}");
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
			cst = con.prepareCall("{call PLANET_WARS.GET_DEFENSE_05(?,?,?,?,?,?,?,?,?,?)}");
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
			cst = con.prepareCall("{call PLANET_WARS.GET_DEFENSE_05(?,?,?,?,?,?,?,?,?,?)}");
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
	
	public static String[] loginProcedure(String user, String password) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.LOGIN(?,?,?,?)}");
			cst.setString(1, user);
			cst.setString(2, password);
			
			cst.registerOutParameter(3, java.sql.Types.INTEGER);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			cst.execute();
			
			String idUsuario = String.valueOf(cst.getInt(3));
			String idPlanetas = cst.getString(4);
			cst.close();
			String resultado[] = {idUsuario, idPlanetas};
			return resultado;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String resultado[] = {"",""};
			return resultado;
		}
		
	}
	
	public static int idNewPlanet() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.NEXT_ID(?)}");
			cst.registerOutParameter(1, java.sql.Types.INTEGER);
			cst.execute();
			
			int idNewPlanet = cst.getInt(1);
			cst.close();
			return idNewPlanet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void insertarPlaneta(Planet planeta) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.INSERT_PLANET(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, ConnectionBDD.idPlaneta);
			cst.setInt(2, ConnectionBDD.idUsuario);
			cst.setString(3, "Planeta "+ConnectionBDD.idPlaneta);
			cst.setInt(4, planeta.getTechnologyAttack());
			cst.setInt(5, planeta.getTechnologyDefense());
			cst.setInt(6, planeta.getUpgradeDefenseTechnologyDeuteriumCost());
			cst.setInt(7, planeta.getUpgradeAttackTechnologyDeuteriumCost());
			cst.setInt(8, 0);
			cst.setInt(9, planeta.getMetal());
			cst.setInt(10, planeta.getDeuterium());
			
			cst.execute();
			
			cst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updatePlaneta(Planet planeta) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.UPDATE_PLANET(?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, idPlaneta);
			cst.setString(2, "Planeta "+ConnectionBDD.idPlaneta);
			cst.setInt(3, planeta.getTechnologyAttack());
			cst.setInt(4, planeta.getTechnologyDefense());
			cst.setInt(5, planeta.getUpgradeDefenseTechnologyDeuteriumCost());
			cst.setInt(6, planeta.getUpgradeAttackTechnologyDeuteriumCost());
			cst.setInt(7, 0);
			cst.setInt(8, planeta.getMetal());
			cst.setInt(9, planeta.getDeuterium());
			
			cst.execute();
			
			cst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateArmy(Planet planeta) {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.DELETE_USER_SHIP(?)}");
			cst.setInt(1, idPlaneta);
			cst.execute();
			
			ArrayList<MilitaryUnit>[] army = planeta.getArmy();
			ArrayList<String> navesAtaque = new ArrayList<String>();
			
			
			for (int i = 0; i < 4; i++) {
				for (MilitaryUnit unidad : army[i]) {
					if (unidad instanceof LightHunter) {
						navesAtaque.add("1,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					} else if (unidad instanceof HeavyHunter) {
						navesAtaque.add("2,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					} else if (unidad instanceof BattleShip) {
						navesAtaque.add("3,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					} else if (unidad instanceof ArmoredShip) {
						navesAtaque.add("4,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					}
				}
			}
			
			ArrayList<String> navesAtaqueCalculadas = new ArrayList<String>();
			String temp = "";
			String temp2 = "";
			int cnt = 1;
			int cnt2 = 0;
			for (String string : navesAtaque) {
				if (cnt2 == 0) {
					temp = string;
				} else if (cnt2 == navesAtaque.size() - 1){
					cnt++;
					temp2 = temp.charAt(0) +","+ temp.charAt(2)+","+temp.charAt(4)+","+cnt;
					navesAtaqueCalculadas.add(temp2);
				} else if (string.equalsIgnoreCase(temp)) {
					cnt++;
				} else {
					temp2 = temp.charAt(0) +","+ temp.charAt(2)+","+temp.charAt(4)+","+cnt;
					navesAtaqueCalculadas.add(temp2);
					temp = string;
					cnt = 1;
				}
				cnt2++;
			}
			
			cst.close();
//			cst = con.prepareCall("{call PLANET_WARS.INSERT_PLANET_SHIP(?,?,?,?,?)}");

			PreparedStatement ps;
			ps = con.prepareStatement("insert into PLANET_SHIP values (?,?,?,?,?)");
			for (String string : navesAtaqueCalculadas) {
				// 1,2,5,0,0
				ps.setInt(1, idPlaneta);
				ps.setInt(2, Character.getNumericValue(string.charAt(0)));
				ps.setInt(3, Character.getNumericValue(string.charAt(6)));
				ps.setInt(4, Character.getNumericValue(string.charAt(4)));
				ps.setInt(5, Character.getNumericValue(string.charAt(2)));
				ps.addBatch();
//				System.out.println(ps.execute());
				ps.clearParameters();
//				ps.clearParameters();
			}
			ps.executeBatch();
			ps.close();
			
			
			ArrayList<String> navesDefensa = new ArrayList<String>();
			
			for (int i = 4; i < 7; i++) {
				for (MilitaryUnit unidad : army[i]) {
					if (unidad instanceof MissileLauncher) {
						navesDefensa.add("1,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					} else if (unidad instanceof IonCannon) {
						navesDefensa.add("2,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					} else if (unidad instanceof PlasmaCannon) {
						navesDefensa.add("3,"+unidad.getDefenseLevel()+","+unidad.getAttackLevel());
					}
				}
			}
			
			ArrayList<String> navesDefensaCalculadas = new ArrayList<String>();
			temp = "";
			temp2 = "";
			cnt = 1;
			cnt2 = 0;
			for (String string : navesDefensa) {
				if (cnt2 == 0) {
					temp = string;
				} else if (cnt2 == navesDefensa.size() - 1){
					cnt++;
					temp2 = temp.charAt(0) +","+ temp.charAt(2)+","+temp.charAt(4)+","+cnt;
					navesDefensaCalculadas.add(temp2);
				} else if (string.equalsIgnoreCase(temp)) {
					cnt++;
				} else {
					temp2 = temp.charAt(0) +","+ temp.charAt(2)+","+temp.charAt(4)+","+cnt;
					navesDefensaCalculadas.add(temp2);
					temp = string;
					cnt = 1;
				}
				cnt2++;
			}
			
//			cst = con.prepareCall("{call PLANET_WARS.INSERT_PLANET_SHIP(?,?,?,?,?)}");

			PreparedStatement ps2;
			ps2 = con.prepareStatement("insert into PLANET_DEFENSE values (?,?,?,?,?)");
			for (String string : navesDefensaCalculadas) {
				// 1,2,5,0,0
				ps2.setInt(1, idPlaneta);
				ps2.setInt(2, Character.getNumericValue(string.charAt(0)));
				ps2.setInt(3, Character.getNumericValue(string.charAt(6)));
				ps2.setInt(4, Character.getNumericValue(string.charAt(4)));
				ps2.setInt(5, Character.getNumericValue(string.charAt(2)));
				ps2.addBatch();
//				System.out.println(ps.execute());
				ps2.clearParameters();
//				ps.clearParameters();
			}
			ps2.executeBatch();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String infoPlanets(String idPlanetas) {
		ArrayList idsConvertidas = new ArrayList<>();
		
		for (int i = 0; i < idPlanetas.length(); i++) {
			if (i % 2 == 0) {
				idsConvertidas.add(idPlanetas.charAt(i));
			}
		}
		
		String salida = "<html><body>";
		
		for (Object object : idsConvertidas) {
			salida += String.valueOf(object)+") Planeta "+String.valueOf(object)+"<br>";
		}
		
		salida += "<body><html>";
		return salida;
	}
	
	public static Planet loadPlanet() {
		CallableStatement cst;
		try {
			cst = con.prepareCall("{call PLANET_WARS.GET_PLANET(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, idPlaneta);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.registerOutParameter(4, java.sql.Types.INTEGER);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.INTEGER);
			cst.registerOutParameter(7, java.sql.Types.INTEGER);
			cst.registerOutParameter(8, java.sql.Types.INTEGER);
			cst.registerOutParameter(9, java.sql.Types.INTEGER);
			cst.registerOutParameter(10, java.sql.Types.INTEGER);
			cst.execute();
			
			
			// SACAR LA FLOTA 
			ArrayList<MilitaryUnit>[] army = loadArmy();
			
			
			
			Planet planeta = new Planet(cst.getInt(5), cst.getInt(4), cst.getInt(9), cst.getInt(10), cst.getInt(6), cst.getInt(7), army);
			cst.close();
			return planeta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Planet planeta = new Planet();
			return planeta;
		}
	}
	
	public static ArrayList<MilitaryUnit>[] loadArmy(){
		ArrayList<MilitaryUnit>[] army = new ArrayList[7];
		for (int i = 0; i < 7; i++) {
			army[i] = new ArrayList<MilitaryUnit>();
		}
		
		CallableStatement cst;
		String res = "";
		
		try {
			cst = con.prepareCall("{call PLANET_WARS.RETURN_PLANET_SHIP(?,?)}");
			cst.setInt(1, idPlaneta);
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.execute();
			
			res = cst.getString(2);
			
			cst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (res != null) {
			String[] navesAtaque = res.split(";");
			
			for (int i = 0; i < navesAtaque.length; i++) {
				for (int j = 0; j < Character.getNumericValue(navesAtaque[i].charAt(2)); j++) {
					if (Character.getNumericValue(navesAtaque[i].charAt(0)) == 1) {
						LightHunter nave = new LightHunter();
						nave.setArmorAndDamage(Character.getNumericValue(navesAtaque[i].charAt(6)), Character.getNumericValue(navesAtaque[i].charAt(4)));
						army[0].add(nave);
					} else if (Character.getNumericValue(navesAtaque[i].charAt(0)) == 2) {
						HeavyHunter nave = new HeavyHunter();
						nave.setArmorAndDamage(Character.getNumericValue(navesAtaque[i].charAt(6)), Character.getNumericValue(navesAtaque[i].charAt(4)));
						army[1].add(nave);
					} else if (Character.getNumericValue(navesAtaque[i].charAt(0)) == 3) {
						BattleShip nave = new BattleShip();
						nave.setArmorAndDamage(Character.getNumericValue(navesAtaque[i].charAt(6)), Character.getNumericValue(navesAtaque[i].charAt(4)));
						army[2].add(nave);
					} else if (Character.getNumericValue(navesAtaque[i].charAt(0)) == 4) {
						ArmoredShip nave = new ArmoredShip();
						nave.setArmorAndDamage(Character.getNumericValue(navesAtaque[i].charAt(6)), Character.getNumericValue(navesAtaque[i].charAt(4)));
						army[3].add(nave);
					}
				}
			}
		}
		
		
		
		CallableStatement cst2;
		String res2 = "";
		
		try {
			cst2 = con.prepareCall("{call PLANET_WARS.RETURN_PLANET_DEFENSE(?,?)}");
			cst2.setInt(1, idPlaneta);
			cst2.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst2.execute();
			
			res2 = cst2.getString(2);
			
			cst2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (res2 != null) {
			String[] navesDefensa = res2.split(";");
			
			for (int i = 0; i < navesDefensa.length; i++) {
				for (int j = 0; j < Character.getNumericValue(navesDefensa[i].charAt(2)); j++) {
					if (Character.getNumericValue(navesDefensa[i].charAt(0)) == 1) {
						MissileLauncher nave = new MissileLauncher();
						nave.setArmorAndDamage(Character.getNumericValue(navesDefensa[i].charAt(6)), Character.getNumericValue(navesDefensa[i].charAt(4)));
						army[4].add(nave);
					} else if (Character.getNumericValue(navesDefensa[i].charAt(0)) == 2) {
						IonCannon nave = new IonCannon();
						nave.setArmorAndDamage(Character.getNumericValue(navesDefensa[i].charAt(6)), Character.getNumericValue(navesDefensa[i].charAt(4)));
						army[5].add(nave);
					} else if (Character.getNumericValue(navesDefensa[i].charAt(0)) == 3) {
						PlasmaCannon nave = new PlasmaCannon();
						nave.setArmorAndDamage(Character.getNumericValue(navesDefensa[i].charAt(6)), Character.getNumericValue(navesDefensa[i].charAt(4)));
						army[6].add(nave);
					}
				}
			}
		}
		
		return army;
	}
	
}
