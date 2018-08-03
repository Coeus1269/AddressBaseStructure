# AddressBaseStructure
Simplified project for processing US address

The goal of this project is to incorporate data validation and standard relational database structure, into a complete 
class structure for United States addresses. A complete class structure that will validate and standardize a United States 
address to fit US postal standards with as much validation as possible. 
All into a class structure that is simple to set up and use. 

There are many address elements that can benefit from standardization, clean up or validation. 
Many of these areas will be addressed in an attempt to process address data to fit the 
US postal standards.

This project will attempt to implement data validation and cleaning for data elements like States standardization,
Zip Code, City name and Street address validation.

For example: The state class contains some static methods for pulling State Names and Abbreviations. 
This can be used to populate a web page or application drop down box and the like without having to 
instantiate the class.

It is my belief that a data class should handle all the input, output and data manipulation for the data elements
that it contains. Reducing the knowledge and need for external action classes to need to know how to handle the data class.

For example: in this project  there is an address class that contains a City class. The City class contains a State Class and
a ZipCode Class. Once the data sources are set up, i.e. databases, text files or other source for populating the class, 
the developer shouldn't have to be concerned with how the city, states and zip code classes get populated. 
They simply instantiate an Address class and the rest is handled in the back end.

The initial version:
  The initial version contains the base class structure with many of the intended validation and standardizations included.There is a test class

Finally, this project will eventually include a complete database creation script that will also contain as much US 
address data as possible. Such as zip codes, city and state names etc.

Currently the "demonstration" version will do some RegEX validation on Street Address, City Name and Zip Code. States are puled from a text file.

Incomplete ToDo's 
  Address:
    method to get a most likely address Line 1 when no match
  Zip Code:
    when validating a zip5 have this class pull from a data source that has all the valid zip5 & zip4
    Pull actual address when provided Zip+4
    Data source look up of Zip+4 to retreive city and state
  City:
    on city validation, pull from data source to validate of name, spelling, State, zipcode and county
    Method for name misspelling correction, compare city text with misspelled list
    ability to find city based on zip code
  State:
    state spelling errors check, compare state text with misspelled list
    ability to find state based on zip code
