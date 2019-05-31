package game.item.weapon.sword;

import game.item.Item;
import game.item.weapon.Weapon;


public class Sword extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SwordType swordType;

	public enum SwordType {
		short_sword, long_sword, katana, claymore, two_handed_sword
	}

	public Sword() {
		this("Unknown");
	}

	public Sword(String name) {
		super(name);
		this.swordType = SwordType.values()[Item.rand.nextInt(SwordType.values().length)];
		this.weaponType = WeaponType.sword;
		this.setDam();

	}

	public Sword(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.swordType = SwordType.values()[Item.rand.nextInt(SwordType.values().length)];
		this.weaponType = WeaponType.sword;
		this.setDam();

	}
	
	public Sword(String name, int curCond, int maxCond, SwordType swordType) {
		super(name, curCond, maxCond);
		this.swordType = swordType;
		this.weaponType = WeaponType.sword;
		this.setDam();

	}

	public Sword(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam,
			game.item.weapon.Weapon.DamType damType, boolean twoHanded, SwordType swordType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, Weapon.WeaponType.sword, damType, twoHanded);
		this.swordType = swordType;

	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(15)/10);
		switch (swordType) {
		case short_sword:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 2;
			this.bonusDam = 2;
			this.weight = 8 + (bonusWeight);
			break;
		case long_sword:
			this.dieType = 8;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 10 + (bonusWeight);
			break;
		case katana:
			this.dieType = 6;
			this.numDice = 2;
			this.critChance = 15;
			this.critMultiplier = 3;
			this.bonusDam = 1;
			this.weight = 8 + (bonusWeight);
			break;
		case claymore:
			this.dieType = 10;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 3;
			this.bonusDam = 3;
			this.weight = 16 + (2 * bonusWeight);
			break;
		case two_handed_sword:
			this.dieType = 8;
			this.numDice = 2;
			this.critChance = 10;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 20 + (3 * bonusWeight);
			break;
		}

	}
}
