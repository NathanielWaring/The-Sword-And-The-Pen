package game.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapFrame extends JFrame {
	private int xSize, ySize;
	private static final long serialVersionUID = 1L;
	private JLabel[][] mapLabels;

	public MapFrame(Character[][] currentMap, int xSize, int ySize) {
		super();
		this.setMap(currentMap, xSize, ySize);
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public void setMap(Character[][] currentMap, int xSize, int ySize) {

		this.setBackground(MenuFrame.getColor_beige());
		this.setLayout(new GridLayout(ySize, xSize));
		this.setVisible(false);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(90 * xSize, 90 * ySize));
		this.setSize(this.getPreferredSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mapLabels = new JLabel[xSize][ySize];
		for (int j = 0; j < ySize; j++) {
			for (int i = 0; i < xSize; i++) {

				String imgUrl = null;
				switch (currentMap[i][j]) {
				case ' ':
					imgUrl = "terrain\\desert.jpg";
					break;
				case '.':
					imgUrl = "terrain\\grassland.jpg";
					break;
				case 'F':
					imgUrl = "terrain\\forest.jpg";
					break;
				case 'H':
					imgUrl = "terrain\\hills.jpg";
					break;
				case '^':
					imgUrl = "terrain\\mountain.jpg";
					break;
				case 'R':
					boolean[] riverType = { false, false, false, false };
					int numEdges = 0;

					if (i < xSize - 1)
						if (currentMap[i + 1][j] == 'R') {
							riverType[0] = true;
							numEdges++;
						}
					if (i > 0)
						if (currentMap[i - 1][j] == 'R') {
							riverType[1] = true;
							numEdges++;
						}
					if (j < ySize - 1)
						if (currentMap[i][j + 1] == 'R') {
							riverType[2] = true;
							numEdges++;
						}
					if (j > 0)
						if (currentMap[i][j - 1] == 'R') {
							riverType[3] = true;
							numEdges++;
						}
					if (numEdges < 2) {
						if (riverType[0]) {
							imgUrl = "terrain\\river_e.jpg";
							break;
						} else if (riverType[1]) {
							imgUrl = "terrain\\river_w.jpg";
							break;
						} else if (riverType[2]) {
							imgUrl = "terrain\\river_s.jpg";
							break;
						} else if (riverType[3]) {
							imgUrl = "terrain\\river_n.jpg";
							break;
						}
					}
					if (riverType[0] && riverType[1]) {
						imgUrl = "terrain\\river_ew.jpg";
					} else if (riverType[0] && riverType[2]) {
						imgUrl = "terrain\\river_se.jpg";
					} else if (riverType[0] && riverType[3]) {
						imgUrl = "terrain\\river_ne.jpg";
					} else if (riverType[1] && riverType[2]) {
						imgUrl = "terrain\\river_sw.jpg";
					} else if (riverType[1] && riverType[3]) {
						imgUrl = "terrain\\river_nw.jpg";
					} else if (riverType[2] && riverType[3]) {
						imgUrl = "terrain\\river_ns.jpg";
					}
					break;
				default:
					imgUrl = "terrain\\desert.jpg";
					break;
				}
				BufferedImage mapImage = null;
				try {
					mapImage = ImageIO.read(new File(imgUrl));
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (mapImage != null) {
					JLabel tempLabel = new JLabel();
					tempLabel.setIcon(new ImageIcon(mapImage));
					mapLabels[i][j] = tempLabel;
					mapLabels[i][j].setVisible(true);
					this.add(mapLabels[i][j]);
				}
			}
		}
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
}
