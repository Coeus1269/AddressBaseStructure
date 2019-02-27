
Version one details; 

  This version allowed the user to manually enter address data for City State and ZipCode.
 This created a need to validate user input. This could be limited by providing a selection of 
 data that had been validate already, like ZipCodes.
  
  There are many address elements that can benefit from standardization, clean up or validation. 
Many of these areas will be addressed in an attempt to process address data to fit the 
US postal standards.

  The state class contains some STATIC methods for pulling State Names and Abbreviations. 
This can be used to populate a web page or application drop down box and the like without having to 
instantiate the class.


  It is my belief that a data class should handle all the input, output and data manipulation for the data elements that it contains.
Reducing the knowledge and need for an external action class to know how to handle the data class, or where to save it, or even create a data source connector. For example: the address class should instantiate its own SQL connector and load itself from its data source. It should also contain all the code to save itself to the data source. the action class should only have to instantiate the Address class. Call Address.Load, then work with the class, then call Address.Save.

  Another example: in the FullRelationalAddressStructure project, there is an address class that contains a City class. The City class contains a State Class and a ZipCode Class. Once the data sources are set up, i.e. databases, text files or other source for populating the class, 
the developer shouldn't have to be concerned with how the city, states and ZipCode code classes get populated. Additionally, the developer shouldn't be concerned with how the city stores or gets its State or ZipCode data. They simply instantiate an Address class and the rest is handled in the back end. The Address class instantiates a city class, and the City class instantiates the State and ZipCode classes.

The initial version:
  The initial version contains the base class structure with many of the intended validation and standardizations included. There is a test class
included, to get familiar with one way to use it.

  This project will eventually include a complete database creation script that will also contain as much US address data as possible. Such as zip codes, city and state names etc.

Currently the "demonstration" version will do some RegEX validation on Street Address, City Name and Zip Code. States are pulled from a text file.

Incomplete ToDo's
  Address:
     method to get a most likely address Line 1 when no match
  Zip Code:
    when validating a zip5 have this class pull from a data source that has all the valid zip5 & zip4
    Pull actual address when provided Zip+4
    Data source look up of Zip+4 to retrieve city and state
  City:
    on city validation, pull from data source to validate of name, spelling, State, zipcode and county
    Method for name misspelling correction, compare city text with misspelled list
    ability to find city based on zip code
  State:
    state spelling errors check, compare state text with misspelled list
    ability to find state based on zip code
    
This project has dependency on PhoneUtils and StringUtils from the Utils Project