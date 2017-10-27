package engine;

import java.util.Random;

public class Tag {
	static int tagIdCounter = 0;
	int id;
	boolean identified;
	
	public Tag () {
		this.id = tagIdCounter;
		this.identified = false;
	}
	
	private int transmitToSlot (int frameSize) {
		int randomSlot = new Random().nextInt(frameSize);
		return randomSlot;
	}
}
