package SimpleAddressStructure;

public class Address 
{
	private String Address1_str = "";
	private String Address2_str = "";
	private int CityStateZip_ID;
	private int Contact_ID;				// contact person for this ID, not used if using the linker tables
	
	public static void main(String[] args) 
		{
		}

	/* -------------------------------- Getters & Setters  -------------------------------- */

	public String getAddress1_str() 
		{ return Address1_str;	}

	public void setAddress1_str(String address1_str) 
		{ Address1_str = address1_str;	}

	public String getAddress2_str() 
		{ return Address2_str;	}

	public void setAddress2_str(String address2_str) 
		{ Address2_str = address2_str;	}

	public int getCityStateZip_ID() 
		{ return CityStateZip_ID;	}

	public int getContact_ID() 
		{ return Contact_ID; }

	/* ------------------------------ End Getters & Setters  ------------------------------ */
}
