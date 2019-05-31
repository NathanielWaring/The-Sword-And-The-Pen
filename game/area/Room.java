package game.area;

public class Room {

	private final int xLoc, yLoc, roomNum;
	private static int roomTotal;
	private String[] exits;
	private String longDesc, shortDesc;

	public Room(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.roomNum = ++roomTotal;

	}

	public String[] getExits() {
		return exits;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public int getxLoc() {
		return xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setExits(String[] exits) {
		this.exits = exits;
	}

	public static int getRoomTotal() {
		return roomTotal;
	}

	public static void setRoomTotal(int roomTotal) {
		Room.roomTotal = roomTotal;
	}

	public int getRoomNum() {
		return roomNum;
	}

}
