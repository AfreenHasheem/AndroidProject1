package com.example.afreen.androiddevelopertest;

import java.util.List;

public class Profile {

    String uuid;
    String name;
    String profileURL;
    String userNumber;
    List<TelephoneNumber> telephoneNumbers;

    public Profile(String uuid, String name, String profileURL, String userNumber, List<TelephoneNumber> telephoneNumbers) {
        this.uuid = uuid;
        this.name = name;
        this.profileURL = profileURL;
        this.userNumber = userNumber;
        this.telephoneNumbers = telephoneNumbers;
    }
}
