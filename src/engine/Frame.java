package engine;

import java.util.*;

public class Frame {
	double frameSize;
	int [] slots;
	double successfullSlots;
	double collisionSlots;
	double emptySlots;
	double competingTags;	//estimative
	
	
	
	public Frame(double frameSize, double competingTags) {
		this.frameSize = frameSize;
		this.slots = new int [(int)Math.ceil(frameSize)]; 
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
	}
	
	void execute (double tagsNum) {
		buildSlots(tagsNum);
		
		for (int x : slots) {
			if (x==0)
				emptySlots++;
			else if (x == 1)
				successfullSlots++;
			else
				collisionSlots++;
		}
	}
	
	void buildSlots (double tagsNum) {
		for (int i = 0; i < tagsNum; i++) {
			int slotToTransmit = new Random().nextInt((int)Math.ceil(frameSize));
			slots[slotToTransmit]++;
		}
	}
}
