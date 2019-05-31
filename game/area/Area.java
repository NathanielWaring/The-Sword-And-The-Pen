package game.area;

import java.util.Random;
import game.area.room.Room;


public class Area {
	private static final boolean DEBUG = false;
	public boolean[][][] areaMap;
	public Room[] roomList;
	public int[][] add;
	private int xSize, ySize, zSize;
	protected int numAdded;
	protected Random rand = new Random();
	
	public Area(int x, int y, int z, int numRooms) {


		this.xSize = x;
		this.ySize = y;
		this.zSize = z;
		this.areaMap = new boolean[x][y][z];
		this.roomList = new Room[numRooms];
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				for (int k = 0; k < zSize; k++) {
				areaMap[i][j][k] = false;
			}
		}
		}
	}
		
		
		
		public void randomMap (boolean[][][] areaMap, int numRooms, int xSize, int ySize, int zSize) {
		this.numAdded = 0;
		int randToAddTo;
		add = new int[numRooms][4];
		int defaultHeight = zSize / 2;
		add[0][0] = xSize / 2;
		add[0][1] = ySize / 2;
		add[1][1] = xSize / 2;
		add[1][0] = ySize / 2 + 1;
		add[0][3] = 1;
		add[1][3] = 0;

		numAdded++;

		while (numAdded < numRooms - 1) {
			randToAddTo = Math.abs(numAdded - rand.nextInt(2));
			add[numAdded + 1][0] = Math.abs(add[randToAddTo][0] + rand.nextInt(2) - 1);
			add[numAdded + 1][1] = Math.abs(add[randToAddTo][1] + rand.nextInt(2) - 1);
			add[numAdded + 1][3] = randToAddTo;
			
			
			
			if (!this.areaMap[add[numAdded + 1][0]][add[numAdded + 1][1]][defaultHeight]) {
				this.areaMap[add[numAdded + 1][0]][add[numAdded + 1][1]][defaultHeight] = true;
				
				
				numAdded++;
			}

		}

	}
		
	public void addRoom(Room roomToAdd) {
		this.roomList[this.numAdded + 1] = roomToAdd;
		this.numAdded++;
		
		}
	public void printMap(int xDir, int yDir, int zDir) {
		for (int k = 0; k < zDir; k++) {
		for (int i = yDir - 1; i >= 0; i--) {
			for (int j = 0; j < xDir; j++) {

				if (this.areaMap[j][i][k] == true) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}
				
				}
			System.out.println("");

			}
			System.out.println("");
			System.out.println("");
		}

		if (DEBUG) {
			System.out.println("");
			for (int i = 0; i < 15; i++) {
				System.out.print(this.add[i][0] + " " + this.add[i][1] + " " + this.add[i][2] + " | ");
			}
		}
	}

}
