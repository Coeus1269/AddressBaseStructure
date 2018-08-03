package net.wg.address;

import net.wg.utils.StringUtils;

public class AddressTester 
{
	public static void main( String...args )
	{
	TestData();
	}
	
	public static void TestData()
	{
		US_Address.TestData();
		
		System.out.println(StringUtils.toTitleCase("hey there ya'll"));
		System.out.println(StringUtils.toTitleCase("hello"));
		System.out.println(StringUtils.toTitleCase("tEsTing TiTle cASE"));
	}

}
