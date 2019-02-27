package FullRelationalAddressStructure;

import StringUtils.StringUtils;

public class US_Address 
{
	private int addressID; 				// primary key
	private String addressLine1 = "";	// Why addressLine1 & addressLine2
	private String addressLine2 = "";	// ‘Address1’ & ‘Address2’ labels could be misinterpreted as fields for entering two separate addresses.

	private US_City city;				// City class contains both state and zip code

	// private String countyID;
	
	// TODO need process to handle data entry of every element in the stack, then provide feedback to the user for spelling corrections and errors.
	
	// check TODO's for implementation editing needs
	
	// TODO method to get a most likely address Line 1 when no match
	
	//Optional
	private String notes; // for directions or thing like the house in the back etc.

	public static void main( String...args )
		{
		TestData();
		}
	
	public US_Address()
		{
		city = new US_City();
		}
	
	public US_Address(String AddressLine1, String AddressLine2, String CityString, String StateString, String ZipCodeString)
		{
		if (isAddressLine1Valid(AddressLine1))
			setAddressLine1(AddressLine1);
		
		if (isAddressLine2Valid(AddressLine2))
			setAddressLine2(AddressLine2);
		
		city = new US_City(CityString, StateString, ZipCodeString);
		}
	
	public US_Address(String AddressLine1, String CityString, String StateString, String ZipCodeString)
		{
		if (isAddressLine1Valid(AddressLine1))
			setAddressLine1(AddressLine1);
		
		city = new US_City(CityString, StateString, ZipCodeString);
		}
	
    public boolean isAddressValid()
	    {
	    	// all the following fields must be present to be valid at a minimum
	
	    	if ( StringUtils.isEmptyString( addressLine1 ) )
		   		return false;
	
			if(!city.isCityValid())
					return false;
	
			if(!city.getState().isStateEmpty())
				return false;
	
			if (!city.getZipCode().isZip5Valid())
				return false;
			
	    	return true;
	    }
    
	public static boolean isAddressLine1Valid(String AddressLine1)
		{
			AddressLine1 = AddressLine1.trim();
			if(StringUtils.isEmptyString(AddressLine1))
				return false;
			
			return AddressLine1.matches("(?ix)^\\d+(?:\\s+\\d*[A-Z\\.-]+|\\s+\\d*)+$");
		}
	
	public boolean isAddressLine2Valid(String AddressLine2)
		{
			if(StringUtils.isEmptyString(AddressLine2))
				return false;
			
			return true; // addressLine2.matches("(?ix)^\\d+(?:\\s+\\d*[A-Z\\.-]+|\\s+\\d*)+$");
		}
	
	@Override
	public String toString()
		{
		return getAddressLine1() + " " + city.toString();
		}
	
	public static void TestData()
		{
			US_Address Addy = new US_Address("1234 NW This Way", "OkLaHoma City", "ok", "73112-5120");
			
			System.out.println(Addy.toString());
			
			Addy = new US_Address("1234 NW that Way", "OkLaHoma City", "oklahoma", "73112");
			
			System.out.println(Addy.toString());
						
		}
    
/* ------------------------------ Getters & Setters  ------------------------------ */

	public long getAddressID() 
	    {
			return this.addressID;
		}
    
	public void setAddressID(int addressID) 
		{
		this.addressID = addressID;
		}

	public String getAddressLine1() 
		{
			return addressLine1;
		}

	public void setAddressLine1(String addressLine1) 
		{
			this.addressLine1 = addressLine1;
		}

	public String getAddressLine2() 
		{
			return addressLine2;
		}

	public void setAddressLine2(String addressLine2) 
		{
			this.addressLine2 = addressLine2;
		}

	public US_City getCity() 
		{
			return city;
		}

	public void setCity(US_City city) 
		{
			this.city = city;
		}

	public String getNotes() 
		{
			return notes;
		}

	public void setNotes(String notes) 
		{
			this.notes = notes;
		}

	/* ------------------------------ End Getters & Setters  ------------------------------ */

}
