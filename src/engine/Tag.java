package engine;

import java.util.*;

public class Tag {
	public static int tagIdCounter = 0;
	int id;
	LinkedList <Integer> transmitLog;
	boolean identified;
	
	public Tag () {
		this.id = tagIdCounter;
		transmitLog = new LinkedList<Integer>();
		this.identified = false;
		
		tagIdCounter++;
	}
	
	int transmitToSlot (int frameSize) {
		int randomSlot = new Random().nextInt(frameSize);
		transmitLog.add(randomSlot);
		return randomSlot;
	}
}
