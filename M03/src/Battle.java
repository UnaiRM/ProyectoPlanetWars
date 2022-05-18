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
	
	private int[] enemyDrops = {0,0,0,0,0,0,0};
	private int[] planetDrops = {0,0,0,0,0,0,0};
	
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
		this.actualNumberUnitsEnemy = this.initialArmies[1]; // Mirar de cambiar esto a 0 otra vez
		this.actualNumberUnitsPlanet = this.initialArmies[0];
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
		int[] cant = {0,0,0,0,0,0,0};
		for (int i = 0; i < armies[1].length; i++) {
			ArrayList<MilitaryUnit> flota = armies[1][i];
			cant[i] = flota.size();
		}

		return cant;
	}
	
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		int sumaTotal = 0;
		int categoria = 0 ;
		Random generador = new Random();
		
		// En caso de que sea aliado
//		int[] cantPlanetArmy = calcularActualUnitsPlanet();
		int[] cantPlanetArmy = {0,0,0,0,0,0,0};
		for (int i = 0; i < army.length; i++) {
			ArrayList<MilitaryUnit> flota = army[i];
			
			System.out.println("Cant grupo "+i+": "+flota.size());

			cantPlanetArmy[i] = flota.size();
		}
		
		for (int i = 0; i < cantPlanetArmy.length; i++) {
			sumaTotal += cantPlanetArmy[i];
		}
		System.out.println("SumaTotal: "+sumaTotal);
		int numAleatorio = generador.nextInt(0,sumaTotal+1);
		System.out.println("Num aleatorio: "+numAleatorio);
		while (numAleatorio == 0) {
			System.out.println("Num aleatorio: "+numAleatorio);
			numAleatorio = generador.nextInt(0,sumaTotal+1);
			break;
		}
		
		int total = 0;
		for (int i = 0; i < cantPlanetArmy.length; i++) {
			System.out.println("Total: "+total);
			total += cantPlanetArmy[i];
			if (total >= numAleatorio) {
				categoria = i;
				break;
			}
		}
		return categoria;
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
	
	public int[] probabilityWasteByShip(Ship nave) {
		if (nave instanceof LightHunter) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(1),ConnectionBDD.getDefenseMetalCost(1),Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER};
			return probRecursos;
		} else if (nave instanceof HeavyHunter) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(2),ConnectionBDD.getDefenseMetalCost(2),Variables.CHANCE_GENERATNG_WASTE_HEAVYHUNTER};
			return probRecursos;
		} else if (nave instanceof BattleShip) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(3),ConnectionBDD.getDefenseMetalCost(3),Variables.CHANCE_GENERATNG_WASTE_BATTLESHIP};
			return probRecursos;
		} else if (nave instanceof ArmoredShip) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(4),ConnectionBDD.getDefenseMetalCost(4),Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP};
			return probRecursos;
		} else if (nave instanceof MissileLauncher) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(5),ConnectionBDD.getDefenseMetalCost(5),Variables.CHANCE_GENERATNG_WASTE_MISSILELAUNCHER};
			return probRecursos;
		} else if (nave instanceof IonCannon) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(6),ConnectionBDD.getDefenseMetalCost(6),Variables.CHANCE_GENERATNG_WASTE_IONCANNON};
			return probRecursos;
		} else if (nave instanceof PlasmaCannon) {
			int[] probRecursos = {ConnectionBDD.getDefenseMetalCost(7),ConnectionBDD.getDefenseMetalCost(7),Variables.CHANCE_GENERATNG_WASTE_PLASMACANNON};
			return probRecursos;
		} else {
			int[] probRecursos = {0,0,0};
			return probRecursos;
		}
	}
	
	public void initInitialCostFleet() {
		int metalPlanet = 0, deutPlanet = 0;
		int metalEnemy = 0, deutEnemy = 0;
		
		int[] unidadesPlaneta = calcularActualUnitsPlanet();
		int[] unidadesEnemy = calcularActualUnitsEnemy();
		
		for (int i = 0; i < unidadesPlaneta.length; i++) {
			switch (i) {
			case 0:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipMetalCost(1);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipDeuteriumCost(1);
				break;

			case 1:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipMetalCost(2);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipDeuteriumCost(2);
				break;
				
			case 2:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipMetalCost(3);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipDeuteriumCost(3);
				break;
				
			case 3:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipMetalCost(4);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getShipDeuteriumCost(4);
				break;
				
			case 4:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseMetalCost(1);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseDeuteriumCost(1);
				break;
			
			case 5:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseMetalCost(2);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseDeuteriumCost(2);
				break;
				
			case 6:
				metalPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseMetalCost(3);
				deutPlanet += unidadesPlaneta[i] * ConnectionBDD.getDefenseDeuteriumCost(3);
				break;
			default:
				break;
			}
		}
	}
	
	// BATALLA
	
	public void startBattle() {
		
		battleDevolpment = "\nSTART THE BATTLE";
		String jAtacante = "";
		String atacanteString = "";
		String defensaString = "";
		
		ArrayList<MilitaryUnit>[] atacante;
		ArrayList<MilitaryUnit>[] defensa;
		
		int grupoAtacante = 0, grupoDefensa, naveRandom, naveRandom2;
		String naveAtancante, naveDefensora;
		int ataque = 0, armor = 0;
		
		for (int i = 0; i < armies.length; i++) {
			System.out.println("-------------Flota "+i+"--------------");
			for (int j = 0; j < armies[i].length; j++) {
				System.out.println("Grupo "+j);
				for (Object nave : armies[i][j]) {
					if (nave instanceof Ship) {
						System.out.println(((Ship) nave).getBaseDamage());
					}
				}
			}
		}
		
		actualNumberUnitsEnemy = calcularActualUnitsEnemy();
		actualNumberUnitsPlanet = calcularActualUnitsPlanet();
		
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
		int minimoUnidadesPlanet = (int) Math.round(initialNumPlanet * 0.2) ;
		int minimoUnidadesEnemy = (int) Math.round(initialNumEnemy * 0.2);
		
		System.out.println("Cantidad inicial flota Planet: "+initialNumPlanet);
		System.out.println("Cantidad inicial flota Enemy: "+initialNumEnemy);
		System.out.println("Minimo planet: "+ minimoUnidadesPlanet);
		System.out.println("Minimo Enemy: "+minimoUnidadesEnemy);
		System.out.println("Actual planet: "+ actualNumPlanet);
		System.out.println("Actual enemy: "+ actualNumEnemy);

		while (actualNumPlanet > minimoUnidadesPlanet && actualNumEnemy > minimoUnidadesEnemy) {
			// TURNO
			// Se establece que flota ataca y que flota defiende
			
//			System.out.println("jugador: "+jugador);
			if (jugador == 0) {
				atacante = armies[0];
				defensa = armies[1];
				jAtacante = "Planet";
			} else {
				atacante = armies[1];
				defensa = armies[0];
				jAtacante = "Enemy fleet";
			}
			battleDevolpment += "\nAttacks "+jAtacante+": ";
			// ATAQUE
			boolean attackAgain = true;
			while (attackAgain) {
				attackAgain = false;
				
				if (jugador == 0) {
					System.out.println("Ataca planeta");
					grupoAtacante = getPlanetGroupAttacker();
				} else {
					System.out.println("Ataca enemigo");
					grupoAtacante = getEnemyGroupAttacker();
				}
				System.out.println("Grupo Atacante: "+grupoAtacante);
				
				
				
				for (int i = 0; i < armies.length; i++) {
					System.out.println("-------------Flota "+i+"--------------");
					for (int j = 0; j < armies[i].length; j++) {
						System.out.println("Grupo "+j);
						for (Object nave : armies[i][j]) {
							if (nave instanceof Ship) {
								System.out.println(((Ship) nave).getActualArmor());
							}
						}
					}
				}
				
				
				
				while (atacante[grupoAtacante].size() < 1) {
					if (jugador == 0) {
						grupoAtacante = getPlanetGroupAttacker();
					} else {
						grupoAtacante = getEnemyGroupAttacker();
					}
					
				}
				
				System.out.println("Grupo Atacante: "+grupoAtacante);
				
				// Se queda pillado aqui
				
				naveRandom = generador.nextInt(0,atacante[grupoAtacante].size());
				
				System.out.println("Nave atacante: "+naveRandom);
				
				grupoDefensa = getGroupDefender(defensa);
				
				System.out.println("Grupo defensa: "+grupoDefensa);
				System.out.println("Tamaño grupo defensa: "+defensa[grupoDefensa].size());
				while (defensa[grupoDefensa].size() < 1) {
					System.out.println("Bucle");
					
					grupoDefensa = getGroupDefender(defensa);
					System.out.println("Grupo defensa: "+grupoDefensa);
					System.out.println("Tamaño grupo defensa: "+defensa[grupoDefensa].size());
				}
				System.out.println("Grupo defensa: "+grupoDefensa);
				
				naveRandom2 = generador.nextInt(0,defensa[grupoDefensa].size());
				
				System.out.println("Nave defensora: "+naveRandom2);
				
				
				if (atacante[grupoAtacante].get(naveRandom) instanceof LightHunter) {
					atacanteString = "Light Hunter";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof HeavyHunter) {
					atacanteString = "Heavy Hunter";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof BattleShip) {
					atacanteString =  "Battle Ship";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof ArmoredShip) {
					atacanteString = "Armored Ship";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof MissileLauncher) {
					atacanteString = "Missile Launcher";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof IonCannon) {
					atacanteString = "Ion Cannon";
				} else if (atacante[grupoAtacante].get(naveRandom) instanceof PlasmaCannon) {
					atacanteString = "Plasma Cannon";
				} else {
					atacanteString = "test";
				}
				
				battleDevolpment += atacanteString+" attacks ";
				
				if (defensa[grupoDefensa].get(naveRandom2) instanceof LightHunter) {
					defensaString = "Light Hunter";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof HeavyHunter) {
					defensaString = "Heavy Hunter";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof BattleShip) {
					defensaString = "Battle Ship";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof ArmoredShip) {
					defensaString = "Armored Ship";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof MissileLauncher) {
					defensaString = "Missile Ship";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof IonCannon) {
					defensaString = "Ion Cannon";
				} else if (defensa[grupoDefensa].get(naveRandom2) instanceof PlasmaCannon) {
					defensaString = "Plasma Cannon";
				} else {
					defensaString = "test";
				}
				
				battleDevolpment += defensaString;
				
				ataque = atacante[grupoAtacante].get(naveRandom).attack(); // Para report
				
				System.out.println("Daño: "+ataque);
				
				battleDevolpment += "\n"+atacanteString + " generates the damage = "+ ataque;
				
				
				System.out.println("Antes: "+defensa[grupoDefensa].get(naveRandom2).getActualArmor());
				// El ataque baja el armor de la naveDefensa
				defensa[grupoDefensa].get(naveRandom2).takeDamage(ataque);

				armor = defensa[grupoDefensa].get(naveRandom2).getActualArmor(); // Para report
				
				System.out.println("Despues: "+defensa[grupoDefensa].get(naveRandom2).getActualArmor());
				
				battleDevolpment += "\n"+defensaString + " stays with armor = "+armor;
				
				// HACER QUE SE BORRE LA NAVE SI SE QUEDA SIN ARMOR
				if (armor <= 0) {
					// SI SE BORRA COMPROBAR ANTES SI SE GENERAN RESIDUIOS
					int probWasteRecursos[] = probabilityWasteByShip((Ship) defensa[grupoDefensa].get(naveRandom2));
					int probW = probWasteRecursos[0]; // Probablidad
					int recMetal = probWasteRecursos[1]; // Valor en metal
					int recDeuterium = probWasteRecursos[2]; // Valor en Deuterio
					
					// MIRAR DONDE SE GUARDA EL WASTE Y REVISAR EL ARRAY DE RESOURCESLOSES
					
					
					// SI SE GENERAN HACER EL CALCULO
					defensa[grupoDefensa].remove(naveRandom2);
					battleDevolpment += "\nWe eliminate "+defensaString;
					System.out.println("Nave eliminada");
					break;
				}
				
				int probAttackAgain = probabilityByShip((Ship) atacante[grupoAtacante].get(naveRandom));
				int numAleatorio = generador.nextInt(0,100);
				if (numAleatorio <= probAttackAgain) {
					attackAgain = true;
					battleDevolpment += "\nAttacks again";
				}
				
			}
			
			// REVISAR PORQUE SE SALTA ESTO EN EL ULTIMO TURNO
			
			this.actualNumberUnitsEnemy = calcularActualUnitsEnemy();
			this.actualNumberUnitsPlanet = calcularActualUnitsPlanet();
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
			
			if (actualNumPlanet > minimoUnidadesPlanet && actualNumEnemy > minimoUnidadesEnemy) {
				battleDevolpment += "\n\n**************CHANGE ATTACKER**************";

			}
			System.out.println("---------------------------------------");
		}
		if (actualNumPlanet > minimoUnidadesPlanet) {
			battleDevolpment += "\n\nPLANET WINS";
			System.out.println("PLANET WINS");
		} else {
			battleDevolpment += "\n\nENEMY WINS";
			System.out.println("ENEMY WINS");
		}
		Main.setBattleDevelopment(battleDevolpment);
	}
	
	public static void main(String[] args) {
		
		ConnectionBDD con = new ConnectionBDD();
		
		Planet planeta = new Planet();
		planeta.setMetal(200000);
		planeta.setDeuterium(200000);
		
		Random generador = new Random();
		try {
			//planeta.newBattleShip(generador.nextInt(1,10));
			planeta.newLigthHunter(generador.nextInt(1,5));
			planeta.newHeavyHunter(generador.nextInt(1,5));
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Planet planetaEnemy = new Planet();
		planetaEnemy.setMetal(200000);
		planetaEnemy.setDeuterium(200000);
		planeta.setTechnologyAttack(2);
		planeta.setTechnologyDefense(1);
		try {
			//planetaEnemy.newBattleShip(generador.nextInt(1,10));
			planetaEnemy.newLigthHunter(generador.nextInt(1,5));
			planetaEnemy.newHeavyHunter(generador.nextInt(1,5));
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Battle batalla = new Battle(planetaEnemy.getArmy(),planeta.getArmy());
		batalla.startBattle();
		System.out.println(batalla.getBattleDevolpment());
	}
		
}
