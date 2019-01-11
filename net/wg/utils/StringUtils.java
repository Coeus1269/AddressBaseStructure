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
	
	public static void main( String...args )
	{
		System.out.println( "encodeURIComponent: " +encodeURIComponent( "http://someserver.org/lost+found/file with spaces and a ?" ));
		System.out.println("to HTML: " + toHTML("\"Hello\" & GoodBye <> \n"));
		System.out.println(toTitleCase("tEsTing TiTle cASE"));
		System.out.println("Left Pad X: " + leftPad(" Kisses ", 3, "X", false));
		System.out.println("Right Pad O: " + rightPad(" Hugs ", 3, "O", false));
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
	
	public static boolean isEmptyString(String value_str)
		{ // if value_str = empty string or null returns true
			return ( value_str == null || value_str.trim().equals( "" ) );
			
		}

	public static String leftPad( String src_str, int length_int, String pad_str, boolean doTrim_b)
		{ // left pads src_str to (length_int x pad_str) + src_str characters
		// doTrim_b =  trim src_str or not
		
		if ( src_str != null)
			{ if (doTrim_b) // trims src_str
					{ src_str = src_str.trim();	}
				
					// while ( src_str.length() < length_int )
					for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
						src_str = pad_str + src_str;
			}
			return src_str;
		}
	
	public static String rightPad( String src_str, int length_int, String pad_str, boolean doTrim_b )
		{ // right pads src_str to  src_str + (length_int x pad_str) characters
		// doTrim_b =  trim src_str or not
		
		if ( src_str != null)
			{ if (doTrim_b) // trims src_str
				{ src_str = src_str.trim(); }
			
				for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
					src_str = src_str + pad_str;
			}
			return src_str;
		}
	
	public boolean startsWith( String StringToCheck, String StartsWithString )
		{ return StringToCheck == null ? false : StringToCheck.startsWith( StartsWithString );
		}

	public static boolean StringNotEmptyAndNotNull(String Value_str)
	   { return (Value_str != null)
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
				{  c = content.charAt( i );
	
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
					
//					else
//					if ( c == '\r' )
//						;	// do nothing
					
					else
						{ int ci = 0xffff & c;
						
						if ( ci < 160 )
							sb.append( c );
						
						else
							{ // Not 7 Bit use the unicode system
							sb.append( "&#" );
							sb.append( new Integer( ci ).toString() );
							sb.append( ';' );
							}
						}
				}
			
			return sb.toString();
		}
	
	public static String encodeURIComponent(String s) 
		{ String result;
	
		    try 
		    	{ result = URLEncoder.encode(s, "UTF-8")
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
		    	{ result = s;  }

		    return result;
		}
	

	public static String toTitleCase(String s) 
		{   // this function - credit to scottb on https://stackoverflow.com/questions/1086123/string-conversion-to-title-case
			// will not work with specialized rules, eg. surnames such as McNamara or MacDonald.
			// TODO: issue with street address parts like nw, se etc. 
			
		    final String ACTIONABLE_DELIMITERS = " -/"; // these cause the character following
		                                                 // to be capitalized
	
		    StringBuilder sb = new StringBuilder();
		    boolean capNext = true;
	
		    for (char c : s.toCharArray()) 
		    	{ c = (capNext)
		                ? Character.toUpperCase(c)
		                : Character.toLowerCase(c);
		        sb.append(c);
		        capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
		    	}
	
		    return sb.toString();
		}
	
	/* -------------------------------- Getters & Setters  -------------------------------- */



	/* ------------------------------ End Getters & Setters  ------------------------------ */
}


