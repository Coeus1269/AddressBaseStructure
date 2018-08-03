package net.wg.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.io.File;

public class FileUtils 
{
	
	public static String[][] Load2xStringArrayFromFile(String FileName)
	{
		String[][] matrix = new String[55][2];
		
		// InputStream stream = ClassLoader.getSystemResourceAsStream(filename);  // bad file name throws error
        // BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));

        // If in the same directory - Just comment out the 2 lines above this 
        // and uncomment the line that follows.
		
		System.out.println("Loading file: " + FileName);
        BufferedReader buffer = null;
		try 
			{
				buffer = new BufferedReader(new FileReader(FileName));
			} 
		catch (FileNotFoundException e1) 
			{
				// TODO add debug/logger
				e1.printStackTrace();
			}
		
        String line;
        int row = 1;
        int size = 2;

        matrix[0][0] = "";	// default set the first element to empty string for null replacements
		matrix[0][1] = "";
		
        try {
        	
			while ((line = buffer.readLine()) != null) 
				{
			    String[] vals = line.trim().split(",\\s*");

			    // Lazy instantiation.
//			    if (matrix == null) 
//			    	{
//			        size = vals.length;
//			        matrix = new String[size +1][size +1];
//			    	}

			    for (int col = 0; col < size; col++) 
			    	{
			        matrix[row][col] = vals[col];
			    	}

			    row++;
				} // end while ((line = buffer.readLine()) != null) 
			
				
			} 
        catch (IOException e) 
        	{
			// TODO add debug/logger
			e.printStackTrace();
        	}

        return matrix;
	}

//private void LoadCommaSeperatedArrayFromFile(String FileName)
//{
//        String token1 = "";
//
//        // create Scanner inFile1
//        Scanner inFile1 = null;
//		try 
//			{
//				inFile1 = new Scanner(new File(FileName)).useDelimiter(",\\s*");
//				
//		        List<String> StatesArray = new ArrayList<String>();
//
//		        // while loop
//		        StatesArray.add("");
//		        while (inFile1.hasNext()) 
//			        {
//			          // find next line
//			          token1 = inFile1.next();
//			          StatesArray.add(token1);
//			        }
//		        inFile1.close();
//
//		        // AmericanStateNames = StatesArray.toArray(new String[0]);
//
////		        for (String s : AmericanStateNames) 
////		        	{
////		        	System.out.println(s);
////		        	}
//			} 
//		catch (FileNotFoundException e) 
//			{
//				// TODO add debug/logger
//				e.printStackTrace();
//			}
//}

}
