package engine;

import java.util.*;

public class Frame {
	int frameSize;
	int [] slots;
	int successfullSlots;
	int collisionSlots;
	int emptySlots;
	int competingTags;	//estimative
	
	
	
	public Frame(int frameSize) {
		this.frameSize = frameSize;
		this.slots = new int [frameSize]; 
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
	}
	
	void execute (int tagNumber) {
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
	
	void buildSlots (int tagNumber) {
		for (int i = 0; i < tagNumber; i++) {
			int slotToTransmit = new Random().nextInt(frameSize);
			slots[slotToTransmit]++;
		}
	}
}
