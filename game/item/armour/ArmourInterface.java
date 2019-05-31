package game.item.armour;

import java.util.Random;

public interface ArmourInterface {
	SubType subType = null;
	Random rand = new Random();
	int AR = 0;
	double weight = 0;
	public enum SubType {
		charm, medallion, pendant, necklace, choker, collar;
		public static SubType randomAmuletType () {
			SubType tempSub = SubType.values()[rand.nextInt(SubType.values().length)];
			return tempSub;
		}
	}


	default void setArmour() {
		
//		double bonusWeight = (rand.nextInt(5) / 10);
//		switch (subType) {
//		case charm:
//			this.AR = 0; 
//			this.weight = 0 + (bonusWeight);
//		case medallion:
//			this.AR = 0;
//			this.weight = 0 + (2 * bonusWeight);
//		case pendant:
//			this.AR = 1;
//			this.weight = 1 + (bonusWeight);
//			break;
//		case necklace:
//			this.AR = 1;
//			this.weight = 1 + (2 * bonusWeight);
//			break;
//		case choker:
//			this.AR = 2;
//			this.weight = 2 + (bonusWeight);
//			break;
//		case collar:
//			this.AR = 2;
//			this.weight = 2 + (2 * bonusWeight);
//			break;
//
//		}
	}

}
