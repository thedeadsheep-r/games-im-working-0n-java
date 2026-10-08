package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	
	public TileManager(GamePanel gp)
	{
		this.gp = gp;
		tile = new  Tile[100];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		
		getTileIamge();
		loadMap("/maps/map00.txt");
		
	}
	
	public void getTileIamge()
	{
try {
	
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[1].collision = true;
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/pond.png"));
			tile[2].collision = true;
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[3].collision = true;
			
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road.png"));
			
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_bottom.png"));
			tile[5].collision = true;
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_left.png"));
			tile[6].collision = true;
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_up.png"));
			tile[7].collision = true;
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_right.png"));
			tile[8].collision = true;
			
			
			
			
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/entrance.png"));
			tile[9].collision = true;
			
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_cornor_1.png"));
			tile[10].collision = true;
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_cornor_2.png"));
			tile[11].collision = true;
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_cornor_3.png"));
			tile[12].collision = true;
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/edge_cornor_4.png"));
			tile[13].collision = true;
	
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/splant.png"));
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[15].collision = true;
			

			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sign.png"));
			tile[16].collision = true;

		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void loadMap(String filepath)
	{
		try {
			InputStream is = getClass().getResourceAsStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader (is));
			
			
			int col=0;
			int row =0;
		
			while (col < gp.maxWorldCol && row <gp.maxWorldRow)
			{
				String line = br.readLine();
				while (col < gp.maxWorldCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum [col][row] =num;
					col++;
				}
				
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			 br.close(); //ofc i close a buffer reader im not a savage
			
		}catch(Exception e) {}
	}
		
	

	public void draw(Graphics2D g2) 
	{
		// for testing
		//g2.setColor(Color.white);
		//g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		int worldCol=0;
		int worldRow =0;
	
		
		while (worldCol < gp.maxWorldCol &&  worldRow <gp.maxWorldRow)
			{
			int tileNum = mapTileNum[worldCol][ worldRow];
			
			int WorldX = worldCol * gp.tileSize;
			int WorldY = worldRow * gp.tileSize;
			
			int ScreenX = WorldX - gp.player.worldX + gp.player.screenX;
			int ScreenY = WorldY - gp.player.worldY + gp.player.screenY;
			
			if( WorldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
				WorldX - gp.tileSize< gp.player.worldX + gp.player.screenX &&
				WorldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
				WorldY - gp.tileSize< gp.player.worldY + gp.player.screenY )
			
			{g2.drawImage(tile[tileNum].image,ScreenX,ScreenY, gp.tileSize,gp.tileSize, null);
			}
			worldCol++;
			
			
			if(worldCol == gp.maxScreenCol) {
				
				worldCol =0;
				
				 worldRow++;
				
			}
			}
		
	}
	
	
	
	
	
	
	
	
	
}
