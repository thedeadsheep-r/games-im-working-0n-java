package entity;

import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	int hasKey = 0;
	ArrayList<Integer> chestID = new ArrayList<Integer>();
	boolean motion = false;
	

	
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp=gp;
		this.keyH=keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle(8, 16, 22, 22);
		
		solidAreaDefualtX = solidArea.x;
		solidAreaDefualtY = solidArea.y;
		setDefaultValues();
		getPlayerImage();
		direction ="down";
		
	}
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize *5;
		worldY= gp.tileSize *2;
		speed= 2;
		chestID.add(2);
		chestID.add(3);
		
		
	}
	
	public void getPlayerImage()
	{
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
	        up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
	        left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
	        left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
	        down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
	        down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
	        right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
	        right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
	        idelup = ImageIO.read(getClass().getResourceAsStream("/player/boy_idel_up.png"));
	        ideldown = ImageIO.read(getClass().getResourceAsStream("/player/boy_idel_down.png"));
	        idelleft = ImageIO.read(getClass().getResourceAsStream("/player/boy_idel_left.png"));
	        idelright = ImageIO.read(getClass().getResourceAsStream("/player/boy_idel_right.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}

	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true|| keyH.rightPressed == true) {
			
			motion = true;
			
			if(keyH.upPressed == true)
			{ direction = "up";
			}
			else if(keyH.downPressed == true)
			{direction = "down";
				
			}
			else if(keyH.leftPressed == true)
			{
				direction = "left";
				
			}
			else if(keyH.rightPressed == true)
			{
				direction = "right";
				
			}
			// check collison 
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//chect for interavtion with obj
			
			int objIndex = gp.cChecker.checkObject(this,true);
			pickUpObject(objIndex);
			
			// check collison if false palyer can move
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":	worldY -= speed;	break;
				case "down":worldY += speed;	break;
				case "left":worldX -= speed;	break;
				case "right":worldX += speed;	break;
				}
			}
			
			spriteCounter++;
			if (spriteCounter >20) {
				if (spriteNum == 1) {
					spriteNum =2;
				}
			else if (spriteNum == 2) {
					spriteNum =1;
				}
				spriteCounter=0;
			}
			
			
		}else {
			
			motion = false;
			
			if(keyH.upPressed == true)
			{ direction = "up";
			}
			else if(keyH.downPressed == true)
			{direction = "down";
				
			}
			else if(keyH.leftPressed == true)
			{
				direction = "left";
				
			}
			else if(keyH.rightPressed == true)
			{
				direction = "right";
				
			}
		}
		
	}
	
	public void pickUpObject(int i) {
		
		
		
		
		if(i !=999) {
			
			String objectName = gp.obj[i].name;
			
			
			switch(objectName) {
			
			case "Key":
				hasKey++;
				gp.obj[i] = null;
				gp.playSE(2);
				
				break;
				
				
			case "Fence":
					if(hasKey>0)
					{
						gp.obj[i] = null;
						gp.playSE(1);
						hasKey--;
						}
					break;
				case "Chest":
					
					
						int ID = i;
						boolean check = chestID.contains(ID);
					
					if(hasKey>0 && check == true && keyH.qPressed == true)
					{
						
						try {
						gp.obj[i].image = ImageIO.read(getClass().getResourceAsStream("/objects/chest_open.png"));;
							}catch(IOException e) {
								e.printStackTrace();}
							hasKey--;
							gp.playSE(4);
							int k = chestID.indexOf(ID);
							chestID.remove(k);
							
						
							break;
					}
					
					
					
					break;
					
				case "Boots":
					gp.obj[i] = null;
					gp.playSE(3);
					speed =4;
	
					break;
			
			}
			
		}
		
		
	}
	
	
	
	public void draw(Graphics2D g2) 
	{
		// for testing
		//g2.setColor(Color.white);
		//g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			
			if (motion) {
				
			if (spriteNum == 1) {
			image = up1;}
			if (spriteNum == 2) {
				image = up2;}
			}
			
			else {
				image=idelup;
				
			}
			break;
		case "down":
			if (motion) {
			if (spriteNum == 1) {
			image = down1;}
			if (spriteNum == 2) {
				image = down2;}
			}
			
			else {
				image=ideldown;
				
			}
			break;
		case "left":
			if (motion) {
			if (spriteNum == 1) {
			image = left1;}
			if (spriteNum == 2) {
				image = left2;}
		}
		
		else {
			image=idelleft;
			
		}
			
			break;
		case "right":
			if (motion) {
			if (spriteNum == 1) {
			image = right1;}
			if (spriteNum == 2) {
				image = right2;}
			}
			
			else {
				image=idelright;
				
			}
			break;
		
		
		}
		g2.drawImage(image,screenX,screenY, gp.tileSize,gp.tileSize, null);
	}
}
