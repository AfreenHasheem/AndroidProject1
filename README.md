# AndroidProject1
This project is determined to fetch profile data from a given API and display it on the Android App.
On tapping a button, it shows a progress bar while the data is being fetched and then displayes the profile information in
a standard format.

Constants.java
This class consists of the API path that the data is being fetched from. 
DATA_API="https://private-bc5bb-engagingtech.apiary-mock.com/user"


Fetch.java
This class contains an Asynchronous method that parses the JSON data from the API and converts it into JSON objects by splitting it 
into name, uuid, profile_url,user_number,telephone_numbers and type.
It also contains an Interface "ProfileResponseCallback" that retrieves a profile on successful resposne from the HTTPHandler.


HttpHandler.java
This class performs a network connection and uses the GET method to request for data.Different types of probable exceptions are 
caught in these classes.
This class also contains a method "convertStreamToString" to read Buffered input.


MainActivity.java
This class contains a button that on tapping calls the "UserProfileActivity" class.


Profile.java
Contains the custom Profile constructor with custom parameters:
    String uuid;
    String name;
    String profileURL;
    String userNumber;
    List<TelephoneNumber> telephoneNumbers;
    
    
    
TelephoneNumber.java
Contains getter and setter methods for the telephone numbers

TelephoneNumberAdapter.java
Is a RecyclerView Adapter that formats any number to a standard format(formatPhoneNumber()) and binds the view depending on the type
of number(i.e work,home or other)


UserProfileActivity.java
This class shows a progress bar while waiting to load the data from the server and displays the data available on the server.

