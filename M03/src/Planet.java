import java.util.ArrayList;

public class Planet {

	// PREGUNTAR SI PUEDEN SER STATIC YA QUE SE USAN EN OTRAS CLASES SIN RELACION
	private static int technologyDefense = 0;
	private static int technologyAttack = 0;
	
	
	private int metal = 0;
	private int deuterium = 0;
	
	// MIRAR SI SE DEBEN USAR LAS CONSTANTES PARA ESTOS VALORES O SI SE PUEDEN INVENTAR (preguntar si contienen cuanto sube o cuanto vale)
	private int upgradeDefenseTechnologyDeuteriumCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
	private int upgradeAttackTechnologyDeuteriumCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
	
	// Mirar si se debe indicar que el ArrayList es de Militaryunits
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	
	// REVISAR CONSTRUCTORES (NO SE INDICAN EN EL DOCUMENTO)
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
	
	public static int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public static int getTechnologyAttack() {
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
			this.upgradeDefenseTechnologyDeuteriumCost += this.upgradeDefenseTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST/100);
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
			this.upgradeAttackTechnologyDeuteriumCost += this.upgradeAttackTechnologyDeuteriumCost * (Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST/100);
		}
	}
	
	
	// Generacion de unidades
	
	public void newLigthHunter(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_LIGTHHUNTER;
		int costeUnidadMetal = Variables.METAL_COST_LIGTHHUNTER;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[0].add(new LightHunter());
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
				this.army[0].add(new LightHunter());
			}
		}
	}
	
	public void newHeavyHunter(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_HEAVYHUNTER;
		int costeUnidadMetal = Variables.METAL_COST_HEAVYHUNTER;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[1].add(new HeavyHunter());
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
				this.army[1].add(new HeavyHunter());
			}
		}
	}
	
	public void newBattleShip(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_BATTLESHIP;
		int costeUnidadMetal = Variables.METAL_COST_BATTLESHIP;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[2].add(new BattleShip());
				cantidad++;
			}
			
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Battle Ships"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				this.army[2].add(new BattleShip());
			}
		}
	}
	
	public void newArmoredShip(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_ARMOREDSHIP;
		int costeUnidadMetal = Variables.METAL_COST_ARMOREDSHIP;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[3].add(new ArmoredShip());
				cantidad++;
			}
			
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Armored Ships"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				this.army[3].add(new ArmoredShip());
			}
		}
	}
	
	public void newMissileLauncher(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_MISSILELAUNCHER;
		int costeUnidadMetal = Variables.METAL_COST_MISSILELAUNCHER;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[4].add(new MissileLauncher());
				cantidad++;
			}
			
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Missile Launchers"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				this.army[4].add(new MissileLauncher());
			}
		}
	}
	
	public void newIonCannon(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_IONCANNON;
		int costeUnidadMetal = Variables.METAL_COST_IONCANNON;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[5].add(new IonCannon());
				cantidad++;
			}
			
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Ion Cannons"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				this.army[5].add(new IonCannon());
			}
		}
	}
	
	public void newPlasmaCannon(int n) throws ResourceException {
		int costeUnidadDeuterium = Variables.DEUTERIUM_COST_PLASMACANNON;
		int costeUnidadMetal = Variables.METAL_COST_PLASMACANNON;
		
		// Comprueba que se tengan suficientes recursos para todas las unidades pedidas(n)
		if (this.metal < costeUnidadMetal * n || this.deuterium < costeUnidadDeuterium * n) {
			// Se añaden todos los posibles
			int cantidad = 0;
			while (this.metal > costeUnidadMetal && this.deuterium > costeUnidadDeuterium) {
				this.metal -= costeUnidadMetal;
				this.deuterium -= costeUnidadDeuterium;
				this.army[6].add(new PlasmaCannon());
				cantidad++;
			}
			
			// MIRAR DE INTEGRAR EN INTERFAZ
			System.out.println("Se han generado "+cantidad+" Plasma Cannons"); 
			
			throw new ResourceException();
		} else {
			// Gastos
			this.metal -= costeUnidadMetal * n;
			this.deuterium -= costeUnidadDeuterium * n;
			
			// Bucle que crea todas la unidades pedidas
			for (int i = 0; i < n; i++) {
				this.army[6].add(new PlasmaCannon());
			}
		}
	}
	
	public void printStats() {
		// USAR INTERFAZ PARA MOSTRAR ESTADISTICAS
	}
	
}
