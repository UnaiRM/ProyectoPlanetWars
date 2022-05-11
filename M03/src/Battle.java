import java.util.ArrayList;
import java.util.Random;

public class Battle {

	private ArrayList<MilitaryUnit>[] planetArmy;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	
	private ArrayList[][] armies = {planetArmy,enemyArmy};; // REVISAR FUNCIONAMIENTO
	
	private String battleDevolpment;
	
	private int[][] initialCostFleet;
	
	private int initialNumberUnitsPlanet, initialNumberUnitsEnemy;
	
	private int[] wasteMetalDeuterium;
	
	private int[] enemyDrops;
	private int[] planetDrops;
	
	private int[][] resourcesLoses;
	
	private int[][] initialArmies;
	
	private int[] actualNumberUnitsPlanet;
	private int[] actualNumberUnitsEnemy;
	
	
	// REVISAR CONSTRUCOR
	public Battle(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
		super();
		this.planetArmy = planetArmy;
		this.enemyArmy = enemyArmy;
		
		ArrayList[][] armiesTemp = {planetArmy,enemyArmy};
		this.armies = armiesTemp;
		
		int[][] initialArmiesTemp = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
		this.initialArmies = initialArmiesTemp;
		initInitialArmies();
		this.actualNumberUnitsEnemy = this.initialArmies[0];
		this.actualNumberUnitsPlanet = this.initialArmies[1];
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
			for (int j = 0; j < armies[i].length; j++) {
				initialArmies[i][j] = armies[i][j].size();
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
		for (int i = 0; i < armies[0].length; i++) {
			ArrayList<MilitaryUnit> flota = armies[0][i];
			cant[i] = flota.size();
		}

		return cant;
	}
	
	public int[] calcularActualUnitsEnemy() {
		int[] cant = {0,0,0,0};
		for (int i = 0; i < 4; i++) {
			ArrayList<MilitaryUnit> flota = armies[1][i];
			cant[i] = flota.size();
		}

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
			int total = 0;
			for (int i = 0; i < cantPlanetArmy.length; i++) {
				total += cantPlanetArmy[i];
				if (total >= numAleatorio) {
					categoria = i;
					break;
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
			int total = 0;
			for (int i = 0; i < cantEnemyArmy.length; i++) {
				total += cantEnemyArmy[i];
				if (total >= numAleatorio) {
					categoria = i;
					break;
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
		int total = 0;
		for (int i = 0; i < prob.length; i++) {
			total += prob[i];
			if (total >= numAleatorio) {
				categoria = i;
				break;
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
		int total = 0;
		for (int i = 0; i < prob.length; i++) {
			total += prob[i];
			if (total >= numAleatorio) {
				categoria = i;
				break;
			}
		}
		return categoria;
	}
	
	public int probabilityByShip(Ship nave) {
		if (nave instanceof LightHunter) {
			return Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER;
		} else if (nave instanceof HeavyHunter) {
			return Variables.CHANCE_ATTACK_AGAIN_HEAVYHUNTER;
		} else if (nave instanceof BattleShip) {
			return Variables.CHANCE_ATTACK_AGAIN_BATTLESHIP;
		} else if (nave instanceof ArmoredShip) {
			return Variables.CHANCE_ATTACK_AGAIN_ARMOREDSHIP;
		} else if (nave instanceof MissileLauncher) {
			return Variables.CHANCE_ATTACK_AGAIN_MISSILELAUNCHER;
		} else if (nave instanceof IonCannon) {
			return Variables.CHANCE_ATTACK_AGAIN_IONCANNON;
		} else if (nave instanceof PlasmaCannon) {
			return Variables.CHANCE_ATTACK_AGAIN_PLASMACANNON;
		} else {
			return 0;
		}
	}
	
	// BATALLA
	
	public void startBattle() {
		
		ArrayList<MilitaryUnit>[] atacante;
		ArrayList<MilitaryUnit>[] defensa;
		
		int grupoAtacante = 0, grupoDefensa, naveRandom, naveRandom2;
		String naveAtancante, naveDefensora;
		int ataque = 0, armor = 0;
		
		Random generador = new Random();
		
		int initialNumEnemy = 0, initialNumPlanet = 0;
		for (int i = 0; i < actualNumberUnitsEnemy.length; i++) {
			initialNumEnemy += actualNumberUnitsEnemy[i];
		}
		for (int i = 0; i < actualNumberUnitsPlanet.length; i++) {
			initialNumPlanet += actualNumberUnitsPlanet[i];
		}
		
		this.initialNumberUnitsEnemy = initialNumEnemy;
		this.initialNumberUnitsPlanet = initialNumPlanet;
		
		int jugador = generador.nextInt(0,2);
		
		int actualNumPlanet = initialNumPlanet, actualNumEnemy = initialNumEnemy;
		int minimoUnidadesPlanet = (int) (initialNumPlanet * 0.2);
		int minimoUnidadesEnemy = (int) (initialNumEnemy * 0.2);
		
		System.out.println("Cantidad inicial flota Planet: "+initialNumPlanet);
		System.out.println("Cantidad inicial flota Enemy: "+initialNumEnemy);
		System.out.println("Minimo planet: "+ minimoUnidadesPlanet);
		System.out.println("Minimo Enemy: "+minimoUnidadesEnemy);
		System.out.println("Actual planet: "+ actualNumPlanet);
		System.out.println("Actual enemy: "+ actualNumEnemy);

		while (actualNumPlanet > minimoUnidadesPlanet && actualNumEnemy > minimoUnidadesEnemy) {
			// TURNO
			// Se establece que flota ataca y que flota defiende
			
			System.out.println("jugador: "+jugador);
			if (jugador == 0) {
				atacante = armies[0];
				defensa = armies[1];
				
			} else {
				atacante = armies[1];
				defensa = armies[0];
				
			}
			// ATAQUE
			boolean attackAgain = true;
			while (attackAgain) {
				attackAgain = false;
				
				grupoAtacante = getEnemyGroupAttacker();
				while (atacante[grupoAtacante].size() < 1) {
					if (jugador == 0) {
						grupoAtacante = getPlanetGroupAttacker();
					} else {
						grupoAtacante = getEnemyGroupAttacker();
					}
					
				}
				
				naveRandom = generador.nextInt(0,atacante[grupoAtacante].size());
				
				grupoDefensa = getGroupDefender(defensa);
				while (defensa[grupoDefensa].size() < 1) {
					grupoDefensa = getGroupDefender(defensa);
				}
				naveRandom2 = generador.nextInt(0,defensa[grupoDefensa].size());
				
				// HACER UN SWITCH PARA GUARDAR QUE TIPO DE NAVE ATACA Y DEFIENDE
				
				
				ataque = atacante[grupoAtacante].get(naveRandom).attack(); // Para report
				
				// El ataque baja el armor de la naveDefensa
				defensa[grupoDefensa].get(naveRandom2).takeDamage(ataque);

				armor = defensa[grupoDefensa].get(naveRandom2).getActualArmor(); // Para report
				
				// HACER QUE SE BORRE LA NAVE SI SE QUEDA SIN ARMOR
				if (armor <= 0) {
					// SI SE BORRA COMPROBAR ANTES SI SE GENERAN RESIDUIOS
					
					// SI SE GENERAN HACER EL CALCULO
					defensa[grupoDefensa].remove(naveRandom2);
					System.out.println("Nave eliminada");
					break;
				}
				
				int probAttackAgain = probabilityByShip((Ship) atacante[grupoAtacante].get(naveRandom));
				int numAleatorio = generador.nextInt(0,100);
				if (numAleatorio <= probAttackAgain) {
					attackAgain = true;
					System.out.println("Ataque de nuevo");
				}
				this.actualNumberUnitsEnemy = calcularActualUnitsEnemy();
				this.actualNumberUnitsPlanet = calcularActualUnitsPlanet();
			}
			
			// REVISAR PORQUE SE SALTA ESTO EN EL ULTIMO TURNO
			actualNumEnemy = 0;
			for (int i = 0; i < actualNumberUnitsEnemy.length; i++) {
				actualNumEnemy += actualNumberUnitsEnemy[i];
			}
			actualNumPlanet = 0;
			for (int i = 0; i < actualNumberUnitsPlanet.length; i++) {
				actualNumPlanet += actualNumberUnitsPlanet[i];
			}
			System.out.println("Cantidad actual Planeta: "+actualNumPlanet);
			System.out.println("Cantidad actual Enemy: "+actualNumEnemy);
			System.out.println();
			if (jugador == 0) {
				jugador = 1;
			} else {
				jugador = 0;
			}
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		ConnectionBDD con = new ConnectionBDD();
		
		Planet planeta = new Planet();
		planeta.setMetal(2000000);
		planeta.setDeuterium(2000000);
		try {
			planeta.newBattleShip(3);
			planeta.newLigthHunter(1);
			planeta.newHeavyHunter(5);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Planet planetaEnemy = new Planet();
		planetaEnemy.setMetal(2000000);
		planetaEnemy.setDeuterium(2000000);
		try {
			planetaEnemy.newBattleShip(3);
			planetaEnemy.newLigthHunter(1);
			planetaEnemy.newHeavyHunter(5);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Battle batalla = new Battle(planeta.getArmy(),planetaEnemy.getArmy());
		batalla.startBattle();
	}
		
}
