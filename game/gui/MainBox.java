package game.gui;

import javax.swing.JTextArea;

public class MainBox extends JTextArea {

	private static final long serialVersionUID = 1L;
	private static int numLines = 40;
	private static int numCharacters = 160;

	private static int loggedLines = 1;
	private String[] boxText;

	public MainBox() {
		super();
		boxText = new String[loggedLines];
		boxText[0] = "";


	}

	public MainBox(int xSize, int ySize) {
		super(xSize, ySize);
		boxText = new String[loggedLines];
		boxText[0] = "";

	}

	public void addLine(String newLine) {
		int delimPoint = MainBox.getNumCharacters();
		if (newLine.length() > delimPoint) {
			while (newLine.charAt(delimPoint) != ' ') {
				delimPoint--;
			}
			this.addLine(newLine.substring(0, delimPoint));
			this.addLine(newLine.substring(delimPoint));

		} else {
			String[] tempText = boxText;
			String tempLine;
			boxText = new String[++loggedLines];
			boxText[0] = newLine;
			for (int i = 0; i < loggedLines - 1; i++) {
				boxText[i + 1] = tempText[i];
			}
			String newText = "";
			for (int j = numLines; j >= 0; j--) {
				if (j > loggedLines - 1) {
					newText += "\n";
				} else {
					
					tempLine = boxText[j];

					if (tempLine.length()>0) {
						Character tempChar = tempLine.charAt(0);
						if (!tempChar.equals(' ')) {
					
						tempLine = " " + tempLine;
						}
						}
					int lineLength = tempLine.length();

					while (lineLength < this.getWidth() / 10) {
						tempLine += " ";
						lineLength++;
					}

					newText += tempLine + " " + "\n";
				}

			}
			this.setText(newText);
		}
	}

	public void welcomeMessage() {

		int firstHalf = (MainBox.getNumCharacters() - 102)/2 + 1;
		int secondHalf = MainBox.getNumCharacters() - 102 - firstHalf;
		String firstHalfSpaces = "";
		String secondHalfSpaces = "";
		for (int i = 0;i < firstHalf;i++) {
			firstHalfSpaces += " ";
		}
		for (int i = 0;i < secondHalf;i++) {
			secondHalfSpaces += " ";
		}
		this.addLine("");
		this.addLine("");
		this.addLine("" + firstHalfSpaces + "*------------------------------------------------------------------------------------------------*" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                                                                                                |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|    ##### #  # ####                                                                             |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # #         #####   #   #   #    ###    #####   ####                               |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #### ###      #     #  #   #   #   #   #   #    #  #   #                              |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # #        #        #   #   #  #     #  #    #  #    #     #    #   #  ###         |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # ####      #####   #   #   #  #     #  #####   #    #    # #   ##  #  #  #        |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                              #   # # # #   #     #  #  #    #    #   #####  # # #  #  #        |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                        #     #   # # # #    #   #   #   #   #   #    #   #  #  ##  #  #        |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                         #####     #   #      ###    #    #  ####     #   #  #   #  ###         |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                                                                                                |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|    ##### #  # ####                                                 /|          ______          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # #          #####    #######  #       #              //          /~~ ~~/          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #### ###        #    #   #        ##      #             //           |~~~~ |          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # #          #     #  #        # #     #            //            |~~ ~ |          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|      #   #  # ####       #     #  #        #  #    #           //      @))))))))>   |          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                          #    #   #####    #   #   #        @>//              |     |          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                          #####    #        #    #  #         //<@       _     /_____/          |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                          #        #        #     # #        //         |@|                     |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                          #        #        #      ##       ()         (@@@)                    |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                          #        #######  #       #                                           |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "|                                                                                                |" + secondHalfSpaces);
		this.addLine("" + firstHalfSpaces + "*------------------------------------------------------------------------------------------------*" + secondHalfSpaces);
		this.addLine("");
		this.addLine("");
		this.addLine("");
		String welcomeText = "Welcome to the Sword and the pen, a game of monsters, magic, weapons and words.  Preprare yourself for a journey on which your wits and your fotitude will be tested.  If you are ready to procede, Please select either \"New Game\" or \"Load Game\" from the menu above.  If you choose new game, and this is your first time, please be aware you will be prompted to select a name, a race, a gender, and a guild.  These will determine what paths you take in the game, and the type of character you create, so make sure your choices are ones you will be happy playing with.";
		this.addLine(welcomeText);
		while (loggedLines<numLines) {
			this.addLine("");
		}
	}

	public static int getNumCharacters() {
		return numCharacters;
	}

	public static void setNumCharacters(int numCharacters) {
		MainBox.numCharacters = numCharacters;
	}

	public int getNumLines() {
		return numLines;
	}

	public void setNumLines(int numLines) {
		MainBox.numLines = numLines;
	}

}
