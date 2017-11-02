package program;

import engine.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double initTime = System.currentTimeMillis();
		String algorithmName = args[0];
		int initialTagsNumber = Integer.parseInt(args[1]);
		int incrementTagRate = Integer.parseInt(args[2]);
		int maxTagsNumber = Integer.parseInt(args[3]); 
		int iterationsNumber = Integer.parseInt(args[4]);
		int initialFrameSize = Integer.parseInt(args[5]);
		LinkedList<Simulator> simulators = new LinkedList();
		
		int totalSlots, totalEmptySlots, totalCollisionSlots;
		totalSlots = totalEmptySlots = totalCollisionSlots = 0;
		Simulator currentSimulator;
		for (int i = 0; i < iterationsNumber; i++) {
			currentSimulator = new Simulator (algorithmName, initialTagsNumber, incrementTagRate, maxTagsNumber,
					iterationsNumber, initialFrameSize);
			currentSimulator.execute();
			simulators.add(currentSimulator);
			
		}
		
		for (Simulator x : simulators) {
			totalSlots += x.totalSlots;
			totalCollisionSlots += x.collisionSlots;
			totalEmptySlots += x.emptySlots;
		}
		
		totalSlots = totalSlots/simulators.size();
		totalCollisionSlots = totalCollisionSlots/simulators.size();
		totalEmptySlots = totalEmptySlots/simulators.size();
		
		System.out.println("identified tags " + initialTagsNumber + "\ntotal slots " + totalSlots + "\ncollision slots " + totalCollisionSlots + 
		"\nempty slots " + totalEmptySlots);
		
		double endTime = System.currentTimeMillis();
		
		double totalTime = (endTime - initTime);
		
		System.out.println("\nexecution time " + totalTime);
		
		
		
		

	}

}
