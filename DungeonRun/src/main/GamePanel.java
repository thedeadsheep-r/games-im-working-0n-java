package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.Background;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTING
	final int originalTitleSize = 16; // ref size of character, maps and obj
	final int scale = 3;
	
	public final int tileSize = originalTitleSize * scale; // scaling for bigger display
	public final int maxScreenCol =16; // grib of 3 ratio 4
	public final int maxScreenRow =12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pix
	public final int screenHeight = tileSize * maxScreenRow; // 576 pix
	
	//world Map settings
	
	public final int maxWorldCol=16;
	public final int maxWorldRow=12;
//	public final int worldWidth= tileSize * maxWorldCol;
//  public final int worldHeight= tileSize * maxWorldRow;
	
	
	
	//FPS
	
	int FPS=60;
	
	//tiles
	Background back = new Background(this);
	TileManager tileM = new TileManager(this);
	
	Sound music = new Sound();
	Sound se = new Sound();
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public Player player = new Player (this,keyH);
	public SuperObject obj[] = new SuperObject[100];

	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		
	}
	
	public void setupGame()
	{	
			playMusic(0);
			aSetter.setObject();
		
	}
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		
		double drawInternveral = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInternveral;
		
		while(gameThread != null)
			
			{
			
			// update my lonely player position and update trrain
			update();
			
			repaint();
			
			try {
				double reaminingTime = nextDrawTime - System.nanoTime();
				reaminingTime = reaminingTime/1000000;
				
				if(reaminingTime <0) {
					reaminingTime = 0;
				}
				
				Thread.sleep((long) reaminingTime);
				
				nextDrawTime += drawInternveral;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
		
	}
	
	public void update() {
		
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		back.draw(g2);
		
		tileM.draw(g2);
		
		for (int i=0; i < obj.length; i++)
		{
			if(obj[i] != null)
			{
				obj[i].draw(g2,this);
			}
		}		
		player.draw(g2);
		
		g2.dispose();
		
		
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
public void stopMusic() {
		
		
	music.stop();
	
		
	}

public void playSE(int i) {
	
	se.setFile(i);
	se.play();
	
	
}
	
}
