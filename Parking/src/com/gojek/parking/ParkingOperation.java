package com.gojek.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * The ParkingOperation class is the heart of parking Application. Take the Command and perform operation.
 * Search Using Car Colour.
 * Search Using vehicle registration Number.
 * Search Using parking slot.      
 * 
 */
public class ParkingOperation {
	private Map<String, CarDetails> carRegDetails = new HashMap<String, CarDetails>();
	private ParkingSlot parkingSlot = null;
	public void parkingActions(String operation)
	{
		String operationKey = operation.split(" ")[0];
		if(operationKey.equals("create_parking_lot"))
		{
			this.parkingSlot = new ParkingSlot(Integer.parseInt(operation.split(" ")[1]));
		}
		if(operationKey.equals("park"))
		{
			Integer slotNo = this.parkingSlot.getFreeParkingSlot(operation.split(" ")[1]);
			if(slotNo != 0)
			{
				CarDetails carDetails = new CarDetails(operation, slotNo);
				this.carRegDetails.put(carDetails.getVehicleRegNo(), carDetails);
			}
		}
		if(operationKey.equals("leave"))
		{
			this.carRegDetails.remove(this.parkingSlot.getRegNumberForSlot(Integer.parseInt(operation.split(" ")[1])));
			this.parkingSlot.addFreeParkingSlot(Integer.parseInt(operation.split(" ")[1]));
		}
		if(operationKey.equals("status"))
		{
			printStatus();
		}
		if(operationKey.equals("registration_numbers_for_cars_with_colour"))
		{
			List<CarDetails> carDetailList =  getCarDetailsForColour(operation.split(" ")[1]);
			Boolean printComma = Boolean.FALSE;
			for(CarDetails carDel : carDetailList)
			{
				if(printComma)
				{
					System.out.print(", ");
				}
				System.out.print(carDel.getVehicleRegNo());
				printComma = Boolean.TRUE;
			}
			System.out.println();
		}
		if(operationKey.equals("slot_numbers_for_cars_with_colour"))
		{
			List<CarDetails> carDetailList =  getCarDetailsForColour(operation.split(" ")[1]);
			Boolean printComma = Boolean.FALSE;
			for(CarDetails carDel : carDetailList)
			{
				if(printComma)
				{
					System.out.print(", ");
				}
				System.out.print(carDel.getSlotNo());
				printComma = Boolean.TRUE;
			}
			System.out.println();
		}
		if(operationKey.equals("slot_number_for_registration_number"))
		{
			if(this.carRegDetails.get(operation.split(" ")[1]) != null)
			{
				System.out.println(this.carRegDetails.get(operation.split(" ")[1]).getSlotNo());
			}
			else
			{
				System.out.println("Not found");
			}
		}
	}
	private void printStatus()
	{
		Map<Integer, String> slotVsRegNo = this.parkingSlot.getSlotVsRegNoMap();
		System.out.println("Slot No. \t\t\t Registration No \t\t\t Colour");
		for(Map.Entry<Integer, String> slotVsRegNoEntry : slotVsRegNo.entrySet()){
            System.out.println(slotVsRegNoEntry.getKey() +" \t\t\t "+ this.carRegDetails.get(slotVsRegNoEntry.getValue()).getVehicleRegNo()+ "  \t\t\t "+ this.carRegDetails.get(slotVsRegNoEntry.getValue()).getColour());
        }
	}
	private List<CarDetails> getCarDetailsForColour(String colour)
	{
		List<CarDetails> carList = new ArrayList<CarDetails>();
		for(Map.Entry<String, CarDetails> carRegDetailEntry : this.carRegDetails.entrySet())
		{
			if(carRegDetailEntry.getValue().getColour().equals(colour))
			{
				carList.add(carRegDetailEntry.getValue());
			}
		}
		return carList;
	}
}
