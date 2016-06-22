package com.gojek.parking;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * The FileInput constructor takes file path as an argument and read the commands to performance parking operation.    
 * 
 */

public class FileInput {
	private ParkingOperation operations = new ParkingOperation();
	public FileInput(String filePath)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
		    for(String line; (line = br.readLine()) != null; ) 
		    {
		    	operations.parkingActions(line);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
