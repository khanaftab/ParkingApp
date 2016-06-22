package com.gojek.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingSlot {
	private PriorityQueue<Integer> avalableSlots = new PriorityQueue<Integer>();
	private Map<Integer, String> slotRegDetails = new HashMap<Integer, String>();
	public ParkingSlot(Integer n)
	{
		for ( Integer i = 1; i  <=n; i++ )
		{  
			this.avalableSlots.add (i) ; 
		}
		System.out.println("Created a parking lot with "+ n +" slots");
	}
	public Integer getFreeParkingSlot(String regNo)
	{
		/*TODO handle null pointer exception*/
		if(this.avalableSlots.peek() != null)
		{
			System.out.println("Allocated slot number: "+this.avalableSlots.peek());
			this.slotRegDetails.put(this.avalableSlots.peek(), regNo);
			return this.avalableSlots.poll();
		}
		System.out.println("Sorry, parking lot is full");
		return 0;
	}
	public void addFreeParkingSlot(Integer slotNo)
	{
		this.avalableSlots.add(slotNo);
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
