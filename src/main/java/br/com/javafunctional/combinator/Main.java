package br.com.javafunctional.combinator;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer =
                new Customer(
                        "Alice",
                        "alice@gmail.com",
                        "+5511999999999",
                        LocalDate.of(1992, 6, 15));

        System.out.println(new CustomerValidatorService().isValid(customer));

        // If it is valid, it will be stored in DB



    }

}
