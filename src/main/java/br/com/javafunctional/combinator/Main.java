package br.com.javafunctional.combinator;

import java.time.LocalDate;
import static br.com.javafunctional.combinator.CustomerRegistrationValidator.*;

/***
 * Testing the Combinator Pattern
 * @author reinaldo_neves@hotmail.com
 *
 * https://youtu.be/VRpHdSFWGPs?t=6804
 */
public class Main {

    public static void main(String[] args) {
        Customer customer =
                new Customer(
                        "Alice",
                        "alice@gmail.com",
                        "+5511999999999",
                        LocalDate.of(2014, 6, 15));

        System.out.println(new CustomerValidatorService().isValid(customer));

        // If it is valid, it will be stored in DB

        // Using combinator pattern
        ValidationResult result =
                isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

//        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }

}
