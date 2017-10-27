package engine;

import java.util.ArrayList;

public class Frame {
	int initialFrameSize;
	int [] slots;
	// ArrayList<Tag> identifiedTags;
	int successfullSlots;
	int collisionSlots;
	int emptySlots;
	int competingTags;	//estimative
	int backlog;
	
	
	
	public Frame(int initialFrameSize) {
		super();
		this.initialFrameSize = initialFrameSize;
		this.slots = new int [initialFrameSize];
		this.successfullSlots = 0;
		this.collisionSlots = 0;
		this.emptySlots = 0;
		this.competingTags = 0;
		this.backlog = 0;
	}
}
