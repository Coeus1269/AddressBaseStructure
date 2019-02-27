package FullRelationalAddressStructure;

import net.wg.utils.FileUtils;
// import net.wg.utils.StringUtils;
//import java.util.ArrayList;
//import java.util.List;

public class US_State 
{
	private String StateID;
	private int stateIndex = 0;	// the index is the reference to the state name and abbreviation, not storing these strings.
	private String StatesDataFile = "Data/US_States.txt";
	private static String[][] AmericanStates = null; // format = Abbreviation, State name
	// the StatesDataFile file has to keep the same order as the AmericanStates variable
	// the first element is empty string so if no match is made empty string can be displayed
	
	// optional
	private String stateMotto;		// State Motto String
	private String stateNickname;
	private String stateCapitol;
	private String stateSong;		
	private String stateSongURl;	
	private String stateBirdName;
	private String stateBirdURL;
	private String stateFlagURL;

	// TODO state spelling errors check	
	// TODO state data file DB
	// TODO ability to find state based on zip code
	// TODO compare state text with misspelled list
	
	public static void main( String...args )
		{
		TestData();
		}
	
	public US_State()
		{
		if(AmericanStates == null || AmericanStates.length < 1)
			AmericanStates = FileUtils.Load2xStringArrayFromFile(StatesDataFile);
		}
	
	public US_State(String StateString)
		{
		if(AmericanStates == null || AmericanStates.length < 1)
			AmericanStates = FileUtils.Load2xStringArrayFromFile(StatesDataFile);
		
		if(StateString != null && StateString.trim().length() > 0)
			stateIndex = getAmericanStatesIndex(StateString);	
		}
	
		
	public boolean isStateEmpty()
		{		
			//return StringUtils.isEmptyString( stateName );
			if (stateIndex > 0)
				return false;
			else
				return true;
		}

	public String toString()
		{
			return getStateAbbreviation();
		}
	
	private static int getAmericanStatesIndex(String StateString)
		{
		// find the index for the state, the index
		StateString = StateString.trim();
		if(StateString.length() == 2) // if only 2 char then this is probably the abbreviation
			return getAmericanStateAbbrevIndex(StateString);
		else
			return getAmericanStateNameIndex(StateString);

		}
	
	private static int getAmericanStateNameIndex(String StateName)
		{
			for (int Index_int=0; Index_int < AmericanStates.length;  Index_int++)
		        {
					if(	StateName.equalsIgnoreCase(AmericanStates[Index_int][1]))
							{
							return Index_int;
							}
		        }
			return 0;
		}
	
	private static int getAmericanStateAbbrevIndex(String StateAbbrev)
	{
		for (int Index_int=0; Index_int < AmericanStates.length;  Index_int++)
	        {
				if(	StateAbbrev.equalsIgnoreCase(AmericanStates[Index_int][0]))
						{
						return Index_int;
						}
	        }
		return 0;
	}
	
	public static void TestData()
		{
		
		US_State State = new US_State();
		
		State.setStateIndex(3);
		System.out.println(State.getStateAbbreviation() + ", " + State.getStateName());
		
		State = new US_State("Oklahoma");
		System.out.println(State.getStateAbbreviation() + ", " + State.getStateName());
		
		State = new US_State("TN");
		System.out.println(State.getStateAbbreviation() + ", " + State.getStateName());
		
		State.setStateIndex(0); // confirm that the first element is empty string
		System.out.println(State.getStateAbbreviation() + ", " + State.getStateName());
		
		// list the states and abbreviations		
//		System.out.println("\nAll states and abbreviations");
//		for (int Index_int=0; Index_int < AmericanStates.length;  Index_int++)
//	        {
//			State.setStateIndex(Index_int);
//			System.out.println(State.getStateName() + ", " + State.getStateAbbreviation());
//	        }
			
		}
	
	/* ------------------------------ Getters & Setters  ------------------------------ */

	public String getStateID() 
		{
			return StateID;
		}

	public void setStateID(String stateID) 
		{
			StateID = stateID;
		}

	public int getStateIndex() 
		{
			return stateIndex;
		}

	public void setStateIndex(int stateIndex) 
		{
			this.stateIndex = stateIndex;
		}

	public String getStateName() 
		{
			return AmericanStates[stateIndex][1];
		}
	
	public void setStateName(String StateName) 
		{
			//this.stateName = stateName;
			stateIndex = getAmericanStateNameIndex(StateName);
		}
	
	public String getStateAbbreviation() 
		{
		return AmericanStates[stateIndex][0];
			//return AmericanStates[stateIndex];
		}
	
	public void setStateAbbreviation(String StateAbbreviation) 
		{
			//this.stateAbbreviation = stateAbbreviation;
			stateIndex = getAmericanStatesIndex(StateAbbreviation);
		}
	
	public String getStateMotto() 
		{
			return stateMotto;
		}
	
	public void setStateMotto(String stateMotto) 
		{
			this.stateMotto = stateMotto;
		}
	
	public String getStateSong() 
		{
			return stateSong;
		}
	
	public void setStateSong(String stateSong) 
		{
			this.stateSong = stateSong;
		}
	
	public String getStateFlagURL() 
		{
			return stateFlagURL;
		}
	
	public void setStateFlagURL(String stateFlagURL) 
		{
			this.stateFlagURL = stateFlagURL;
		}

	public String getStatesDataFile() {
		return StatesDataFile;
	}

	public void setStatesDataFile(String statesDataFile) {
		StatesDataFile = statesDataFile;
	}

	public String getStateNickname() {
		return stateNickname;
	}

	public void setStateNickname(String stateNickname) {
		this.stateNickname = stateNickname;
	}

	public String getStateCapitol() {
		return stateCapitol;
	}

	public void setStateCapitol(String stateCapitol) {
		this.stateCapitol = stateCapitol;
	}

	public String getStateSongURl() {
		return stateSongURl;
	}

	public void setStateSongURl(String stateSongURl) {
		this.stateSongURl = stateSongURl;
	}

	public String getStateBirdName() {
		return stateBirdName;
	}

	public void setStateBirdName(String stateBirdName) {
		this.stateBirdName = stateBirdName;
	}

	public String getStateBirdURL() {
		return stateBirdURL;
	}

	public void setStateBirdURL(String stateBirdURL) {
		this.stateBirdURL = stateBirdURL;
	}
	
	/* ------------------------------ End Getters & Setters  ------------------------------ */

	
}
