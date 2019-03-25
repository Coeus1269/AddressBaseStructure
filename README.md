# AddressBaseStructure
Simplified project for processing US address

  The goal of this project, initially, was to incorporate a standard relational database structure that stored address data in the
most size efficient manor and handled the most common data validation issues for United States addresses.

A complete, simple to set up and use, class structure that would validate and standardize a United States address to fit US postal standards with as much validation as possible. 

  The first version was a full relational structure. It became evident that most developers found it to be an uncomfortable
paradigm shift for implementation. Additionally it allowed the user to enter city, state and zip data, that required validation. The design flaw was
building it to depend on the user to enter in data then validating it.

  The second version, SimpleAddressStructure, is a much Simpler Address Structure, that consists of only 2 tables and meets the goal
of an easy to use, easy to implement address structure. This version eliminates the validation issues for City, State and Zip. 
However it introduced the issue where and address may not be in the database.
  
  Each version has a read me.
  

