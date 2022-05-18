import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	// Recursos para crear la flota enemiga
	
	private static int enemyMetal = Variables.METAL_BASE_ENEMY_ARMY;
	private static int enemyDeuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;
	
	private int timeGeneration = 10000;
	
	private static ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[7];
	
	
	private static String battleDevelopment = "";

	public static void main(String[] args) {
		
		Main main = new Main();
		
		ConnectionBDD con = new ConnectionBDD();
		
		Login login = new Login();
		
		
	}
	

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



	public static ArrayList<MilitaryUnit>[] getEnemyArmy() {
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




	public static void createEnemyArmy(){
		
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
				LightHunter nave = new LightHunter();
				nave.setArmorAndDamage(0, 0);
				enemyArmyTemp[0].add(nave);

			} else if (numRandom >= 35 && numRandom < 60) {
				enemyMetal -= costeMetalHeavyHunter;
				enemyDeuterium -= costeDeuteriumHeavyHunter;
				HeavyHunter nave = new HeavyHunter();
				nave.setArmorAndDamage(0, 0);
				enemyArmyTemp[1].add(nave);
			} else if (numRandom >= 60 && numRandom < 80) {
				enemyMetal -= costeMetalBattleShip;
				enemyDeuterium -= costeDeuteriumBattleShip;
				BattleShip nave = new BattleShip();
				nave.setArmorAndDamage(0, 0);
				enemyArmyTemp[2].add(nave);
			} else if (numRandom >= 80 && numRandom < 100) {
				enemyMetal -= costeMetalArmoredShip;
				enemyDeuterium -= costeDeuteriumArmoredShip;
				ArmoredShip nave = new ArmoredShip();
				nave.setArmorAndDamage(0, 0);
				enemyArmyTemp[3].add(nave);
			}
		}
		// Aumento de recursos
		
		enemyMetal = (enemyMetalTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		enemyDeuterium = (enemyDeuteriumTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		
		enemyArmy = enemyArmyTemp;
	}
	
	public static String ViewThreat() {
		int cantidad = 0;
		int LightHunter = 0, HeavyHunter = 0, BattleShip = 0, ArmoredShip = 0;
		for (int i = 0; i < 4; i++) {
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
		String threat = "<html><body>NEW THREAT COMING"+"<br>Light Hunter "+LightHunter+"<br>Heavy Hunter " + HeavyHunter + "<br>Battle Ship " + BattleShip + "<br>Armored Ship " + ArmoredShip+"<body><html>";
		return threat;
	}
	
	public void autoIncreaseResources(Planet planeta) {
		planeta.setMetal(planeta.getMetal() + Variables.PLANET_METAL_GENERATED);
		planeta.setDeuterium(planeta.getDeuterium() + Variables.PLANET_DEUTERIUM_GENERATED);
	}


	public static String getBattleDevelopment() {
		return battleDevelopment;
	}


	public static void setBattleDevelopment(String battleDevelopment) {
		Main.battleDevelopment = battleDevelopment;
	}
	
}
