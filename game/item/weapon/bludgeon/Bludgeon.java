package game.item.weapon.bludgeon;

import game.item.weapon.Weapon;


public class Bludgeon extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  BludgeonType bludgeonType;
	
	public enum BludgeonType {
		club, hammer, mace, morning_star, great_hammer
	}
	
	public Bludgeon() {
		this("Unknown");
	}

	public Bludgeon(String name) {
		super(name);
		this.bludgeonType = BludgeonType.values()[Bludgeon.rand.nextInt(BludgeonType.values().length)];
		this.weaponType = WeaponType.bludgeon;
		this.setDam();

	}

	public Bludgeon(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.bludgeonType = BludgeonType.values()[Bludgeon.rand.nextInt(BludgeonType.values().length)];
		this.weaponType = WeaponType.bludgeon;
		this.setDam();

	}
	public Bludgeon(String name, int curCond, int maxCond, BludgeonType bludgeonType) {
		super(name, curCond, maxCond);
		this.bludgeonType = bludgeonType;
		this.weaponType = WeaponType.bludgeon;
		this.setDam();

	}


	public Bludgeon(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam, DamType damType, boolean twoHanded, BludgeonType bludgeonType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, WeaponType.bludgeon , damType, twoHanded);
		this.bludgeonType = bludgeonType;
		this.setDam();

	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(20)/10);
		switch (bludgeonType) {
		case club:
			this.dieType = 4;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 3;
			this.bonusDam = 1;
			this.weight = 6 + bonusWeight;
			break;
		case hammer:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 4;
			this.bonusDam = 0;
			this.weight = 6.8 + bonusWeight;
			break;
		case mace:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 3;
			this.bonusDam = 1;
			this.weight = 8 + bonusWeight;
			break;
		case morning_star:
			this.dieType = 4;
			this.numDice = 2;
			this.critChance = 5;
			this.critMultiplier = 5;
			this.bonusDam = 0;
			this.weight = 10 + (2 * bonusWeight);
			break;
		case great_hammer:
			this.dieType = 8;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 4;
			this.bonusDam = 1;
			this.weight = 12 + (3 * bonusWeight);
			break;
		}
	}
}
