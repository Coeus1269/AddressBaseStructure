package People;

import net.wg.utils.PhoneUtils;
import net.wg.utils.StringUtils;

public class Phone
{
	private String phoneNumber = ""; // phone number stored unformatted
	
	public static void main(String[] args)
	{
		TestData( );
	}
	
	public Phone()
	{
	}
	
	public Phone(String PhoneNumber)
	{
		if(!StringUtils.isEmptyString(PhoneNumber))
			phoneNumber = PhoneUtils.unFormatPhoneNumber(PhoneNumber);
		
		stripLeadingZeros();
	}

	private String FormatPhoneNumber()
		{
		 	return PhoneUtils.FormatPhoneNumber(phoneNumber);
		}
	 
	 public static String FormatPhoneNumber( String PhoneNumber ) // extending PhoneUtils Functionality
		{
		 	return PhoneUtils.FormatPhoneNumber(PhoneNumber);
		}
	
	private  String UnformatPhoneNumber()
		{
			return PhoneUtils.unFormatPhoneNumber(phoneNumber);
		}
		
	public static String UnformatPhoneNumber(String PhoneNumber) // extending PhoneUtils Functionality
		{
			return PhoneUtils.unFormatPhoneNumber(PhoneNumber);
		}

	public void stripLeadingZeros()
		{
		phoneNumber = PhoneUtils.stripLeadingZeros(phoneNumber);
		}

	@Override
	public String toString()
		{
			return getPhoneNumber();
		}

	public static void TestData( )
		{
		Phone phone = new Phone("916-722-8982");
		System.out.println(phone.toString());
		
		System.out.println(phone.UnformatPhoneNumber());
		System.out.println(phone.FormatPhoneNumber());
		
		phone = new Phone("1-916-722-8982");
		System.out.println(phone.toString());
		
		System.out.println(phone.UnformatPhoneNumber());
		System.out.println(phone.FormatPhoneNumber());
		
		phone = new Phone("722-8982");
		System.out.println(phone.toString());
		
		System.out.println(phone.UnformatPhoneNumber());
		System.out.println(phone.getPhoneFormattedPhoneNumber());
		}
	
	/* -------------------------------- Getters & Setters  -------------------------------- */

	public String getNPA()
	   {
	       return PhoneUtils.getNPA( phoneNumber );
	   }

	public  String getNXX()
	   {
	       return PhoneUtils.getNXX(phoneNumber );
	   }
	
	public boolean isDirectoryAssist()
	   {
		   return PhoneUtils.isDirectoryAssist( phoneNumber );  // long distance DA
	    }

	public String getPhoneFormattedPhoneNumber( )
		{
			return FormatPhoneNumber();
		}
	
	public String getPhoneUnFormattedPhoneNumber( )
	{
		return UnformatPhoneNumber();
	}
	
	public String getPhoneNumber( )
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber)
	{
		phoneNumber = PhoneNumber;
	}

	/* ------------------------------ End Getters & Setters  ------------------------------ */
	
}
