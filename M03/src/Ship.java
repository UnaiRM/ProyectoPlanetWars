
public abstract class Ship implements MilitaryUnit, Variables{

	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	private int level_Attack;
	private int level_Defense;
	
	
	
	public int getLevel_Attack() {
		return level_Attack;
	}

	public void setLevel_Attack(int level_Attack) {
		this.level_Attack = level_Attack;
	}

	public int getLevel_Defense() {
		return level_Defense;
	}

	public void setLevel_Defense(int level_Defense) {
		this.level_Defense = level_Defense;
	}

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
	
	public int getAttackLevel() {
		return getLevel_Attack();
	}
	
	public int getDefenseLevel() {
		return getLevel_Defense();
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
