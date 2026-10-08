package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjFence extends SuperObject {
	
	
	public ObjFence() {
		
		name = "Fence";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/fence.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	collision = true;

}
}