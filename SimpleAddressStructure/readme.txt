	This version was built to be the simplest method for getting user input and storing address data.
	
	The concept here is that every combination of the City, State and ZipCode are in the CityStateZip Table. 
	  SQL structure and data are included in the Data folder of this project.

	The user interface should guide the user thru selecting the City State ZipCode first, before entering the street address info.

		
	Ideally prompt the user to enter or select the ZipCode code first 
	  then pull the CityStateZip records that match, 
	  allowing the user to select the CityStateZip record. Eliminating the need for the user to manually enter City or State.
	 
	 Obviously, another method would be to allow the user to select the state first, 
	   then select from cities in that state, 
	   then the ZipCode to get the full CityStateZip record
	   Again eliminating the need for the user to manually enter City, State or zip.

	 What to do when an address is not in the CityStateZip table?
	   Addresses are added constantly, especially in cities that are growing. Therefore, there needs for a process to 
	   		insert these new addresses, or make changes to the existing data when address info or structure changes.
	   		
	   One option is to have a way for a user to manually enter the data, maybe have a default record for pending edits as 
	     a place holder during a process to submit the address for approval with the system admin.
	   
	   Another is an update system - Enter the AddressUpdater Class - this is currently under construction, however the goal 
	     is to have a class that you would run once a week that will go to some URL and compare your DB to the current postal
	     address DB and make the necessary changes.