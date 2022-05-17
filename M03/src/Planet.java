import java.util.ArrayList;

public class Planet {

	private int technologyDefense = 0;
	private int technologyAttack = 0;
	
	// MIRAR CON CUANTO SE EMPIEZA
	private int metal = Variables.METAL_BASE_ENEMY_ARMY;
	private int deuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;
	
	private int upgradeDefenseTechnologyDeuteriumCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
	private int upgradeAttackTechnologyDeuteriumCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
	
	// Mirar si se debe indicar que el ArrayList es de Militaryunits
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	
	
	public Planet() {
		super();
		// Genera todas las flotas vacias
		for (int i = 0; i < 7; i++) {
			army[i] = new ArrayList<MilitaryUnit>();
		}
	}

	public Planet(int technologyDefense, int technologyAttack, int metal, int deuterium,
			int upgradeDefenseTechnologyDeuteriumCost, int upgradeAttackTechnologyDeuteriumCost,
			ArrayList<MilitaryUnit>[] army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAttack = technologyAttack;
		this.metal = metal;
		this.deuterium = deuterium;
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
		this.army = army;
	}

	// SETTERS Y GETTERS
	
	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAttack() {
		return technologyAttack;
	}

	public void setTechnologyAttack(int technologyAttack) {
		this.technologyAttack = technologyAttack;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}

	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}

	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}

	// METODOS
	
	// Upgrages
	public void upgradeTechnologyDefense() throws ResourceException {
		if (this.deuterium < this.upgradeDefenseTechnologyDeuteriumCost) {
			// Comprobacion de recursos suficientes
			throw new ResourceException();
		} else {
			// Gasto de deuterium y subida de nivel
			this.deuterium -= this.upgradeDefenseTechnologyDeuteriumCost;
			this.technologyDefense += 1;
			// Subida de coste (se usa una constante para subir un %)
			this.upgradeDefenseTechnologyDeuteriumCost += (double)this.upgradeDefenseTechnologyDeuteriumCost * ((double)(Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST)/100.0);
		}
	}
	
	public void upgradeTechnologyAttack() throws ResourceException {
		if (this.deuterium < this.upgradeAttackTechnologyDeuteriumCost) {
			// Comprobacion de recursos suficientes
			throw new ResourceException();
		} else {
			// Gasto de deuterium y subida de nivel
			this.deuterium -= this.upgradeAttackTechnologyDeuteriumCost;
			this.technologyAttack += 1;
			
			// Subida de coste (se usa una constante para subir un %)
			this.upgradeAttackTechnologyDeuteriumCost += (double)this.upgradeAttackTechnologyDeuteriumCost * ((double)(Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST)/100.0);
		}
	}
	
	
	// Generacion de unidades
	
	public void newLigthHunter(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getShipDeuteriumCost(1);
		int costeUnidadMetal = ConnectionBDD.getShipMetalCost(1);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				LightHunter nave = new LightHunter();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[0].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Light Hunters"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				LightHunter nave = new LightHunter();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[0].add(nave);
			}
		}
	}
	
	public void newHeavyHunter(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getShipDeuteriumCost(2);
		int costeUnidadMetal = ConnectionBDD.getShipMetalCost(2);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				HeavyHunter nave = new HeavyHunter();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[1].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Heavy Hunters"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				HeavyHunter nave = new HeavyHunter();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[1].add(nave);
			}
		}
	}
	
	public void newBattleShip(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getShipDeuteriumCost(3);
		int costeUnidadMetal = ConnectionBDD.getShipMetalCost(3);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				BattleShip nave = new BattleShip();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[2].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" BattleShip"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				BattleShip nave = new BattleShip();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[2].add(nave);
			}
		}
	}
	
	public void newArmoredShip(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getShipDeuteriumCost(4);
		int costeUnidadMetal = ConnectionBDD.getShipMetalCost(4);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				ArmoredShip nave = new ArmoredShip();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[3].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" ArmoredShip"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				ArmoredShip nave = new ArmoredShip();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[3].add(nave);
			}
		}
	}
	
	public void newMissileLauncher(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getDefenseDeuteriumCost(1);
		int costeUnidadMetal = ConnectionBDD.getDefenseMetalCost(1);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				MissileLauncher nave = new MissileLauncher();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[4].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" MissileLauncher"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				MissileLauncher nave = new MissileLauncher();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[4].add(nave);
			}
		}
	}
	
	public void newIonCannon(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getDefenseDeuteriumCost(2);
		int costeUnidadMetal = ConnectionBDD.getDefenseMetalCost(2);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				IonCannon nave = new IonCannon();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[5].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" IonCannon"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				IonCannon nave = new IonCannon();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[5].add(nave);
			}
		}
	}
	
	// PREGUNTAR SI SE PUEDE DEVOLVER UN INT PARA LA CANTIDAD NUEVA DE NAVES
	
	public void newPlasmaCannon(int n) throws ResourceException {
		int costeUnidadDeuterium = ConnectionBDD.getDefenseDeuteriumCost(3);
		int costeUnidadMetal = ConnectionBDD.getDefenseMetalCost(3);
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				PlasmaCannon nave = new PlasmaCannon();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[6].add(nave);
				cantidad++;
			}
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" PlasmaCannon"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				PlasmaCannon nave = new PlasmaCannon();
				nave.setArmorAndDamage(technologyAttack, technologyDefense);
				this.army[6].add(nave);
			}
		}
	}
	
	public String printStats() {
		// USAR INTERFAZ PARA MOSTRAR ESTADISTICAS
		int attackTechnology = technologyAttack;
		int defenseTechnology = technologyDefense;
		
		int metal = this.metal;
		int deuterium = this.deuterium;
		
		int MissileLauncher=0,IonCannon=0,PlasmaCannon=0,LightHunter=0,HeavyHunter=0,BattleShip=0,ArmoredShip=0;
		int cantidad;
		
		for (int i = 0; i < army.length; i++) {
			ArrayList<MilitaryUnit> flota = army[i];
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
			case 4:
				MissileLauncher = cantidad;
				break;
			case 5:
				IonCannon = cantidad;
				break;
			case 6:
				PlasmaCannon = cantidad;
				break;
			default:
				break;
			}
		}
		
		String texto = "";
		texto += "<html><body>TECHNOLOGY<br>";
		texto += "Attack Technology: "+attackTechnology+"<br>";
		texto += "Defense Technology "+defenseTechnology+"<br>";
		texto += "<br>";
		texto += "ATTACK<br>";
		texto += "Light Hunter: "+LightHunter+"<br>";
		texto += "Heavy Hunter: "+HeavyHunter+"<br>";
		texto += "Battle Ship: "+BattleShip+"<br>";
		texto += "Armored Ship: "+ArmoredShip+"<br>";
		texto += "<br>";
		texto += "DEFENSE<br>";
		texto += "Missile Launcher: "+MissileLauncher+"<br>";
		texto += "Ion Cannon: "+IonCannon+"<br>";
		texto += "Plasma Cannon: "+PlasmaCannon+"<br>";
		texto += "<br>";
		texto += "RESOURCES<br>";
		texto += "Metal: "+metal+"<br>";
		texto += "Deuterium: "+deuterium+"<br><body><html>";
		return texto;
	}
	
	public static void main(String[] args) {
		ConnectionBDD con = new ConnectionBDD();
		Planet planeta = new Planet();
		
		planeta.setMetal(200000);
		planeta.setDeuterium(200000);
		
		HeavyHunter naveHH1 = new HeavyHunter();
		HeavyHunter naveHH2 = new HeavyHunter();
		
		 //CREAR UNA FLOTA PARA CADA TIPO DE UNIDAD
	
		try {
//			planeta.newLigthHunter(2);
//			planeta.newArmoredShip(1);
//			planeta.newHeavyHunter(2);
			planeta.newMissileLauncher(3);
			planeta.newIonCannon(4);
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 //AÑADIR INDIVIDUALMENTE LAS NAVES A CADA FLOTA
		
		
//		flotaHH.add(naveHH1);
//		flotaHH.add(naveHH2);
		
		ArrayList<MilitaryUnit>[] army = planeta.getArmy();
		
	 //PONER CADA FLOTA EN SU POSICION
		
		
	 //ITERACION EN CADA UNA DE LAS UNIDADES
		for (ArrayList<MilitaryUnit> flota : army) { // ITERA EN CADA FLOTA
			for (MilitaryUnit nave : flota) { // ITERA EN CADA UNIDAD DE CADA FLOTA
				System.out.println(nave.getClass());
			}
		}
		try {
			planeta.upgradeTechnologyAttack();
			planeta.upgradeTechnologyDefense();
		} catch (ResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		planeta.printStats();
	}
}
