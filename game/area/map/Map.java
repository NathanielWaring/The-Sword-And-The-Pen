package game.area.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;



public class Map implements Serializable{

	private static final long serialVersionUID = 1L;

	private Character[][] map;

	private static int xSize;
	private static int ySize;

	private static String fileUrl;
	private int[] riverStart;

	public Map() {
		this(15, 9);
		
	}

	public Map(int xDir, int yDir) {
		map = new Character[xDir][yDir];
		this.setxSize(xDir);
		this.setySize(yDir);
		this.clearMap();
		setFileUrl("mapSave.ser");

	}

	public void randomMap() {
		this.clearMap();
		Random rand = new Random();
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				int randTerrain = rand.nextInt(5);
				Character terrainChar;
				switch (randTerrain) {

				case 0:
					terrainChar = ' ';
					break;
				case 1:
					terrainChar = '.';
					break;
				case 2:
					terrainChar = 'F';
					break;
				case 3:
					terrainChar = 'H';
					break;
				case 4:
					terrainChar = '^';
					break;
				default:
					terrainChar = '.';

				}
				this.setTerrain(terrainChar, i, j);
			}
		}
		riverStart = new int[3];
		riverStart[2] = rand.nextInt(2);
		boolean isX = true;
		int end;
		switch (riverStart[2]) {
		case 0:
			riverStart[0] = 0;
			riverStart[1] = rand.nextInt(ySize - 2) + 1;
			break;
		case 1:
			riverStart[0] = rand.nextInt(xSize - 2) + 1;
			riverStart[1] = 0;
			isX = false;
			break;

		}
		int riverLength = 0;
		if (isX) {
			end = xSize;
		} else {
			end = ySize;
		}
		int curX = riverStart[0];
		int curY = riverStart[1];

		while (riverLength < end) {
			this.setTerrain('R', curX, curY);
			switch (rand.nextInt(3)) {
			case 0:
				if (isX)
					curX++;
				else
					curY++;
				riverLength++;
				break;
			case 1:
				if (isX && curY > 0 && this.getMap()[curX][curY - 1] != 'R'
						&& this.getMap()[Math.abs(curX - 1)][curY - 1] != 'R')
					curY--;
				else if (!isX && curX > 0 && this.getMap()[curX - 1][curY] != 'R'
						&& this.getMap()[curX - 1][Math.abs(curY - 1)] != 'R')
					curX--;
				break;
			case 2:
				if (isX && curY < ySize - 1 && this.getMap()[curX][curY + 1] != 'R'
						&& this.getMap()[Math.abs(curX - 1)][curY + 1] != 'R')
					curY++;
				else if (!isX && curX < xSize - 1 && this.getMap()[curX + 1][curY] != 'R'
						&& this.getMap()[curX + 1][Math.abs(curY - 1)] != 'R')
					curX++;
				break;
			}
		}
	}

	public void clearMap() {
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				map[i][j] = '.';
			}
		}
	}

	
	
	
	public void saveMap() {


		FileOutputStream fileOout = null;
		ObjectOutputStream objectOut = null;

		try {

			fileOout = new FileOutputStream(getFileUrl());
			objectOut = new ObjectOutputStream(fileOout);
			objectOut.writeObject(this);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (fileOout != null) {
				try {
					fileOout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (objectOut != null) {
				try {
					objectOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	
	}
	
	public static Map loadMap(String fileUrl) {
		Map mapOut = null;
		FileInputStream fileIn = null;
		ObjectInputStream objectIn = null;
		
		try {
			
			
			
			fileIn = new FileInputStream(fileUrl);
			objectIn = new ObjectInputStream(fileIn);
			mapOut = (Map) objectIn.readObject();
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			
			if (fileIn!=null) {
				try {
					fileIn.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
			if (objectIn!=null) {
				try {
					objectIn.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}				
		}
	
		return mapOut;
		
	}
	
	
	public String toString() {
		String returnString = "";
		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				returnString += map[i][j];
			}
			returnString += "\n";
		}
		System.out.println(returnString);
		return returnString;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		Map.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		Map.ySize = ySize;
	}

	public Character[][] getMap() {
		return map;
	}

	public void setMap(Character[][] map) {
		this.map = map;
	}

	public void setTerrain(Character terrain, int x, int y) {
		this.map[x][y] = terrain;
	}

	public int[] getRiverStart() {
		return riverStart;
	}
	
	public static String getFileUrl() {
		return fileUrl;
	}



	public void setFileUrl(String fileUrl) {
		Map.fileUrl = fileUrl;
	}

}
