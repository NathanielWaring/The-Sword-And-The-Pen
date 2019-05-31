package game.area.room;

import game.creature.Creature;

public class Room {

	private Direction[] exits = new Direction[10];
	private String desc;
	private int roomNum;
	private int roomTotal;
	private int xVal;
	private int yVal;
	private int zVal;
	private Creature[] creatureList;
	private Room toEast, toWest, toNorth, toSouth, toNorthWest, toNorthEast, toSouthWest, toSouthEast, toUp, toDown;


	



	public Room() {
		this.newRoom();
	}

	public Room(boolean east, boolean west, boolean north, boolean south, boolean northwest, boolean northeast,
			boolean southwest, boolean southeast, boolean up, boolean down) {
		this.newRoom();
		exits[0].isVisible = east;
		exits[1].isVisible = west;
		exits[2].isVisible = north;
		exits[3].isVisible = south;
		exits[4].isVisible = northwest;
		exits[5].isVisible = northeast;
		exits[6].isVisible = southwest;
		exits[7].isVisible = southeast;
		exits[8].isVisible = up;
		exits[9].isVisible = down;

	}

	public Room(Direction[] directions) {
		this.newRoom();
		for (int j = 0; j < directions.length; j++) {

			for (Direction i : Direction.values()) {
				if (directions[j] == i) {
					this.exits[i.ordinal()].isVisible = true;
				}
			}
		}
	}

	public Room(boolean[] exits) {
		this.newRoom();
		this.exits = new Direction[10];
		for (int i = 0; i < exits.length; i++) {
			this.exits[i].isVisible = exits[i];

		}

	}

	public void setExits(Direction[] exits) {
		this.newRoom();
		for (int j = 0; j < exits.length; j++) {
			for (int i = 0; i < this.exits.length; i++) {
				if (exits[j].equals(this.exits[i])) {
					this.exits[i].isVisible = true;
				}
			}
		}
	}

	public void printExits() {
		this.newRoom();
		for (Direction i : Direction.values()) {
			if (exits[i.ordinal()].isVisible == true) {
				System.out.print(" " + i);
			}
		}
	}

	public void setDir(Direction dir, int roomTo) {
		switch (dir) {
		case east:
			if (this.exits[0].isVisible == true) {
				this.exits[0].leadsTo = roomTo;
			}
			break;
		case west:
			if (this.exits[1].isVisible == true) {
				this.exits[1].leadsTo = roomTo;
			}
			break;
		case north:
			if (this.exits[2].isVisible == true) {
				this.exits[2].leadsTo = roomTo;
			}
			break;
		case south:
			if (this.exits[3].isVisible == true) {
				this.exits[3].leadsTo = roomTo;
			}
			break;
		case northwest:
			if (this.exits[4].isVisible == true) {
				this.exits[4].leadsTo = roomTo;
			}
			break;
		case northeast:
			if (this.exits[5].isVisible == true) {
				this.exits[5].leadsTo = roomTo;
			}
			break;

		case southwest:
			if (this.exits[6].isVisible == true) {
				this.exits[6].leadsTo = roomTo;
			}
			break;
		case southeast:
			if (this.exits[7].isVisible == true) {
				this.exits[7].leadsTo = roomTo;
			}
			break;
		case up:
			if (this.exits[8].isVisible == true) {
				this.exits[8].leadsTo = roomTo;
			}
			break;
		case down:
			if (this.exits[9].isVisible == true) {
				this.exits[9].leadsTo = roomTo;
			}
			break;

		}

	}

	public void newRoom() {

		this.exits[0] = Direction.east;
		this.exits[1] = Direction.west;
		this.exits[2] = Direction.north;
		this.exits[3] = Direction.south;
		this.exits[4] = Direction.northwest;
		this.exits[5] = Direction.northeast;
		this.exits[6] = Direction.southwest;
		this.exits[7] = Direction.southeast;
		this.exits[8] = Direction.up;
		this.exits[9] = Direction.down;

		for (int i = 0; i < this.exits.length; i++) {
			this.exits[i].isVisible = false;
		}
	}
	
	public String getDesc() {
		return desc;
	}

	public Room getToEast() {
		return toEast;
	}

	public void setToEast(Room toEast) {
		this.toEast = toEast;
	}

	public Room getToWest() {
		return toWest;
	}

	public void setToWest(Room toWest) {
		this.toWest = toWest;
	}

	public Room getToNorth() {
		return toNorth;
	}

	public void setToNorth(Room toNorth) {
		this.toNorth = toNorth;
	}

	public Room getToSouth() {
		return toSouth;
	}

	public void setToSouth(Room toSouth) {
		this.toSouth = toSouth;
	}

	public Room getToNorthWest() {
		return toNorthWest;
	}

	public void setToNorthWest(Room toNorthWest) {
		this.toNorthWest = toNorthWest;
	}

	public Room getToNorthEast() {
		return toNorthEast;
	}

	public void setToNorthEast(Room toNorthEast) {
		this.toNorthEast = toNorthEast;
	}

	public Room getToSouthWest() {
		return toSouthWest;
	}

	public void setToSouthWest(Room toSouthWest) {
		this.toSouthWest = toSouthWest;
	}

	public Room getToSouthEast() {
		return toSouthEast;
	}

	public void setToSouthEast(Room toSouthEast) {
		this.toSouthEast = toSouthEast;
	}

	public Room getToUp() {
		return toUp;
	}

	public void setToUp(Room toUp) {
		this.toUp = toUp;
	}

	public Room getToDown() {
		return toDown;
	}

	public void setToDown(Room toDown) {
		this.toDown = toDown;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getRoomTotal() {
		return roomTotal;
	}

	public void setRoomTotal(int roomTotal) {
		this.roomTotal = roomTotal;
	}

	public Direction[] getExits() {
		return exits;
	}

	public int getxVal() {
		return xVal;
	}

	public void setxVal(int xVal) {
		this.xVal = xVal;
	}

	public int getyVal() {
		return yVal;
	}

	public void setyVal(int yVal) {
		this.yVal = yVal;
	}
	public int getzVal() {
		return zVal;
	}

	public void setzVal(int zVal) {
		this.zVal = zVal;
	}
	public void setLoc(int x,int y, int z) {
		this.setxVal(x);
		this.setyVal(y);
		this.setzVal(z);
	}

	public Creature[] getCreatureList() {
		return creatureList;
	}

	public void setCreatureList(Creature[] creatureList) {
		this.creatureList = creatureList;
	}
	public void addToCreatureList(Creature creatureToAdd) {
		Creature[] temp = this.creatureList;
		this.creatureList = new Creature[temp.length + 1];
		for (int i = 0;i < temp.length;i++) {
			this.creatureList[i] = temp[i];
		}
		this.creatureList[temp.length + 1] = creatureToAdd;
	}
}
