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
		
		double totalSlots, totalEmptySlots, totalCollisionSlots;
		totalSlots = totalEmptySlots = totalCollisionSlots = 0;
		Simulator currentSimulator;
		for (int i = 0; i < iterationsNumber; i++) {
			currentSimulator = new Simulator (algorithmName, initialTagsNumber, incrementTagRate, maxTagsNumber,
					iterationsNumber, initialFrameSize);
			System.out.println(currentSimulator.algorithmName);
			currentSimulator.execute();
			simulators.add(currentSimulator);
			
		}
		
		for (Simulator x : simulators) {
			totalSlots += x.totalSlots;
			totalCollisionSlots += x.collisionSlots;
			totalEmptySlots += x.emptySlots;
		}
		
		totalSlots = Math.ceil(totalSlots/simulators.size());
		totalCollisionSlots = Math.ceil(totalCollisionSlots/simulators.size());
		totalEmptySlots = Math.ceil(totalEmptySlots/simulators.size());
		
		System.out.println("total slots " + totalSlots + "\ncollision slots avg " + totalCollisionSlots + 
		"\nempty slots avg " + totalEmptySlots);
		
		double endTime = System.currentTimeMillis();
		
		double totalTime = (endTime - initTime);
		
		System.out.println("\nexecution time " + totalTime);
		
		
		
		

	}

}
