package game.area.dungeon;

import java.util.Random;

import game.area.room.Room;
import game.item.Item;

public class Dungeon {
	String name;
	String desc;
	final int dungeonNum;
	static int dungeonTotal;
	final int numRooms, xSize, ySize;
	Random rand = new Random();
	Room[][] roomMap;

	public Dungeon(int numRooms, int xSize, int ySize) {
		dungeonNum = ++dungeonTotal;
		this.numRooms = numRooms;
		this.xSize = xSize;
		this.ySize = ySize;
		this.roomMap = new Room[xSize][ySize];
	}
	
	
	
	
	

	public Item[] loot(int lootLevel, int lootQuantity) {
		Item[] lootList = new Item[lootQuantity];
		Item[] itemlist = Item.itemList;

		for (int i = 0; i < lootQuantity; i++) {
			lootList[i] = itemlist[rand.nextInt(100) + (10 * lootLevel)];
		}

		return lootList;

	}

	public int lootGold(int lootLevel) {
		int gold = (rand.nextInt(5) + 10) * lootLevel;

		return gold;
	}

}
