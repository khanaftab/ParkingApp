package com.gojek.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * The Interactive class constructor having an infinite loop to interact with User and read the commands.    
 * 
 */

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
