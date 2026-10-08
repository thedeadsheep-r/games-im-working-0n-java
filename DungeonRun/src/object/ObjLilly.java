package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjLilly extends SuperObject {
	
	
	public ObjLilly() {
		
		name = "Lilly";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/lily.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	

}
}
