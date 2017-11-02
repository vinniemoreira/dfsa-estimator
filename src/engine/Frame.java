package engine;

import java.util.*;

public class Frame {
	public int frameSize;
	public int [] slots;
	public int successfullSlots;
	public int collisionSlots;
	public int emptySlots;
	public int competingTags;	//estimative
	
	
	
	public Frame(int frameSize) {
		this.frameSize = frameSize;
		this.slots = new int [frameSize]; 
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
	}
	
	public void execute (int tagNumber) {
		buildSlots(tagNumber);
		
		for (int x : slots) {
			if (x==0)
				emptySlots++;
			else if (x == 1)
				successfullSlots++;
			else
				collisionSlots++;
		}
	}
	
	public void buildSlots (int tagNumber) {
		for (int i = 0; i < tagNumber; i++) {
			int slotToTransmit = new Random().nextInt(frameSize);
			slots[slotToTransmit]++;
		}
	}
}
