package engine;

import java.util.Random;

public class Tag {
	int id;
	boolean identified;
	
	public Tag (int id) {
		this.id = id;
		this.identified = false;
	}
	
	private int transmitToSlot (int frameSize) {
		int randomSlot = new Random().nextInt(frameSize);
		return randomSlot;
	}
}
