package game.item.weapon.polearm;

import game.item.Item;
import game.item.weapon.Weapon;


public class Polearm extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PolearmType polearmType;
	
	public enum PolearmType {
		spear, glaive, halberd, pike, lance
	}
	
public Polearm() {
	this("Unknown");
}

	public Polearm(String name) {
		super(name);
		this.polearmType = PolearmType.values()[Item.rand.nextInt(PolearmType.values().length)];
		this.weaponType = WeaponType.polearm;
		this.setDam();

	}

	public Polearm(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.polearmType = PolearmType.values()[Item.rand.nextInt(PolearmType.values().length)];
		this.weaponType = WeaponType.polearm;
		this.setDam();

	}
	public Polearm(String name, int curCond, int maxCond, PolearmType polearmType) {
		super(name, curCond, maxCond);
		this.polearmType = polearmType;
		this.weaponType = WeaponType.polearm;
		this.setDam();

	}

	public Polearm(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam, game.item.weapon.Weapon.DamType damType, boolean twoHanded, PolearmType polearmType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, game.item.weapon.Weapon.WeaponType.polearm , damType, twoHanded);
		this.polearmType = polearmType;
		this.setDam();

	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(40)/10);
		switch (polearmType) {
		case spear:
			this.dieType = 10;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 10 + (bonusWeight);
			break;
		case glaive:
			this.dieType = 10;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 2;
			this.bonusDam = 2;
			this.weight = 12 + (bonusWeight);
			break;
		case halberd:
			this.dieType = 6;
			this.numDice = 2;
			this.critChance = 5;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 15 + (2 * bonusWeight);
			break;
		case pike:
			this.dieType = 4;
			this.numDice = 3;
			this.critChance = 5;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 18 + (3 * bonusWeight);
			break;
		case lance:
			this.dieType = 8;
			this.numDice = 2;
			this.critChance = 5;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 24 + (4 * bonusWeight);
			break;
		}
	}
}
