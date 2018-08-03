package net.wg.address;

import net.wg.utils.StringUtils;

public class US_City 
{
	private int CityID;
	private String cityName;

	private US_State state;

	private US_ZipCode zipCode;
	
	private String county;			// TODO need county class?
	
	// TODO: Ideally, on city validate this class will pull from a local file or DB for validation of 
	//  name, spelling, State, zipcode and county
	// TODO: Method for name misspelling correction based on local file or DB
	// TODO ability to find city based on zip code
	// TODO compare city text with misspelled list

	public static void main( String...args )
		{
		TestData();
		}
	
	public US_City()
		{
		state = new US_State();
		zipCode = new US_ZipCode();
		}
	
	public US_City(String CityName, String StateName, String ZipCode)
		{
			if(CityName != null && CityName.trim().length() > 0)
				cityName = StringUtils.toTitleCase(CityName.trim());
		
			if(StateName != null && StateName.trim().length() > 0)
				state = new US_State(StateName.trim());
			
			if(ZipCode != null && ZipCode.trim().length() > 0)
				zipCode = new US_ZipCode(ZipCode.trim());
		}
	
	public boolean isCityValid()
		{
			if(!isCityNameValid(cityName))
					return false;
			
			if (!zipCode.isZip5Valid())
				return false;
			
			if(!state.isStateEmpty())
				return false;
			
			return true;
		}
	
	public boolean isCityNameValid(String CityName)
		{
		CityName = CityName.trim();
			return CityName.matches("(?ix)^[A-Z\\.-]+(?:\\s+[A-Z\\.-]+)*$");
		}

	
	public String toString()
		{
			return getCityName() + ", " + state.toString() + " " + zipCode.toString();
		}
	
	public static void TestData()
		{
			US_City City = new US_City("Oklahoma City", "Oklahoma", "73112");
			System.out.println(City.toString());
			
			City = new US_City("Oklahoma City", "Oklahoma", "73112-5103");
			System.out.println(City.toString());
			
			City = new US_City("Oklahoma City", "OK", "73112-5103");
			System.out.println(City.toString());
		}
	
	/* ------------------------------ Getters & Setters  ------------------------------ */

	public String getCityName() 
		{
			return cityName;
		}

	public void setCityName(String cityName) 
		{
			this.cityName = cityName;
		}

	public US_State getState() 
		{
			return state;
		}
	
	public String getStateName() 
		{
			return state.getStateName();
		}
	
	public String  getStateAbbrev() 
		{
			return state.getStateAbbreviation();
		}

	public void setState(US_State state) 
		{
			this.state = state;
		}

	public US_ZipCode getZipCode() 
		{
			return zipCode;
		}
	
	public String getZip5() 
		{
			return zipCode.getZip5();
		}
	
	public String getZipPlus4() 
		{
			return zipCode.getZipPlus4();
		}

	public void setZipCode(US_ZipCode zipCode) 
		{
			this.zipCode = zipCode;
		}

	public String getCounty() 
		{
			return county;
		}

	public void setCounty(String county) 
		{
			this.county = county;
		}

	public int getCityID() 
		{
			return CityID;
		}

	public void setCityID(int cityID) 
		{
			CityID = cityID;
		}
	
	/* ------------------------------ End Getters & Setters  ------------------------------ */

	
}
