
public class PlasmaCannon extends Ship {

	PlasmaCannon(int armor, int baseDamage){
		super.setArmor(armor);
		super.setInitialArmor(armor);
		super.setBaseDamage(baseDamage);
	}
	
	// Mirar como sacar el nivel de tecnologia de planeta
	public PlasmaCannon() {
		super.setArmor(0);
		super.setInitialArmor(0);
		super.setBaseDamage(0);
	}

	public void setArmorAndDamage(Planet planeta) {
		int armor = (Variables.ARMOR_PLASMACANNON) + (planeta.getTechnologyDefense() * Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY)*1000/100;
		int baseDamage = (Variables.BASE_DAMAGE_PLASMACANNON) + (planeta.getTechnologyAttack() * Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY)*1000/100;

		super.setArmor(armor);
		super.setInitialArmor(armor);
		super.setBaseDamage(baseDamage);
	}
	
	// IMPLEMENTAR MILITARYUNIT
	// MIRAR COMO VAN LAS PELEAS
	
	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return super.getBaseDamage();
	}

	@Override
	public void takeDamage(int receivedDamage) {
		super.setArmor(super.getArmor() - receivedDamage);
	}

	@Override
	public int getActualArmor() {
		return super.getArmor();
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return Variables.METAL_COST_PLASMACANNON;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return Variables.DEUTERIUM_COST_PLASMACANNON;
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
		super.setArmor(super.getInitialArmor());
	}
	
}
