package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import game.gui.MainBox;
import game.item.ItemFrame;
import game.item.weapon.Weapon;
import game.item.weapon.Weapon.DamType;
import game.item.weapon.Weapon.WeaponType;
import game.area.map.Map;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import game.Game;
import game.creature.Stats;

public class MenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String[] leftTopButtonsText = { "Inventory", "Character", "Map", "Re-Draw",
			"Log", "Pause", "Exit" };
	private String[] leftBottomButtonsText = { "Fight", "Run Away", "Explore", "Re-Draw",
			"Log", "Back", "Exit" };
	private final static String[] topComboBoxText = { "MENU", "New Game", "Save Game", "Load Game", "Settings",
			"Exit Game" };
	protected static Color color_beige = new Color(210, 180, 140);
	protected static Color color_maroon = new Color(100, 0, 0);
	
	private JLabel welcomeBox;
	private JButton leftTopButtons[] = new JButton[leftTopButtonsText.length];
	private JButton leftBottomButtons[] = new JButton[leftBottomButtonsText.length];
	private JComboBox<String> topComboBox = new JComboBox<String>(topComboBoxText);
	private JPanel bottomPanel, topPanel, mainPanel, leftPanel, rightPanel;
	private Border panelBorder = new LineBorder((Color.GRAY), 2);
	private Border buttonBorder = new EtchedBorder(EtchedBorder.LOWERED);
	private String welcomeText = "    Welcome to The Sword and the Pen, a game of swords, dragons, and typing.   Soooooooooooooooo much typing.   Enjoy!  ";
	private MainBox mainBox = new MainBox();
	private JTextField inputBox = new JTextField();

	private static Game currentGame;


	private Font font_small = new Font("Monospaced", Font.BOLD, 20);
	private Font font_large = new Font("Monospaced", Font.BOLD, 24);
	private String inputString;
	private Map currentMap;
	private MapFrame mapFrame;

	private ItemFrame itemFrame;

	public MenuFrame() {

		// MenuFrame's own parameters //

		super("The Sword and the Pen");

		UIManager.put("OptionPane.messageFont", font_small);
		UIManager.put("OptionPane.buttonFont", font_small);
		UIManager.put("TextField.font", font_small);
		UIManager.put("OptionPane.font", font_small);
		UIManager.put("ComboBox.font", font_small);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
                                                       

		// welcomeBox //

		welcomeBox = new JLabel();
		welcomeBox.setText(welcomeText);
		welcomeBox.setFont(font_large);
		welcomeBox.setVisible(true);
		welcomeBox.setBackground(color_beige);
		welcomeBox.setOpaque(true);
		welcomeBox.setPreferredSize(new Dimension(this.getWidth() - 180, 50));

		// inputBox //

		BottomTextFieldListener bottomTextFieldListener = new BottomTextFieldListener();
		inputBox.setFont(font_small);
		inputBox.setVisible(true);
		inputBox.setBorder(buttonBorder);
		inputBox.setEditable(true);
		inputBox.setPreferredSize(new Dimension(this.getWidth() - 30, 30));
		inputBox.addActionListener(bottomTextFieldListener);

		// itemFrame //
		itemFrame = new ItemFrame();
		itemFrame.setLocation(100,100);
		itemFrame.setVisible(false);
		
		
		
		
		// leftButtons //

		LeftTopButtonListener leftTopButtonListener = new LeftTopButtonListener();
		LeftBottomButtonListener leftBottomButtonListener = new LeftBottomButtonListener();
		Box leftPanelBox = Box.createVerticalBox();
		Box leftTopButtonBox = Box.createVerticalBox();
		Box leftBottomButtonBox = Box.createVerticalBox();
		JButton leftPanelButtonSpacer = new JButton("              ");
		leftPanelButtonSpacer.setVisible(true);
		leftPanelButtonSpacer.setBackground(color_maroon);
		leftPanelButtonSpacer.setOpaque(false);
		leftPanelButtonSpacer.setFont(font_small);
		leftPanelButtonSpacer.setBorder(null);
		for (int i = 0; i < leftTopButtons.length; i++) {
			String tempName = leftTopButtonsText[i];
			tempName = buttonSize(tempName);
			JButton temp = new JButton(tempName);
			leftTopButtons[i] = temp;
			leftTopButtons[i].setBorder(buttonBorder);
			leftTopButtons[i].setFont(font_small);
			leftTopButtons[i].setBackground(color_beige);
			leftTopButtons[i].addActionListener(leftTopButtonListener);
			leftTopButtons[i].setSize(50, 20);
			leftTopButtonBox.add(leftTopButtons[i]);
		}
		for (int i = 0; i < leftBottomButtons.length; i++) {
			String tempName = leftBottomButtonsText[i];
			tempName = buttonSize(tempName);
			JButton temp = new JButton(tempName);
			leftBottomButtons[i] = temp;
			leftBottomButtons[i].setBorder(buttonBorder);
			leftBottomButtons[i].setFont(font_small);
			leftBottomButtons[i].setBackground(color_beige);
			leftBottomButtons[i].addActionListener(leftBottomButtonListener);
			leftBottomButtons[i].setSize(50, 20);
			leftBottomButtons[i].setVisible(false);
			leftBottomButtonBox.add(leftBottomButtons[i]);
		}
		leftTopButtons[3].setVisible(false);
		leftPanelBox.add(leftTopButtonBox);
		leftPanelBox.add(leftPanelButtonSpacer);
		leftPanelBox.add(leftBottomButtonBox);

		// topComboBox //

		TopComboBoxListener topComboBoxListener = new TopComboBoxListener();
		topComboBox.setBorder(buttonBorder);
		topComboBox.setVisible(true);
		topComboBox.setEditable(false);
		topComboBox.setBackground(color_beige);
		topComboBox.setFont(font_small);
		topComboBox.addActionListener(topComboBoxListener);

		// mainBox //

		MainBox.setNumCharacters((this.getWidth() - 200) / 10 - 2);
		mainBox.setVisible(true);
		mainBox.setBorder(panelBorder);
		mainBox.setBackground(color_beige);
		mainBox.setEditable(false);
		mainBox.setPreferredSize(new Dimension(this.getWidth() - 200, this.getHeight() - 120));
		mainBox.setNumLines((this.getHeight() - 120) / 24);
		mainBox.setFont(new Font("Monospaced", Font.BOLD, 16));
		mainBox.welcomeMessage();

		// mapFrame //

		currentMap = new Map(((int) this.getWidth() - 200) / 90, ((int) this.getHeight() - 80) / 90);
		mapFrame = new MapFrame(currentMap.getMap(), currentMap.getxSize(), currentMap.getySize());
		mapFrame.setLocation(200, 65);
		mapFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mapFrame.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		        final int x = e.getX();
		        final int y = e.getY();
		        // only display a hand if the cursor is over the items
		        final Rectangle cellBounds = mapFrame.getBounds();
		        if (cellBounds != null && cellBounds.contains(x, y)) {
		        	mapFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		        } else {
		        	mapFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        }
		    }



			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		

		// bottonPanel //

		bottomPanel = new JPanel();
		bottomPanel.setBorder(panelBorder);
		bottomPanel.setVisible(true);
		bottomPanel.setBackground(color_maroon);
		bottomPanel.add(inputBox);

		// mainPanel //

		mainPanel = new JPanel();
		mainPanel.setBorder(panelBorder);
		mainPanel.setVisible(true);
		mainPanel.setBackground(color_maroon);
		mainPanel.add(mainBox);

		// topPanel //

		topPanel = new JPanel();
		topPanel.setBorder(panelBorder);
		topPanel.add(topComboBox);
		topPanel.setVisible(true);
		topPanel.setBackground(color_maroon);
		topPanel.add(welcomeBox);

		// rightPanel //

		rightPanel = new JPanel();
		rightPanel.setBorder(panelBorder);
		rightPanel.setSize(100, this.getHeight());
		rightPanel.setVisible(false);
		rightPanel.setBackground(color_maroon);

		// leftPanel //

		leftPanel = new JPanel();
		leftPanel.setBorder(panelBorder);
		leftPanel.setPreferredSize(new Dimension(200, this.getHeight()));
		leftPanel.setVisible(true);
		leftPanel.setBackground(color_maroon);
		leftPanel.add(leftPanelBox);

		// add above panels to this Frame //

		add(bottomPanel, BorderLayout.SOUTH);
		add(mainPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		

		// startup screen //
		//StartMenu start = new StartMenu();
		//start.setVisible(true);
	}

	private String buttonSize(String tempName) {
		while (tempName.length() < 15) {
			switch(tempName.length()%2) {
			case 0:
				tempName = tempName + " ";
				break;
			case 1:
				tempName = " " + tempName;
				break;
			}
		}
		return tempName;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	private class LeftTopButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String textString;

			// Inventory //

			if (event.getSource() == leftTopButtons[0]) {

				try {
					textString = currentGame.thePlayer.getInventory().toString();
				} catch (NullPointerException e) {
					e.printStackTrace();
					textString = "No game loaded, please Load a game.";
				}
				itemFrame.setVisible(itemFrame.isVisible());
				

				String[] textArray = textString.split("\\n");
				for (int i = 0; i < textArray.length; i++) {
					mainBox.addLine(textArray[i]);
				}

			}
			// Character //

			else if (event.getSource() == leftTopButtons[1]) {

				try {
					textString = currentGame.thePlayer.toString();
				} catch (NullPointerException e) {
					e.printStackTrace();
					textString = "No game loaded, please Load a game.";
				}
				String[] textArray = textString.split("\\n");
				for (int i = 0; i < textArray.length; i++) {
					mainBox.addLine(textArray[i]);
				}			
			}			
			// Map //

			else if (event.getSource() == leftTopButtons[2]) {
				if (leftTopButtons[2].getBackground().equals(color_beige)) {
					leftTopButtons[2].setBackground(Color.GRAY);
					leftBottomButtons[2].setVisible(true);
					mapFrame.setVisible(true);
					leftTopButtons[3].setVisible(true);
					// leftTopButtons[0].setOpaque(false);
				} else {
					leftTopButtons[2].setBackground(color_beige);
					mapFrame.setVisible(false);
					leftBottomButtons[2].setVisible(false);
					leftTopButtons[3].setVisible(false);
					// leftTopButtons[0].setOpaque(true);
				}
			}
			// Explore //

			else if (event.getSource() == leftTopButtons[3]) {

				mapFrame.setVisible(false);
				currentMap.randomMap();
				mapFrame = new MapFrame(currentMap.getMap(), currentMap.getxSize(), currentMap.getySize());
				mapFrame.setLocation(200, 65);
				mapFrame.setVisible(true);
				leftTopButtons[2].setBackground(Color.GRAY);
			}
			// Log //

			else if (event.getSource() == leftTopButtons[4]) {
				cheat();

			}
			// Pause //

			else if (event.getSource() == leftTopButtons[5]) {
				currentGame.tick.setPause(!currentGame.tick.isPaused());
			}
			
			// Exit //

			else if (event.getSource() == leftTopButtons[6]) {
				System.exit(EXIT_ON_CLOSE);
			}

		}

	}

	private class LeftBottomButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == leftTopButtons[0]) {

			} else if (event.getSource() == leftTopButtons[1]) {

			} else if (event.getSource() == leftTopButtons[2]) {

			} else if (event.getSource() == leftTopButtons[3]) {

			} else if (event.getSource() == leftTopButtons[4]) {

			} else if (event.getSource() == leftTopButtons[5]) {

			} else if (event.getSource() == leftTopButtons[6]) {

			}

		}
	}

	private class TopComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			JComboBox<?> cb = (JComboBox<?>) event.getSource();
			String selected = (String) cb.getSelectedItem();

			// MENU selected //

			if (selected.equals(topComboBoxText[0])) {

				// New Game selected //

			} else if (selected.equals(topComboBoxText[1])) {
				newGame();
				cb.setSelectedItem(topComboBoxText[0]);

				// Save Game selected //

			} else if (selected.equals(topComboBoxText[2])) {
				saveGame();
				cb.setSelectedItem(topComboBoxText[0]);

				// Load Game selected //

			} else if (selected.equals(topComboBoxText[3])) {
				loadGame();
				cb.setSelectedItem(topComboBoxText[0]);

				// Settings selected //

			} else if (selected.equals(topComboBoxText[4])) {

				cb.setSelectedItem(topComboBoxText[0]);

				// Exit Game selected //

			} else if (selected.equals(topComboBoxText[5])) {
				System.exit(0);
			}
		}
	}

	private class BottomTextFieldListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == inputBox) {
				setInputString(inputBox.getText());
				inputBox.setText("");
				mainBox.addLine(getInputString());

			}
		}
	}

	public static Color getColor_beige() {
		return color_beige;
	}

	public Color getColor_maroon() {
		return color_maroon;
	}
	
	public static Game getCurrentGame() {
		return currentGame;
	}
	
	public void cheat() {
		JOptionPane.showMessageDialog(null, "CHEAT MODE ACTIVATED!!!");
		Weapon newItem = new Weapon("Excalibur", 150, 150, 6, 10, 2, 4, 10, WeaponType.sword, DamType.fire, true);
		currentGame.thePlayer.getInventory().addItem(newItem);
		currentGame.thePlayer.setLevel(40);
		currentGame.thePlayer.setStats(Stats.statGenerator(currentGame.thePlayer.getRace(),
				currentGame.thePlayer.getGuildType(), currentGame.thePlayer.getLevel()));
	}
	
	public void  newGame() {
		mapFrame.setVisible(false);
		currentGame = new Game();
		currentGame.newGame();
		currentMap.randomMap();
		mapFrame = new MapFrame(currentMap.getMap(), currentMap.getxSize(), currentMap.getySize());
		mapFrame.setLocation(200, 65);
		leftPanel.setVisible(true);
		
	}

	public void saveGame() {
		currentGame.saveGame(currentGame.gameID);
		currentMap.saveMap();
	}
	public void loadGame() {
		mapFrame.setVisible(false);
		leftTopButtons[2].setBackground(color_beige);
		currentGame = new Game();
		currentGame = (Game) Game.loadGame(Game.getFileUrl() + currentGame.gameID);
		currentMap = new Map(((int) getWidth() - 200) / 90, ((int) getHeight() - 80) / 90);
		currentMap = (Map) Map.loadMap(Map.getFileUrl());
		String loadText = "Welcome Back, the realm awaits your leadership.";
		mainBox.addLine(loadText);
		mapFrame = new MapFrame(currentMap.getMap(), currentMap.getxSize(), currentMap.getySize());
		mapFrame.setLocation(200, 65);

	}

}
