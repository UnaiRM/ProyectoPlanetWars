import java.util.ArrayList;

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
		// POR HACER
		return battleDevolpment;
	}
	
	public String getBattleDevolpment() {
		return battleDevolpment;
	}
	
	
	
	
	
	
}
