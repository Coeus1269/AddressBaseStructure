package SimpleAddressStructure;

import FullRelationalAddressStructure.US_State;
import FullRelationalAddressStructure.US_ZipCode;

import java.util.List;

public class CityStateZip 
{
	private int CityStateZip_ID;
	private String cityName_str;
	private US_State state_str;
	private US_State stateAbbr_str;		// State Abbreviation
	private US_ZipCode zipCode_str;	
	private String county_str;			// TODO need county class?
	
	public static void main(String[] args) 
		{
		}
	public List<String> PullUniqueZipCodesList()
	{
		// Return a Sting list of Unique Zipcodes for interface display and user selection
		
		/* SELECT [Zipcode_str]
			  FROM [CityStateZip]
			  where [Decommisioned] = 0
			  group by [Zipcode_str]
			  order by [Zipcode_str]
		 */
		
		return null;		
	}
	
	public List<String> PullUniqueStatesList()
	{
		// Return a Sting list of Unique States for interface display and user selection
		
		/* SELECT [State_str], [StateAbbr_str]
		  FROM [CityStateZip]
		  where [Decommisioned] = 0
		  group by [State_str], [StateAbbr_str]
		  order by [State_str], [StateAbbr_str]
	 */
		
		return null;		
	}
	
	public List<String> PullUniqueCitiesList()
	{
		// Return a Sting list of Unique Cities for interface display and user selection
		
		/* SELECT [City_str]
		  FROM [CityStateZip]
		  where [Decommisioned] = 0
		  group by [City_str]
		  order by [City_str]
	 */
		
		
		return null;		
	}

	/* -------------------------------- Getters & Setters  -------------------------------- */
	
	public String getCityName_str() 
		{ return cityName_str;	}

	public void setCityName_str(String cityName_str) 
		{ this.cityName_str = cityName_str;	}

	public US_State getState_str() 
		{ return state_str;	}

	public void setState_str(US_State state_str) 
		{ this.state_str = state_str; }

	public US_State getStateAbbr_str() 
		{ return stateAbbr_str; }

	public void setStateAbbr_str(US_State stateAbbr_str) 
		{ this.stateAbbr_str = stateAbbr_str; }

	public US_ZipCode getZipCode_str() 
		{ return zipCode_str; }

	public void setZipCode_str(US_ZipCode zipCode_str) 
		{ this.zipCode_str = zipCode_str; }

	public String getCounty_str() 
		{ return county_str; }

	public void setCounty_str(String county_str) 
		{ this.county_str = county_str;	}

	public int getCityStateZip_ID() 
		{ return CityStateZip_ID; }

	/* ------------------------------ End Getters & Setters  ------------------------------ */

}
