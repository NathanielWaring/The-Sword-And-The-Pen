package game.item.weapon;

import game.item.Item;

public class Weapon extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dieType;
	public int numDice;
	public int bonusDam;
	public int critChance;
	public int critMultiplier;
	public DamType damType;
	public WeaponType weaponType;
	public boolean twoHanded;

	public static enum DamType {
		none, fire, ice, electricity, magic, earth, death;

		public String toString() {
			String theString;
			theString = this.name().substring(0, 1).toUpperCase() + this.name().substring(1);
			return theString;
		}
	}

	public static enum WeaponType {
		bludgeon, sword, dagger, polearm, axe, projectile;
		public String toString() {
			String theString;
			theString = this.name().substring(0, 1).toUpperCase() + this.name().substring(1);
			return theString;
		}
	}

	public Weapon() {
		this("Unknown");
	}

	public Weapon(String name) {
		this(name, 1, 10);

	}

	public Weapon(String name, int curCond, int maxCond) {

		this(name, curCond, maxCond, Weapon.randomWeaponType());

	}

	public Weapon(String name, int curCond, int maxCond, WeaponType weaponType) {
		this(name, curCond, maxCond, 6, 1, 0, weaponType, Weapon.randomDamType(), false);

	}

	public Weapon(String name, int curCond, int maxCond, int dieType, int numDice, int bonusDam, WeaponType weaponType,
			DamType damType, boolean twoHanded) {
		this(name, curCond, maxCond, dieType, 5, 2, numDice, bonusDam, weaponType, Weapon.randomDamType(), false);

	}

	public Weapon(String name, int curCond, int maxCond, int dieType, int critChance, int critMultiplier, int numDice,
			int bonusDam, WeaponType weaponType, DamType damType, boolean twoHanded) {
		super(name, curCond, maxCond);
		this.type = Item.itemType.weapon;
		this.dieType = dieType;
		this.numDice = numDice;
		this.critChance = critChance;
		this.critMultiplier = critMultiplier;
		this.bonusDam = bonusDam;
		this.weaponType = weaponType;
		this.damType = damType;
		this.twoHanded = twoHanded;

		if (this.name.equals("Unknown")) {
			this.name = "" + this.weaponType;
			if (!

			this.damType.equals(DamType.none)) {
				this.name += " of " + this.damType;
			}

		}
	}

	public static WeaponType randomWeaponType() {
		return WeaponType.values()[rand.nextInt(WeaponType.values().length)];

	}

	public static DamType randomDamType() {
		return DamType.values()[rand.nextInt(DamType.values().length)];

	}

	public String toString() {
		String printDamType = this.damType.name();

		String printName = this.name;
		if (printName.length() > 30) {
			printName = printName.substring(0, 27) + "...";
		}
		int counter = printDamType.length();
		while (counter < 10) {
			printDamType += " ";
			counter++;
		}
		counter = this.name.length();
		while (counter < 30) {
			printName += " ";
			counter++;
		}
		String printCurCond = "" + currentCondition;
		String printMaxCond = "" + maxCondition;
		counter = printCurCond.length();
		while (counter < 3) {

			printCurCond = " " + printCurCond;
			counter++;
		}
		counter = printMaxCond.length();
		while (counter < 3) {

			printMaxCond = " " + printMaxCond;
			counter++;
		}
		String printType = this.weaponType.toString();
		counter = printType.length();
		while (counter < 15) {
			printType += " ";
			counter++;
		}
		return String.format(
				"%s  " + delimChar + " Condition: (%s/%s)\t" + delimChar + " Damage: %dD%d + %d \t" + delimChar
						+ " Damage Type: %s \t" + delimChar + " Weapon Type: %s",
				printName, printCurCond, printMaxCond, numDice, dieType, bonusDam, printDamType, printType);

	}

	public static void printWeapons() {
		delim = "";
		for (int i = 0; i < 160; i++) {
			delim += delimChar;
		}
		System.out.println();
		;
		System.out.println(delim);
		String itemDelim = "" + delimChar;

		for (int i = 0; i < 71; i++) {
			itemDelim += " ";
		}
		itemDelim += "- WEAPON LIST -";
		for (int i = 0; i < 72; i++) {
			itemDelim += " ";
		}
		itemDelim += delimChar;
		System.out.println(itemDelim);
		;
		System.out.println(delim);
		for (int i = 0; i < itemTotal; i++) {
			String listRef = "" + itemList[i].itemCode;
			int counter = listRef.length();
			while (counter < 4) {
				listRef = "0" + listRef;
				counter++;
			}
			if (itemList[i].type == Item.itemType.weapon) {
				System.out.println(delimChar + " (" + listRef + ") " + delimChar + " " + itemList[i] + " " + delimChar);
			}
		}
		System.out.println(delim);

	}

}
