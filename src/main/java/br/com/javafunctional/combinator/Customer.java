package br.com.javafunctional.combinator;

import java.time.LocalDate;

public class Customer {

    /**
     *Customer's name
     **/
    private final String name;
    /**
     *Customer's email
     **/
    private final String email;
    /**
     *Customer's Phone
     **/
    private final String phoneNumber;
    /**
     *Customer's Birth Date
     **/
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

}
