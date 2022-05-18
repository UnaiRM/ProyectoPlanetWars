
public interface MilitaryUnit {

	public abstract int attack();
	
	public abstract void takeDamage(int receivedDamage);
	
	public abstract int getActualArmor();
	
	public abstract int getMetalCost();
	
	public abstract int getDeuteriumCost();
	
	public abstract int getChanceGeneratingWaste();
	
	public abstract int getChanceAttackAgain();
	
	public abstract void resetArmor();
	
	public abstract int getAttackLevel();
	
	public abstract int getDefenseLevel();
	
}
