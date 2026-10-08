package main;


import object.ObjBoots;
import object.ObjChest;
import object.ObjFence;
import object.ObjKey;
import object.ObjLilly;

public class AssetSetter {

	GamePanel gp;
	
	
	public AssetSetter(GamePanel gp) {
		
		this.gp = gp;
	}
	
	public void setObject() {
		
		
		
		gp.obj[0] = new ObjLilly();
		gp.obj[0].worldX=  12* gp.tileSize;
		gp.obj[0].worldY= 3 * gp.tileSize;
		
		gp.obj[1] = new ObjLilly();
		gp.obj[1].worldX=  10* gp.tileSize;
		gp.obj[1].worldY= 5* gp.tileSize;
		
		gp.obj[2] = new ObjChest();
		gp.obj[2].worldX=  2* gp.tileSize;
		gp.obj[2].worldY= 2* gp.tileSize;
		
		gp.obj[3] = new ObjChest();
		gp.obj[3].worldX=  13* gp.tileSize;
		gp.obj[3].worldY= 9* gp.tileSize;
		
		gp.obj[4] = new ObjFence();
		gp.obj[4].worldX=  3* gp.tileSize;
		gp.obj[4].worldY= 2* gp.tileSize;
		
		gp.obj[5] = new ObjFence();
		gp.obj[5].worldX=  12* gp.tileSize;
		gp.obj[5].worldY= 9* gp.tileSize;
		
		gp.obj[6] = new ObjKey();
		gp.obj[6].worldX=  2* gp.tileSize;
		gp.obj[6].worldY= 9* gp.tileSize;
		
		gp.obj[7] = new ObjKey();
		gp.obj[7].worldX=  13* gp.tileSize;
		gp.obj[7].worldY= 7* gp.tileSize;
		
		gp.obj[8] = new ObjKey();
		gp.obj[8].worldX=  7* gp.tileSize;
		gp.obj[8].worldY= 1* gp.tileSize;
		
		gp.obj[9] = new ObjKey();
		gp.obj[9].worldX=  1* gp.tileSize;
		gp.obj[9].worldY= 4* gp.tileSize;
		
		gp.obj[10] = new ObjBoots();
		gp.obj[10].worldX=  14* gp.tileSize;
		gp.obj[10].worldY= 7* gp.tileSize;
		
		
		
	}
	
}
 