package com.gojek.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 *The ParkingSlot Class keeps track of available parking slots.
 *The implementation contains PriorityQueue to assign the nearest available slots.        
 * Also having slotNo Vs Registration number map in order to fulfill search.
 * 
 */

public class ParkingSlot {
	private PriorityQueue<Integer> availableSlots = new PriorityQueue<Integer>();
	private Map<Integer, String> slotRegDetails = new HashMap<Integer, String>();
	public ParkingSlot(Integer n)
	{
		for ( Integer i = 1; i  <=n; i++ )
		{  
			this.availableSlots.add (i) ; 
		}
		System.out.println("Created a parking lot with "+ n +" slots");
	}
	public Integer getFreeParkingSlot(String regNo)
	{
		/*TODO handle null pointer exception*/
		if(this.availableSlots.peek() != null)
		{
			System.out.println("Allocated slot number: "+this.availableSlots.peek());
			this.slotRegDetails.put(this.availableSlots.peek(), regNo);
			return this.availableSlots.poll();
		}
		System.out.println("Sorry, parking lot is full");
		return 0;
	}
	public void addFreeParkingSlot(Integer slotNo)
	{
		this.availableSlots.add(slotNo);
		this.slotRegDetails.remove(slotNo);
		System.out.println("Slot number "+ slotNo +" is free");
	}
	public String getRegNumberForSlot(Integer slotNo)
	{
		return this.slotRegDetails.get(slotNo);
	}
	public Map<Integer, String> getSlotVsRegNoMap()
	{
		return this.slotRegDetails;
	}
}
