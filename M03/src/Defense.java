
public abstract class Defense implements MilitaryUnit, Variables {

	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getInitialArmor() {
		return initialArmor;
	}

	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public abstract int attack();
	
	public abstract void takeDamage(int receivedDamage);
	
	public abstract int getActualArmor();
	
	public abstract int getMetalCost();
	
	public abstract int getDeuteriumCost();
	
	public abstract int getChanceGeneratingWaste();
	
	public abstract int getChanceAttackAgain();
	
	public abstract void resetArmor();

}
