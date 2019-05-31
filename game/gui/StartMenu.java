package game.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	public StartMenu() {
		super();
		BufferedImage mapImage = null;
		try {
			mapImage = ImageIO.read(new File("Dragon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel dragonPicture = new JLabel();
		dragonPicture.setIcon(new ImageIcon(mapImage));
		dragonPicture.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(MenuFrame.color_beige);
		panel.setVisible(true);
		panel.setPreferredSize(this.getSize());
		panel.add(dragonPicture);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.add(panel);
		
		// game options popup //
		Object options[] = {"New Game", "Load Game", "Exit"};
		int selected = JOptionPane.showOptionDialog(null, "Welcome.  Please select either  New Game, Load Game, or Exit ", "Welcome", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		MenuFrame menu = new MenuFrame();
		menu.setVisible(true);
		
		switch(selected) {
		case 0:
			System.out.print("option 0 was chosen");
			break;
		case 1:
			System.out.print("option 1 was chosen");
			break;
		case 2:
			System.out.print("option 2 was chosen");
			System.exit(1);
		}
		

	}

}
