
public class LightHunter extends Ship {

	LightHunter(int armor, int baseDamage){
		super.setArmor(armor);
		super.setInitialArmor(armor);
		super.setBaseDamage(baseDamage);
	}
	
	// Mirar como sacar el nivel de tecnologia de planeta
	public LightHunter() {
		int armor = (Variables.ARMOR_LIGTHHUNTER) + (Planet.getTechnologyDefense() * Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)*1000/100;
		super.setArmor(armor);
		super.setInitialArmor(armor);
		
		int baseDamage = (Variables.BASE_DAMAGE_LIGTHHUNTER) + (Planet.getTechnologyAttack() * Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)*1000/100;
		super.setBaseDamage(baseDamage);
	}

	
	// IMPLEMENTAR MILITARYUNIT
	// MIRAR COMO VAN LAS PELEAS
	
	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void takeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getActualArmor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceGeneratingWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
