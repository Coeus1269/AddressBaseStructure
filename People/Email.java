package People;

import net.wg.utils.StringUtils;

public class Email
{
	private String email;

	// TODO email validation

	public static void main(String[] args)
		{
		TestData( );
		}

	public Email()
		{
		}

	public Email(String Email)
		{
		// TODO need validation?
		if(!StringUtils.isEmptyString(Email))
			email = Email;
		}

	@Override
	public String toString()
		{
			return getEmail();
		}

	public static void TestData( )
		{
		Email email = new Email("wg@domain.com");
		System.out.println(email.toString() + " " + email.getEmailUsername() + " @ " + email.getEmailDomain());
		}

	/* -------------------------------- Getters & Setters  -------------------------------- */
	
public String getEmail( )
	{
		return email;
	}

public void setEmail(String email)
	{
		this.email = email;
	}

public String getEmailDomain( )
	{
		return  email.substring(email.indexOf("@") + 1);
	}

public String getEmailUsername( )
	{
		return  email.substring(0, email.indexOf("@") );
	}

	/* ------------------------------ End Getters & Setters  ------------------------------ */
	
}
