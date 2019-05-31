package game.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JMenuBar menuBar;
	public MainFrame() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		mainPanel = new JPanel();
		mainPanel.setVisible(true);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setPreferredSize(this.getSize());
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("All your base are belong to me!");
		mainPanel.add(textArea);
		menuBar = new TopMenu();
		add(mainPanel);		
		menuBar.setVisible(true);
		this.setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		
		MainFrame theFrame = new MainFrame();
		theFrame.setVisible(true);
		theFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		
	}
}
