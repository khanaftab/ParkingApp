package com.gojek.parking;

import java.io.IOException;

/**
 * 
 * @author Aftab 
 * The ParkingApp contains main method and decides weather to read from file or take input from User.  
 * 
 */

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
