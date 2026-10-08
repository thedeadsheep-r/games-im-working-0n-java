package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Background {
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	
	public Background(GamePanel gp)
	{
		this.gp = gp;
		tile = new  Tile[1];
		mapTileNum = new int [gp.maxScreenCol][gp.maxScreenRow];
		
		getTileIamge();
		
	}
	
	public void getTileIamge()
	{
try {
	
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/black.png"));
			

		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
		
	

	public void draw(Graphics2D g2) 
	{
		// for testing
		//g2.setColor(Color.white);
		//g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		int col=0;
		int row =0;
		int x=0;
		int y= 0;
		
		while (col < gp.maxScreenCol && row <gp.maxScreenRow)
			{
		
			
			g2.drawImage(tile[0].image,x,y, gp.tileSize,gp.tileSize, null);
			
			col++;
			x+= gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				
				col =0;
				x=0;
				row++;
				y += gp.tileSize;
			}
			}
		
	}
	
	
	
	
	
	
	
	
	
}
