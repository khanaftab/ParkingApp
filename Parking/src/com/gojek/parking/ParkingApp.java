package com.gojek.parking;

import java.io.IOException;

public class ParkingApp {
	public static void main(String []args) throws IOException
	{
		if(args.length>0)
		{
			new FileInput(args[0]);
		}
		else
		{
			new Interactive();
		}
	}
}
