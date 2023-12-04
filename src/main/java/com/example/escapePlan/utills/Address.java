package com.example.escapePlan.utills;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {


    private String town;
    private String street;
    private String houseNumber;
    private String postcode;
    private String country;

    ///Przykład stringa: "125;Sunny Street;London;120-35;Great Britain"
    public Address(String stringAddress){

        String[] parts = stringAddress.split(";");
        houseNumber = parts[0];
        street = parts[1];
        town = parts[2];
        postcode = parts[3];
        country = parts[4];
    }

}
