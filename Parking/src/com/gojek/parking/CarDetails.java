package com.gojek.parking;

/**
 * Class CarDetails contains  information about car's in parking slots.    
 */

  public class CarDetails {
	private String colour;
	private String vehicleRegNo;
	private Integer slotNo;
	
	public CarDetails(String carDetail, Integer slotNo)
	{
		this.vehicleRegNo = carDetail.split(" ")[1];
		this.colour = carDetail.split(" ")[2];
		this.slotNo = slotNo;
	}
	
	public void setVehicleRegNo(String vehicleRegNo)
	{
		this.vehicleRegNo=vehicleRegNo;
	}
	public void setColour(String colour)
	{
		this.colour=colour;
	}
	private void setSlotNo(Integer slotNo)
	{
		this.slotNo = slotNo;
	}
	public String getVehicleRegNo()
	{
		return this.vehicleRegNo;
	}
	public String getColour()
	{
		return this.colour;
	}
	public Integer getSlotNo()
	{
		return this.slotNo;
	}
}
