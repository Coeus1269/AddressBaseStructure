package net.wg.address;

import net.wg.utils.StringUtils;

public class US_ZipCode
{
	private int zipCodeID;		
	private String zip5 = ""; 	// using string to allow for leading zeros
	private String zip4 = ""; 
	
	// TODO Ideally when validating a zip5 have this class pull from a text file or database that has all the valid zip5 & zip4
	// TODO Pull actual address when provided +4
	// with DB look up implementation you can find city & state based on zip

	// INFO:
	// There are three main parts of the 5-digit ZIP Code  https://d79i1fxsrar4t.cloudfront.net/assets/img/docs/zip-code-digits.bd7aeb47.png
	// the national area, the region or city, and the delivery area.
	// The United States Postal Service (USPS) has segmented the country into 10 ZIP Code areas.
	// https://d79i1fxsrar4t.cloudfront.net/assets/img/docs/zip-code-zones.e903a0e3.png

	public static void main( String...args )
	{
		TestData();
	}
	
	public US_ZipCode()
		{
		}
	
	public US_ZipCode(String ZipCode)
		{
		setZipCode(ZipCode);
			
		}
	
	public US_ZipCode(String Zip5, String Zip4)
		{
			if(Zip5.length() == 5 && isZip5Valid(Zip5))
				zip5 = Zip5;
	
			if(Zip4.length() == 4 && isZip4Valid(Zip4))
				zip4 = Zip4;
		}
	
	public US_City FindCityFromZip(String ZipCode)
		{
			// DB look up for city from zip
		
			US_City City = new US_City();
			return City;
		}
	
	public US_State FindStateFromZip(String ZipCode)
	{
		// DB look up for state from zip
	
		US_State State = new US_State();
		return State;
	}
	
	public boolean isZip5Valid()
		{
			// valid zip is 5 digits only
			zip5 = zip5.trim();
			
			if(isZip5Empty())
				return false;
			
			return zip5.matches("^\\d{5}$");
		}
	
	public static boolean isZip5Valid(String Zip5)
	{
		// valid zip is 5 digits only
		Zip5 = Zip5.trim();
		
		if(StringUtils.isEmptyString(Zip5))
			return false;
		
		return Zip5.matches("^\\d{5}$");
	}
	
	public boolean isZip4Valid()
		{
			// valid +4 is 4 digits only
			zip4 = zip4.trim();
			
			if(isZip4Empty())
				return false;
				
			return zip4.matches("^\\d{4}$");
				
		}
	
	public static boolean isZip4Valid(String Zip4)
		{
			// valid +4 is 4 digits only
			Zip4 = Zip4.trim();
			
			if(StringUtils.isEmptyString(Zip4))
				return false;
			
			return Zip4.matches("^\\d{4}$");
		}
	
	public boolean isZip5Empty()
		{
			return StringUtils.isEmptyString( zip5 );
		}
	
	public boolean isZip4Empty()
		{
			return StringUtils.isEmptyString( zip4 );
		}
	
	@Override
	public String toString()
		{
			return getZipPlus4();
		}
	
	public static void TestData()
	{
		// Class testing
		US_ZipCode ZipCode = new US_ZipCode("01002", "5101");
				System.out.println(ZipCode.toString());
				ZipCode = null;
				
				// garbage test
				ZipCode = new US_ZipCode("01z02", "5101");
				System.out.println(ZipCode.toString() + " Garbage Zip");
				
				ZipCode = new US_ZipCode("01002", "51q1" );
				System.out.println(ZipCode.toString() + " Garbage +4");
				
				ZipCode = new US_ZipCode("01002-5102");
				System.out.println(ZipCode.toString());
				
				ZipCode = new US_ZipCode("01002");
				System.out.println(ZipCode.toString() + " Zip Only");
				
				ZipCode = new US_ZipCode("01002-");
				System.out.println(ZipCode.toString() + " 6 char zip 01002-");
				
				ZipCode = new US_ZipCode("01002 -");
				System.out.println(ZipCode.toString() + " 6 char zip 01002 -");
				
				ZipCode = new US_ZipCode("01002 - ");
				System.out.println(ZipCode.toString() + " 6 char zip 01002 - + end space");
				
				ZipCode = new US_ZipCode();
				ZipCode.setZip5("01002");
				ZipCode.setZip4("5103");
				System.out.println(ZipCode.toString());
	}
	
	/* ------------------------------ Getters & Setters  ------------------------------ */

	public void setZipCode(String ZipCode)
		{
		ZipCode = ZipCode.trim();
		
		// additional improvement parse out digits only for 6 char length in case we receive something like 55555- or 55555 -
		if(ZipCode.length() > 5  && ZipCode.length() < 8)
				ZipCode = ZipCode.replaceAll("\\D+","");
		
		if(ZipCode.length() == 5 && isZip5Valid(ZipCode))
			zip5 = ZipCode;
		
		if(ZipCode.length() == 10) // assuming format 55555*4444 where * = any char
			{
			if(isZip5Valid(ZipCode.substring(0, 5)))
				zip5 = ZipCode.substring(0, 5);
			
			if(isZip4Valid(ZipCode.substring(6, 10)))
				zip4 = ZipCode.substring(6, 10);
			}
		}
	public int getZipCodeID() 
		{
			return zipCodeID;
		}

	public void setZipCodeID(int zipCodeID) 
		{
			this.zipCodeID = zipCodeID;
		}

	public String getZipPlus4() 
		{	
			if(isZip5Empty())
				return "";
			
			if(isZip4Empty())
				return zip5;
		
			return zip5 + "-" + zip4;
		}
	
	public String getZip5() 
		{
			return zip5;
		}
	
	public void setZip5(String zip5) 
		{
			this.zip5 = zip5;
		}
	
	public String getZip4() 
		{
			return zip4;
		}
	
	public void setZip4(String zip4) 
		{
			this.zip4 = zip4;
		}
	
	/* ------------------------------ End Getters & Setters  ------------------------------ */
	
}
