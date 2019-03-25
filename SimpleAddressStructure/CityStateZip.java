package SimpleAddressStructure;

import FullRelationalAddressStructure.US_State;
import FullRelationalAddressStructure.US_ZipCode;

public class CityStateZip 
{
	private int CityStateZip_ID;
	private String cityName_str;
	private US_State state_str;
	private US_ZipCode zipCode_str;	
	private String county_str;			// TODO need county class?
	
	public static void main(String[] args) 
		{
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
