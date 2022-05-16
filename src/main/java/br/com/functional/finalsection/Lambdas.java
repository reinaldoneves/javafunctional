package br.com.functional.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Integer number = null;
        int couter = 0;


        // Lambdas when you have only one return statement
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        // This is the same as (with method reference):
        Function<String, String> upperCaseName2 = String::toUpperCase;

        //Lambdas when you have to write some logic and not return something imediatlly
        Function<String, String> upperCaseName3 = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
            return name.toUpperCase();
        };

        //Lambdas when you have more than one argument
        BiFunction<String, Integer, String> upperCaseName4 =
                (name, age) -> {
                    if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
                    System.out.println(age);
                    return name.toUpperCase();
                };

        System.out.println(upperCaseName4.apply("Naldo", 30));

    }
}