package br.com.javafunctional.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public boolean isPhoneNumberValid(String phone) {
        return phone.startsWith("+55");
    }

    public boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() >= 16;
    }

}
