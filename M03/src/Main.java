import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	// Recursos para crear la flota enemiga
	
	private int enemyMetal = Variables.METAL_BASE_ENEMY_ARMY;
	private int enemyDeuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;
	
//	// CAMBIAR FLAGS DEL LOGIN A NO ESTATICAS
//	private boolean flagOn = true;
//	// Flags login
//	private static boolean flagLogin = true;
//	private static boolean flagTienePlanetas = false;
//	private static boolean flagNoTienePlanetas = false;
//	// Flags menu
//	private boolean flagMenuPrincipal = false;
//	private boolean flagMenuUpgrade = false;
//	private boolean flagMenuBuild = false;
//	private boolean flagMenuBattle = false;
//	// Flags build
//	private boolean flagBuildAttack = false;
//	private boolean flagBuildDefense = false;
	
	private int timeGeneration = 10000;
	
	private static ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[7];

	public static void main(String[] args) {
		
		Main main = new Main();
		
		// Inicia la flota enemiga vacia para evitar errores
		for (int i = 0; i < 7; i++) {
			enemyArmy[i] = new ArrayList<MilitaryUnit>();
		}
		
		ConnectionBDD con = new ConnectionBDD();
		
		
		Login login = new Login();
		
		
		
//		// Ventana Login y creacion/eleccion de planeta
//		
//		if (Main.isFlagLogin()) {
//			Login login = new Login();
//			while (Login.isFlagButton() == false) { // 	BUCLE PARA QUE EL PROGRAMA NO CONTINUE HASTA QUE SE HAYA HECHO UN LOGIN CORRECTO
////				System.out.println("");				//	POR ALGUN MOTIVO REQUIERE CODIGO SI O SI
//			}
//			Main.setFlagLogin(false);
//		}
//		
//		if (Main.isFlagNoTienePlanetas()) {
//			// Se crea un nuevo planeta
//			planeta = new Planet();
//			
//			// FALTA METER EL PROCEDIMIENTO NEXT_ID EN EL PAQUETE (!!!!!!!)
//			
//			// Se le busca una id nueva y se establece para todo el programa
//			ConnectionBDD.idPlaneta = ConnectionBDD.idNewPlanet();
//			// Se inserta el nuevo planeta
//			ConnectionBDD.insertarPlaneta(planeta);
//			MENU menu = new MENU();
//			Main.setFlagNoTienePlanetas(false);
//		} else if (Main.isFlagTienePlanetas()){
//			// Entra aqui sin problema
//			// HACER QUE SALGA LA INTERFAZ
//			planeta = new Planet(); // CAMBIAR AL OTRO CONSTRUCTOR
//			Main.setFlagTienePlanetas(false);
//		} else {
//			planeta = new Planet();
//		}
//		
//		Timer time= new Timer();
//		TimerTask tarea= new TimerTask() {
//			
//			public void run() {		
//			main.autoIncreaseResources(planeta);		
//			}
//		};
//		
//		TimerTask nuevaFlota = new TimerTask() {
//			
//			@Override
//			public void run() {
//				main.createEnemyArmy();
//			}
//		};
//		
//		// MIRAR DE HACER UNA TAREA QUE ATAQUE SOLA CADA 3 MINUTOS 
//		
//		time.schedule(tarea, 10000,10000); // 10 segundos
//		time.schedule(nuevaFlota, 120000, 120000); // 2 minutos
//		main.setFlagOn(true);
//		main.setFlagMenuPrincipal(true);
//		
//
//		
//		
//		while (main.isFlagOn()) {
//			System.out.println("");
//			if (main.isFlagMenuPrincipal()) {
//				MENU menu = new MENU();
//				while (main.isFlagMenuPrincipal()) {
//					System.out.println("");
//					if (menu.isFlagUpgradeButton()) {
//
//						main.setFlagMenuPrincipal(false);
//						main.setFlagMenuUpgrade(true);
//					} else if (menu.isFlagBuildButton()) {
//						main.setFlagMenuPrincipal(false);
//						main.setFlagMenuBuild(true);
//					} else if (menu.isFlagBattleButton()) {
//						main.setFlagMenuPrincipal(false);
//						main.setFlagMenuBattle(true);
//					}
//				}
//			} else if (main.isFlagMenuUpgrade()) {
//				Upgrade upgrade = new Upgrade(planeta);
//				while (main.isFlagMenuUpgrade()) {
//					System.out.println("");
//					if (upgrade.isFlagExit()) {
//						main.setFlagMenuUpgrade(false);
//						main.setFlagMenuPrincipal(true);
//					}
//				}
//			} else if (main.isFlagMenuBuild()) {
//				DefenseAttack defenseAttack = new DefenseAttack();
//				while (main.isFlagMenuBuild()) {
//					System.out.println("");
//					if (defenseAttack.isFlagAttack()) {
//						main.setFlagMenuBuild(false);
//						main.setFlagBuildAttack(true);
//					} else if (defenseAttack.isFlagDefense()) {
//						main.setFlagMenuBuild(false);
//						main.setFlagBuildDefense(true);
//					} else if (defenseAttack.isFlagExit()) {
//						main.setFlagMenuBuild(false);
//						main.setFlagMenuPrincipal(true);
//					}
//				}
//			} else if (main.isFlagBuildAttack()) {
//				System.out.println("buildAttack");
//			} else if (main.isFlagBuildDefense()) {
//				System.out.println("build defense");
//			}
//		
//		
//		}
		
	}
	
	
	
	
	




//	public boolean isFlagBuildAttack() {
//		return flagBuildAttack;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagBuildAttack(boolean flagBuildAttack) {
//		this.flagBuildAttack = flagBuildAttack;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagBuildDefense() {
//		return flagBuildDefense;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagBuildDefense(boolean flagBuildDefense) {
//		this.flagBuildDefense = flagBuildDefense;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagMenuBuild() {
//		return flagMenuBuild;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagMenuBuild(boolean flagMenuBuild) {
//		this.flagMenuBuild = flagMenuBuild;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagMenuBattle() {
//		return flagMenuBattle;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagMenuBattle(boolean flagMenuBattle) {
//		this.flagMenuBattle = flagMenuBattle;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagMenuUpgrade() {
//		return flagMenuUpgrade;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagMenuUpgrade(boolean flagMenuUpgrade) {
//		this.flagMenuUpgrade = flagMenuUpgrade;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagMenuPrincipal() {
//		return flagMenuPrincipal;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagMenuPrincipal(boolean flagMenuPrincipal) {
//		this.flagMenuPrincipal = flagMenuPrincipal;
//	}
//
//
//
//
//
//
//
//
//
//	public boolean isFlagOn() {
//		return flagOn;
//	}
//
//
//
//
//
//
//
//
//
//	public void setFlagOn(boolean flagOn) {
//		this.flagOn = flagOn;
//	}
//
//
//
//
//
//
//
//
//
//	public static boolean isFlagLogin() {
//		return flagLogin;
//	}
//
//
//
//
//
//
//
//
//
//	public static void setFlagLogin(boolean flagLogin) {
//		Main.flagLogin = flagLogin;
//	}
//
//
//
//
//
//
//
//
//
//	public static boolean isFlagTienePlanetas() {
//		return flagTienePlanetas;
//	}
//
//
//
//
//
//
//
//
//
//	public static void setFlagTienePlanetas(boolean flagTienePlanetas) {
//		Main.flagTienePlanetas = flagTienePlanetas;
//	}
//
//
//
//
//
//
//
//
//
//	public static boolean isFlagNoTienePlanetas() {
//		return flagNoTienePlanetas;
//	}
//
//
//
//
//
//
//
//
//
//	public static void setFlagNoTienePlanetas(boolean flagNoTienePlanetas) {
//		Main.flagNoTienePlanetas = flagNoTienePlanetas;
//	}









	public int getEnemyMetal() {
		return enemyMetal;
	}




	public void setEnemyMetal(int enemyMetal) {
		this.enemyMetal = enemyMetal;
	}




	public int getEnemyDeuterium() {
		return enemyDeuterium;
	}




	public void setEnemyDeuterium(int enemyDeuterium) {
		this.enemyDeuterium = enemyDeuterium;
	}



	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}




	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}


	


	public int getTimeGeneration() {
		return timeGeneration;
	}




	public void setTimeGeneration(int timeGeneration) {
		this.timeGeneration = timeGeneration;
	}




	public void createEnemyArmy(){
		
		int enemyMetalTemp = enemyMetal;
		int enemyDeuteriumTemp = enemyDeuterium;
		
		ArrayList<MilitaryUnit>[] enemyArmyTemp = new ArrayList[4];
		
		// Saca todos los precios
		
		int costeMetalLightHunter = ConnectionBDD.getShipMetalCost(1);
		int costeDeuteriumLightHunter = ConnectionBDD.getShipDeuteriumCost(1);
		
		int costeMetalHeavyHunter = ConnectionBDD.getShipMetalCost(2);
		int costeDeuteriumHeavyHunter = ConnectionBDD.getShipDeuteriumCost(2);
		
		int costeMetalBattleShip = ConnectionBDD.getShipMetalCost(3);
		int costeDeuteriumBattleShip = ConnectionBDD.getShipDeuteriumCost(3);
		
		int costeMetalArmoredShip = ConnectionBDD.getShipMetalCost(4);
		int costeDeuteriumArmoredShip = ConnectionBDD.getShipDeuteriumCost(4);
		
		// Inicializa el array
		for (int i = 0; i < 4; i++) {
			enemyArmyTemp[i] = new ArrayList<MilitaryUnit>();
		}
		
		Random generador = new Random();
		
		// Generador de tropas por probabilidad
		while (enemyMetal > costeMetalLightHunter && enemyDeuterium > costeDeuteriumLightHunter) {
			int numRandom = generador.nextInt(0,100);
			if (numRandom >= 0 && numRandom < 35) {
				enemyMetal -= costeMetalLightHunter;
				enemyDeuterium -= costeDeuteriumLightHunter;
				enemyArmyTemp[0].add(new LightHunter());
			} else if (numRandom >= 35 && numRandom < 60) {
				enemyMetal -= costeMetalHeavyHunter;
				enemyDeuterium -= costeDeuteriumHeavyHunter;
				enemyArmyTemp[1].add(new HeavyHunter());
			} else if (numRandom >= 60 && numRandom < 80) {
				enemyMetal -= costeMetalBattleShip;
				enemyDeuterium -= costeDeuteriumBattleShip;
				enemyArmyTemp[2].add(new BattleShip());
			} else if (numRandom >= 80 && numRandom < 100) {
				enemyMetal -= costeMetalArmoredShip;
				enemyDeuterium -= costeDeuteriumArmoredShip;
				enemyArmyTemp[3].add(new ArmoredShip());
			}
		}
		// Aumento de recursos
		
		enemyMetal = (enemyMetalTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		enemyDeuterium = (enemyDeuteriumTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		
		enemyArmy = enemyArmyTemp;
	}
	
	public static String ViewThreat() {
		int cantidad = 0;
		int LightHunter = 0, HeavyHunter = 0, BattleShip = 0, ArmoredShip = 0, MissileLauncher = 0, IonCannon = 0, PlasmaCannon;
		for (int i = 0; i < enemyArmy.length; i++) {
			ArrayList<MilitaryUnit> flota = enemyArmy[i];
			cantidad = flota.size();
			switch (i) {
			case 0:
				LightHunter = cantidad;
				break;
			case 1:
				HeavyHunter = cantidad;
				break;
			case 2:
				BattleShip = cantidad;
				break;
			case 3:
				ArmoredShip = cantidad;
				break;
			default:
				break;
			}
		}	
		String threat = "\nNEW THREAD COMING"+"\nLight Hunter "+LightHunter+"\nHeavy Hunter " + HeavyHunter + "\nBattle Ship " + BattleShip + "\nArmored Ship " + ArmoredShip;
		return threat;
	}
	
	public void autoIncreaseResources(Planet planeta) {
		planeta.setMetal(planeta.getMetal() + Variables.PLANET_METAL_GENERATED);
		planeta.setDeuterium(planeta.getDeuterium() + Variables.PLANET_DEUTERIUM_GENERATED);
	}
	
}
