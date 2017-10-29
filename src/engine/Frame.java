package engine;

import java.util.ArrayList;

public class Frame {
	int frameSize;
	int [] slots;
	// ArrayList<Tag> identifiedTags;
	int successfullSlots;
	int collisionSlots;
	int emptySlots;
	int competingTags;	//estimative
	
	
	
	public Frame(int frameSize) {
		// super();
		this.frameSize = frameSize;
		this.slots = new int [frameSize];
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
	}
	
	void execute (int remainsTags, Tag tag) {
		buildSlots(remainsTags, tag);
		
		for (int x : slots) {
			if (x==0)
				emptySlots++;
			else if (x == 1)
				successfullSlots++;
			else
				collisionSlots++;
		}
		
		// competingTags = successfullSlots + 2 * collisionSlots;
	}
	
	void buildSlots (int remainTags, Tag tag) {
		slots = new int [frameSize];
		for (int i = 0; i < remainTags; i++) {
			int slotToTransmit = tag.transmitToSlot(frameSize);
			slots[slotToTransmit]++;
		}
	}
}
