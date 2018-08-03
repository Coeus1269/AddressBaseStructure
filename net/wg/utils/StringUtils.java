package net.wg.utils;

import java.io.UnsupportedEncodingException ;
import java.net.URLEncoder ;
// import java.util.regex.Matcher ;
// import java.util.regex.Pattern ;

public class StringUtils
{
	private StringUtils()
		{
		}
	
	public static String safeSet( String src )
	   { // if scr = null or empty returns null else returns src trimmed	
		if ( "null".equals( src ))
			return null;
		
   		src = src.trim();
	   	
	   	if ("".equals( src )) 
	   		return null;
	   	
	   	return src;
	   }
	
	public static String safeNull( String src )
		{ // if scr = null or empty returns empty string else returns src trimmed
			src = safeSet( src );
			return ( src == null ? "" : src );
		}
	
	public static boolean isEmpty( String src )
		{ // if scr = empty string or null returns true
			return safeSet( src ) == null;
		}

	public static boolean isEmptyString(String value_str)
		{ // if value_str = empty string or null returns true
			return ( value_str == null || value_str.trim().equals( "" ) );
			
		}

	public static String leftPad( String src, int length, String pad )
		{ // left pads src with length number of pad characters
			if (( src = safeSet( src )) != null )
			{
				while ( src.length() < length )
					src = pad + src;
			}
			
			return src;
		}
	
	public static String rightPad( String src, int length, String pad )
		{ // right pads src with length number of pad characters
			if (( src = safeSet( src )) != null )
			{		
				while ( src.length() < length )
					src = src + pad;
			}
			
			return src;
		}
	
	public boolean startsWith( String StringToCheck, String StartsWithString )
		{
			return StringToCheck == null ? false : StringToCheck.startsWith( StartsWithString );
		}

	public static boolean StringNotEmptyAndNotNull(String Value_str)
	   {
	   	return (Value_str != null)
	   		&& (!"".equals(Value_str));
	   }

	
	public static String toHTML( String content )
		{ // converts certain character to HTML safe Character entity
			if ( content == null )
				return "";
	
			StringBuffer sb = new StringBuffer( content.length() );
			
			int len = content.length();
			char c;
	
			for ( int i = 0; i < len; i++ )
			{
				c = content.charAt( i );

				// HTML Special Chars
				if ( c == '"' )
					sb.append( "&quot;" );
				
				else 
				if ( c == '&' )
					sb.append( "&amp;" );
				
				else 
				if ( c == '<' )
					sb.append( "&lt;" );
				
				else 
				if ( c == '>' )
					sb.append( "&gt;" );
				
				else 
				if ( c == '\n' )
				sb.append( "<br>" );
				
				else
				if ( c == '\r' )
					;	// do nothing
				
				else
				{
					int ci = 0xffff & c;
					
					if ( ci < 160 )
						// nothing special only 7 Bit
						sb.append( c );
					
					else
					{
						// Not 7 Bit use the unicode system
						sb.append( "&#" );
						sb.append( new Integer( ci ).toString() );
						sb.append( ';' );
					}
				}
			}
			
			return sb.toString();
		}
	
	public static String encodeURIComponent(String s) 
		{
		    String result;
	
		    try 
		    {
		        result = URLEncoder.encode(s, "UTF-8")
		                .replaceAll("\\+", "%20")
		                .replaceAll("\\%21", "!")
		                .replaceAll("\\%27", "'")
		                .replaceAll("\\%28", "(")
		                .replaceAll("\\%29", ")")
		                .replaceAll("\\%7E", "~")
		                .replaceAll( "\\%3A", ":" )
		                .replaceAll( "\\%2F", "/" );
		    } 

		    catch (UnsupportedEncodingException e) 
		    {
		        result = s;
		    }

		    return result;
		}
	
	public static void main( String...args )
		{
			System.out.println( encodeURIComponent( "http://someserver.org/lost+found/file with spaces and a ?" ));
			System.out.println(toHTML("\"Hello\" & GoodBye <> \n"));
		}
}


