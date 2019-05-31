package game.item.weapon.projectile;

import game.item.Item;
import game.item.weapon.Weapon;

public class Projectile extends Weapon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProjectileType projectileType;

	public enum ProjectileType {
		darts, short_bow, long_bow, crossbow, throwing_axe, javelin
	}

	public Projectile() {
		this("Unknown");
	}

	public Projectile(String name) {
		super(name);
		this.projectileType = ProjectileType.values()[Item.rand.nextInt(ProjectileType.values().length)];
		this.weaponType = WeaponType.projectile;
		this.setDam();

	}

	public Projectile(String name, int curCond, int maxCond) {
		super(name, curCond, maxCond);
		this.projectileType = ProjectileType.values()[Item.rand.nextInt(ProjectileType.values().length)];
		this.weaponType = WeaponType.projectile;
		this.setDam();
	}
	public Projectile(String name, int curCond, int maxCond, ProjectileType projectileType) {
		super(name, curCond, maxCond);
		this.projectileType = projectileType;
		this.weaponType = WeaponType.projectile;
		this.setDam();
	}

	public Projectile(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam,
			game.item.weapon.Weapon.DamType damType, boolean twoHanded, ProjectileType projectileType) {
		super(name, curCond, maxCond, dieType, numDice, bonusDam, game.item.weapon.Weapon.WeaponType.projectile,
				damType, twoHanded);
		this.projectileType = projectileType;
		this.setDam();

	}
	private void setDam() {
		double bonusWeight = (rand.nextInt(10)/10);
		switch (projectileType) {
		case darts:
			this.dieType = 4;
			this.numDice = 1;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 1;
			this.weight = 1 + (bonusWeight);
			break;
		case short_bow:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 5 + (bonusWeight);
			break;
		case long_bow:
			this.dieType = 6;
			this.numDice = 1;
			this.critChance = 10;
			this.critMultiplier = 3;
			this.bonusDam = 1;
			this.weight = 6 + (bonusWeight);
			break;
		case crossbow:
			this.dieType = 10;
			this.numDice = 1;
			this.critChance = 5;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 12 + (2 * bonusWeight);
			break;
		case throwing_axe:
			this.dieType = 4;
			this.numDice = 2;
			this.critChance = 15;
			this.critMultiplier = 2;
			this.bonusDam = 0;
			this.weight = 4 + (bonusWeight);
			break;
		case javelin:
			this.dieType = 8;
			this.numDice = 1;
			this.critChance = 15;
			this.critMultiplier = 3;
			this.bonusDam = 0;
			this.weight = 8 + (bonusWeight);
			break;
		default:
			break;
		}
	}
}
