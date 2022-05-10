import java.util.ArrayList;
import java.util.Random;

public class Battle {

	ArrayList<MilitaryUnit>[] planetArmy;
	ArrayList<MilitaryUnit>[] enemyArmy;
	
	ArrayList[][] armies; // REVISAR FUNCIONAMIENTO
	
	String battleDevolpment;
	
	int[][] initialCostFleet;
	
	int initialNumberUnitsPlanet, initialNumberUnitsEnemy;
	
	int[] wasteMetalDeuterium;
	
	int[] enemyDrops;
	int[] planetDrops;
	
	int[][] resourcesLoses;
	
	int[][] initialArmies;
	
	int[] actualNumberUnitsPlanet;
	int[] actualNumberUnitsEnemy;
	
	
	// REVISAR CONSTRUCOR
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		super();
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;
	}
	
	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return planetArmy;
	}
	public void setPlanetArmy(ArrayList<MilitaryUnit>[] planetArmy) {
		this.planetArmy = planetArmy;
	}
	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}
	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	public ArrayList[][] getArmies() {
		return armies;
	}
	public void setArmies(ArrayList[][] armies) {
		this.armies = armies;
	}
	public void setBattleDevolpment(String battleDevolpment) {
		this.battleDevolpment = battleDevolpment;
	}
	public int[][] getInitialCostFleet() {
		return initialCostFleet;
	}
	public void setInitialCostFleet(int[][] initialCostFleet) {
		this.initialCostFleet = initialCostFleet;
	}
	public int getInitialNumberUnitsPlanet() {
		return initialNumberUnitsPlanet;
	}
	public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
		this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
	}
	public int getInitialNumberUnitsEnemy() {
		return initialNumberUnitsEnemy;
	}
	public void setInitialNumberUnitsEnemy(int initialNumberUnitsEnemy) {
		this.initialNumberUnitsEnemy = initialNumberUnitsEnemy;
	}
	public int[] getWasteMetalDeuterium() {
		return wasteMetalDeuterium;
	}
	public void setWasteMetalDeuterium(int[] wasteMetalDeuterium) {
		this.wasteMetalDeuterium = wasteMetalDeuterium;
	}
	public int[] getEnemyDrops() {
		return enemyDrops;
	}
	public void setEnemyDrops(int[] enemyDrops) {
		this.enemyDrops = enemyDrops;
	}
	public int[] getPlanetDrops() {
		return planetDrops;
	}
	public void setPlanetDrops(int[] planetDrops) {
		this.planetDrops = planetDrops;
	}
	public int[][] getResourcesLoses() {
		return resourcesLoses;
	}
	public void setResourcesLoses(int[][] resourcesLoses) {
		this.resourcesLoses = resourcesLoses;
	}
	public int[][] getInitialArmies() {
		return initialArmies;
	}
	public void setInitialArmies(int[][] initialArmies) {
		this.initialArmies = initialArmies;
	}
	public int[] getActualNumberUnitsPlanet() {
		return actualNumberUnitsPlanet;
	}
	public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
		this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
	}
	public int[] getActualNumberUnitsEnemy() {
		return actualNumberUnitsEnemy;
	}
	public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
		this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
	}
	
	// METODOS PEDIDOS
	
	public String getBattleReport(int battles) {
		// POR HACER !!!!!
		return battleDevolpment;
	}
	
	public String getBattleDevolpment() {
		return battleDevolpment;
	}
	
	// COMPROBAR SI FUNCIONA CON ACESSO A LA BDD
	public void initInitialArmies() {
		for (int i = 0; i < armies.length; i++) {
			for (ArrayList<MilitaryUnit> flota : armies[i]) {
				System.out.println("Unidades Flota"+flota.size());
			
			System.out.println("Enemy Army ------");
			}
		}
	}
	
	public void resetArmyArmor() {
		for (int i = 0; i < planetArmy.length; i++) {
			ArrayList<MilitaryUnit> flota = planetArmy[i];
			for (MilitaryUnit militaryUnit : flota) {
				militaryUnit.resetArmor();
			}
		}
	}
	
	public int[] calcularActualUnitsPlanet() {
		int[] cant = {0,0,0,0,0,0,0};
		for (int i = 0; i < planetArmy.length; i++) {
			ArrayList<MilitaryUnit> flota = planetArmy[i];
			cant[i] = flota.size();
		}
		setActualNumberUnitsPlanet(cant); // COMPROBAR SI ES NECESARIO
		return cant;
	}
	
	public int[] calcularActualUnitsEnemy() {
		int[] cant = {0,0,0,0};
		for (int i = 0; i < enemyArmy.length; i++) {
			ArrayList<MilitaryUnit> flota = enemyArmy[i];
			cant[i] = flota.size();
		}
		setActualNumberUnitsEnemy(cant); // COMPROBAR SI ES NECESARIO
		return cant;
	}
	
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		int tipoArmy = army.length;
		int sumaTotal = 0;
		int categoria = 0 ;
		Random generador = new Random();
		if (tipoArmy == 7) {
			// En caso de que sea aliado
			int[] cantPlanetArmy = calcularActualUnitsPlanet();
			for (int i = 0; i < cantPlanetArmy.length; i++) {
				sumaTotal += cantPlanetArmy[i];
			}
			int numAleatorio = generador.nextInt(1,sumaTotal);
			for (int i = 0; i < cantPlanetArmy.length; i++) {
				if (cantPlanetArmy[i] >= numAleatorio) {
					categoria = i;
				}
			}
			return categoria;
		} else {
			// Army enemigo
			int[] cantEnemyArmy = calcularActualUnitsEnemy();
			for (int i = 0; i < cantEnemyArmy.length; i++) {
				sumaTotal += cantEnemyArmy[i];
			}
			int numAleatorio = generador.nextInt(1,sumaTotal);
			for (int i = 0; i < cantEnemyArmy.length; i++) {
				if (cantEnemyArmy[i] >= numAleatorio) {
					categoria = i;
				}
			}
			return categoria;
		}
	}

	public int getPlanetGroupAttacker() {
		int[] prob = Variables.CHANCE_ATTACK_PLANET_UNITS;
		int sumaTotal = 0;
		int categoria = 0 ;
		Random generador = new Random();
		
		
		
		for (int i = 0; i < prob.length; i++) {
			sumaTotal += prob[i];
		}
		int numAleatorio = generador.nextInt(1,sumaTotal);
		for (int i = 0; i < prob.length; i++) {
			if (prob[i] >= numAleatorio) {
				categoria = i;
			}
		}
		return categoria;
		
	}
	
	public int getEnemyGroupAttacker() {
		int[] prob = Variables.CHANCE_ATTACK_ENEMY_UNITS;
		int sumaTotal = 0;
		int categoria = 0 ;
		Random generador = new Random();
		
		
		
		for (int i = 0; i < prob.length; i++) {
			sumaTotal += prob[i];
		}
		int numAleatorio = generador.nextInt(1,sumaTotal);
		for (int i = 0; i < prob.length; i++) {
			if (prob[i] >= numAleatorio) {
				categoria = i;
			}
		}
		return categoria;
	}
	
	
	
	
	// BATALLA
	
	public void startBattle() {
		ArrayList<MilitaryUnit>[] atacante;
		ArrayList<MilitaryUnit>[] defensa;
		
		int grupoAtacante = 0, grupoDefensa, naveRandom;
		
		Random generador = new Random();
		
		int jugador = generador.nextInt(0,2);
		if (jugador == 0) {
			atacante = planetArmy;
			defensa = enemyArmy;
			grupoAtacante = getPlanetGroupAttacker();
		} else {
			atacante = enemyArmy;
			defensa = planetArmy;
			grupoAtacante = getEnemyGroupAttacker();
		}
		
		naveRandom = generador.nextInt(0,atacante[grupoAtacante].size() - 1);
		Ship naveAtacante = (Ship) atacante[grupoAtacante].get(naveRandom);
		
		grupoDefensa = getGroupDefender(defensa);
		naveRandom = generador.nextInt(0,defensa[grupoDefensa].size() - 1);
		Ship naveDefensa = (Ship) defensa[grupoDefensa].get(naveRandom);
		
		// El ataque baja el armor de la naveDefensa
		naveDefensa.takeDamage(naveAtacante.attack());
		
		// HACER QUE SE BORRE LA NAVE SI SE QUEDA SIN ARMOR
		
		// SI SE BORRA COMPROBAR ANTES SI SE GENERAN RESIDUIOS
		
		// SI SE GENERAN HACER EL CALCULO
		
		// HACER QUE SEA UN BUCLE EN CASO DE QUE ATAQUE DE NUEVO
		
		// METER TODO EN UN BUCLE MIENTRAS ALGUNO DE LOS DOS TENGA +20% DE LAS UNIDADES INICIALES
		
		
	}
	
//	public static void main(String[] args) {
//		
//		ConnectionBDD con = new ConnectionBDD();
//		
//		Planet planeta = new Planet();
//		planeta.setMetal(2000000);
//		planeta.setDeuterium(2000000);
//		try {
//			planeta.newArmoredShip(2);
//			planeta.newBattleShip(2);
//			planeta.newHeavyHunter(1);
//		} catch (ResourceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Planet planeta2 = new Planet();
//		planeta2.setMetal(2000000);
//		planeta2.setDeuterium(2000000);
//		try {
//			planeta2.newBattleShip(3);
//			planeta2.newLigthHunter(1);
//			planeta2.newHeavyHunter(2);
//		} catch (ResourceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Battle batalla = new Battle(planeta.getArmy(), planeta2.getArmy());
//		batalla.initInitialArmies();
//	}
		
}
