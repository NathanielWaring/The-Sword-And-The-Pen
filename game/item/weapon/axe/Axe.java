package game.item.weapon.axe;

import game.item.weapon.Weapon;


public class Axe extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AxeType axeType;
	
	public enum AxeType {
		hatchet, hand_axe, tomahawk,  great_axe
	}
	
	public Axe() {
		this("Unknown");
	}

	public Axe(String name) {
		super(name);
		this.axeType = AxeType.values()[Axe.rand.nextInt(AxeType.values().length)];
		this.weaponType = WeaponType.axe;
		this.setDam();
	}

	public Axe(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.axeType = AxeType.values()[Axe.rand.nextInt(AxeType.values().length)];
		this.weaponType = WeaponType.axe;
		this.setDam();
	}
	public Axe(String name, int curCond, int maxCond, AxeType axeType) {
		super(name, curCond, maxCond);
		this.axeType = axeType;
		this.weaponType = WeaponType.axe;
		this.setDam();
	}

	public Axe(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam, DamType damType, boolean twoHanded, AxeType axeType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, WeaponType.axe , damType, twoHanded);
		this.axeType = axeType;
		this.setDam();

	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(20)/10);
		switch (axeType) {
		case hatchet:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 3;
			this.bonusDam = 0;
			this.weight = 4 + bonusWeight;
			break;
		case hand_axe:
			this.dieType = 8;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 6 + bonusWeight;
			break;
		case tomahawk:
			this.dieType = 10;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 3;
			this.bonusDam = 0;
			this.weight = 7.5 + (2 * bonusWeight);
			break;
		case great_axe:
			this.dieType = 4;
			this.numDice = 2;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 10 + (2 * bonusWeight);
			break;

		}
	}

}
