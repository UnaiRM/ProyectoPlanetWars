import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	// Recursos para crear la flota enemiga
	// HACER METODO QUE LOS RESETEE Y AUMENTE A CADA BATALLA
	private int enemyMetal = Variables.METAL_BASE_ENEMY_ARMY;
	private int enemyDeuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;
	
	public boolean flagLogin = false;
	
	private int timeGeneration = 10000;
	
	private ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[7];

	public static void main(String[] args) {
		
		Main main = new Main();
		
		ConnectionBDD con = new ConnectionBDD();
		
		
		
		Login login = new Login();
		
		Planet planeta = new Planet();
		
		if (main.isFlagLogin()) {
			Timer time = new Timer();
			TimerTask autoIncrease = new TimerTask() {
				
				@Override
				public void run() {
					autoIncreaseResources(planeta);
					System.out.println(planeta.getMetal());
					System.out.println(planeta.getDeuterium());
				}
			};
			time.schedule(autoIncrease,0, main.getTimeGeneration());
		}
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




	public boolean isFlagLogin() {
		return flagLogin;
	}




	public static void setFlagLogin(boolean flagLogin) {
		flagLogin = flagLogin;
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
		
		ArrayList<MilitaryUnit>[] enemyArmyTemp = new ArrayList[7];
		
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
		for (int i = 0; i < 7; i++) {
			enemyArmyTemp[i] = new ArrayList<MilitaryUnit>();
		}
		
		Random generador = new Random();
		
		// Generador de tropas por probabilidad
		while (enemyMetal > costeMetalLightHunter && enemyDeuterium > costeDeuteriumLightHunter) {
			int numRandom = generador.nextInt(0,101);
			if (numRandom >= 0 && numRandom < 35) {
				enemyMetal -= costeMetalLightHunter;
				enemyDeuterium -= costeDeuteriumLightHunter;
				enemyArmyTemp[0].add(new LightHunter());
				System.out.println(enemyMetal);
				System.out.println(enemyDeuterium);
				System.out.println();
			} else if (numRandom >= 35 && numRandom < 60) {
				enemyMetal -= costeMetalHeavyHunter;
				enemyDeuterium -= costeDeuteriumHeavyHunter;
				enemyArmyTemp[1].add(new HeavyHunter());
				System.out.println(enemyMetal);
				System.out.println(enemyDeuterium);
				System.out.println();
			} else if (numRandom >= 60 && numRandom < 80) {
				enemyMetal -= costeMetalBattleShip;
				enemyDeuterium -= costeDeuteriumBattleShip;
				enemyArmyTemp[2].add(new BattleShip());
				System.out.println(enemyMetal);
				System.out.println(enemyDeuterium);
				System.out.println();
			} else if (numRandom >= 80 && numRandom < 100) {
				enemyMetal -= costeMetalArmoredShip;
				enemyDeuterium -= costeDeuteriumArmoredShip;
				enemyArmyTemp[3].add(new ArmoredShip());
				System.out.println(enemyMetal);
				System.out.println(enemyDeuterium);
				System.out.println();
			}
		}
		// Aumento de recursos
		
		System.out.println(enemyMetalTemp);
		System.out.println(enemyDeuteriumTemp);
		System.out.println();
		
		
		enemyMetal = (enemyMetalTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		enemyDeuterium = (enemyDeuteriumTemp * (100 + Variables.ENEMY_FLEET_INCREASE)) / 100;
		
		System.out.println(enemyMetal);
		System.out.println(enemyDeuterium);
		
		enemyArmy = enemyArmyTemp;
	}
	
	public String ViewThreat() {
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
		
		System.out.println("\nNEW THREAD COMING");
		System.out.println("\nLight Hunter "+LightHunter);
		System.out.println("\nHeavy Hunter " + HeavyHunter);
		System.out.println("\nBattle Ship " + BattleShip);
		System.out.println("\nArmored Ship " + ArmoredShip);
		
		String threat = "\nNEW THREAD COMING"+"\nLight Hunter "+LightHunter+"\nHeavy Hunter " + HeavyHunter + "\nBattle Ship " + BattleShip + "\nArmored Ship " + ArmoredShip;
		return threat;
	}
	
	public static void autoIncreaseResources(Planet planeta) {
		planeta.setMetal(planeta.getMetal() + Variables.PLANET_METAL_GENERATED);
		planeta.setDeuterium(planeta.getDeuterium() + Variables.PLANET_DEUTERIUM_GENERATED);
	}
	
}
