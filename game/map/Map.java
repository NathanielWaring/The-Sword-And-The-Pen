package game.map;


		import java.awt.BorderLayout;
		import java.awt.Font;

		import javax.swing.JButton;
		import javax.swing.JFrame;
		import javax.swing.JLabel;
		import javax.swing.JSlider;
		import javax.swing.JTextArea;
		import javax.swing.event.ChangeEvent;
		import javax.swing.event.ChangeListener;

		public class Map {
			private int jSlideY;
			private int jSlideX;

			public void map(int mapX, int mapY) {
		int mapXtot = 2 * mapX + 1;
		int mapYtot = 2 * mapY + 1;
				String[][] printString = new String[mapXtot][mapYtot];
				for (int i = 0; i < mapYtot; i++) {
					for (int j = 0; j < mapXtot; j++) {
						printString[j][i] = "";

						for (int k = 0; k < mapYtot; k++) {
							for (int l = 0; l < mapXtot; l++) {
								if ((k == i && l == j)||(k - 1 == i && l == j)||(k + 1 == i && l == j)||(k == i && l - 1 == j)||(k == i && l + 1 == j)) {
									printString[j][i] += "@";
								} else if (l == 0 || l == mapXtot - 1 | k == 0 || k == mapYtot - 1) {
									
									printString[j][i] += "#";
									
								} else {
									printString[j][i] += ".";
								}
							}
							printString[j][i] += "\n";
						}
					}
				}

				JFrame frame = new JFrame();

				JLabel label = new JLabel();
				JButton backButton = new JButton();

				JTextArea text = new JTextArea(400, 100);

				JSlider sliderY = new JSlider(JSlider.VERTICAL, -mapY + 1, mapY - 1, 0);
				JSlider sliderX = new JSlider(JSlider.HORIZONTAL, -mapX + 1, mapX - 1, 0);
				backButton.setOpaque(true);
				backButton.setVisible(true);
				label.setOpaque(true);
				text.setFont(new Font("Monospaced", Font.BOLD, 20));
				text.setVisible(true);
				frame.setSize(600, 200);
				frame.add(backButton);
				sliderY.setMajorTickSpacing(1);
				sliderX.setMajorTickSpacing(1);

				sliderY.setMinorTickSpacing(1);
				sliderX.setMinorTickSpacing(1);

				sliderY.setPaintLabels(true);
				sliderX.setPaintLabels(true);

				sliderY.setPaintTicks(true);
				sliderX.setPaintTicks(true);
				text.setText(printString[mapX][mapY]);

				frame.add(text);
				text.setVisible(true);
				
				sliderY.addChangeListener(new ChangeListener() {

					@Override

					public void stateChanged(ChangeEvent e) {

						JSlider sourceY = (JSlider) e.getSource();
						jSlideY = mapY - sourceY.getValue();
						text.setText(printString[jSlideX][jSlideY]);
						frame.add(text);

					}

				});
				sliderX.addChangeListener(new ChangeListener() {

					@Override

					public void stateChanged(ChangeEvent e) {

						JSlider sourceX = (JSlider) e.getSource();
						jSlideX = mapX + sourceX.getValue();
						text.setText(printString[jSlideX][jSlideY]);
						frame.add(text);

					}

				});

				frame.add(label, BorderLayout.CENTER);
				frame.setSize(600, 200);

				frame.add(sliderY, BorderLayout.WEST);
				frame.add(sliderX, BorderLayout.SOUTH);

				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.pack();

				frame.setVisible(true);

			}
		}





