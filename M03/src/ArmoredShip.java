
public class ArmoredShip extends Ship {

	ArmoredShip(int armor, int baseDamage){
		super.setArmor(armor);
		super.setInitialArmor(armor);
		super.setBaseDamage(baseDamage);
	}
	
	// Mirar como sacar el nivel de tecnologia de planeta
	public ArmoredShip() {
		super.setArmor(0);
		super.setInitialArmor(0);
		super.setBaseDamage(0);
	}

	public void setArmorAndDamage(Planet planeta) {
		int armor = (Variables.ARMOR_ARMOREDSHIP) + (planeta.getTechnologyDefense() * Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY)*1000/100;
		int baseDamage = (Variables.BASE_DAMAGE_ARMOREDSHIP) + (planeta.getTechnologyAttack() * Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY)*1000/100;

		super.setArmor(armor);
		super.setInitialArmor(armor);
		super.setBaseDamage(baseDamage);
		super.setLevel_Attack(planeta.getTechnologyAttack());
		super.setLevel_Defense(planeta.getTechnologyDefense());
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
		return Variables.METAL_COST_ARMOREDSHIP;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return Variables.DEUTERIUM_COST_ARMOREDSHIP;
	}

	
	// PREGUNTAR SI DEVUELVE LA PROBABILIDAD O LA CANTIDAD DE WASTE
	@Override
	public int getChanceGeneratingWaste() {
		// TODO Auto-generated method stub
		return Variables.CHANCE_GENERATNG_WASTE_ARMOREDSHIP;
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
