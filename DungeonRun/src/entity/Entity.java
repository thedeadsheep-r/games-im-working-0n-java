package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {
	
	public int worldX,worldY;
	public int speed;
	
	
	
	public BufferedImage up1, up2;
	public BufferedImage down1, down2;
	public BufferedImage right1, right2;
	public BufferedImage left1, left2;
	public BufferedImage idelup, ideldown;
	public BufferedImage idelleft, idelright;
	

	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefualtX,solidAreaDefualtY;
	public boolean collisionOn = false;
}
