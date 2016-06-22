package com.gojek.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Interactive {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	ParkingOperation operation = new ParkingOperation();
	public Interactive() throws IOException
	{
		while(true)
		{
			String line = br.readLine();
			operation.parkingActions(line);
			continue;
		}
	}

}
