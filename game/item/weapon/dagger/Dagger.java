package game.item.weapon.dagger;

import game.item.Item;
import game.item.weapon.Weapon;


public class Dagger extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DaggerType daggerType;
	
	public enum DaggerType {
		knife, dagger, dirk, kriss, kukri
	}
	public Dagger() {
		this("Unknown");
	}


	public Dagger(String name) {
		super(name);
		this.daggerType = DaggerType.values()[Item.rand.nextInt(DaggerType.values().length)];
		this.weaponType = WeaponType.dagger;
		this.setDam();

	}

	public Dagger(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.daggerType = DaggerType.values()[Item.rand.nextInt(DaggerType.values().length)];
		this.weaponType = WeaponType.dagger;
		this.setDam();
	}
	public Dagger(String name, int curCond, int maxCond, DaggerType daggerType) {
		super(name, curCond, maxCond);
		this.daggerType = daggerType;
		this.weaponType = WeaponType.dagger;
		this.setDam();
	}

	public Dagger(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam, game.item.weapon.Weapon.DamType damType, boolean twoHanded, DaggerType daggerType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, game.item.weapon.Weapon.WeaponType.dagger , damType, twoHanded);
		this.daggerType = daggerType;
		this.setDam();
	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(10)/10);
		switch (daggerType) {
		case knife:
			this.dieType = 3;
			this.numDice = 1;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 2 + (4 * bonusWeight);
			break;
		case dagger:
			this.dieType = 4;
			this.numDice = 1;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 3.5 + (bonusWeight);
			break;
		case dirk:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 3;
			this.bonusDam = 0;
			this.weight = 4 + (bonusWeight);
			break;
		case kriss:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 20;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 5 + (2 * bonusWeight);
			break;
		case kukri:
			this.dieType = 4;
			this.numDice = 2;
			this.critChance = 15;
			this.critMultiplier = 3;
			this.bonusDam = 0;
			this.weight = 6 + (2 * bonusWeight);
			break;
		}
	}
}
