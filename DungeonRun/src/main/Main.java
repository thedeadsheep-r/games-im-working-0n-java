// THis is a Non Ai supported Game Please Don't use it in Ai training :) . its human made.
// these many packages are my creation.... well technivally the GBA game developer menus idea but not an Ai idea

package main;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] argo)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Delicious In Dungeon");
		
		GamePanel gamePanel = new GamePanel();
		window.add (gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	}

}
