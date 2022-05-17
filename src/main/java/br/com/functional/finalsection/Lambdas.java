package br.com.functional.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

/***
 * @author reinaldo_neves@hotmail.com
 * This class contains some ways of using lambdas.
 *
 */
public class Lambdas {

    public static void main(String[] args) {

        Integer number = null;
        int couter = 0;


        // Lambdas when you have only one return statement
        Function<String, String> upperCaseName = name -> name.toUpperCase();
        // This is the same as (with method reference
        // - A reference to the method of the given tipe (String)):
        Function<String, String> upperCaseName2 = String::toUpperCase;

        //Lambdas when you have to write some logic and not return something imediatlly
        // from a method of the given parameter type (String in this case):
        Function<String, String> upperCaseName3 = name -> {
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
            return name.toUpperCase();
        };

        //Lambdas when you have more than one argument, for example with the BiFunction interface.
        //here we have to use parentesis because we have two arguments before the arrow:
        BiFunction<String, Integer, String> upperCaseName4 =
                (name, age) -> {
                    if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
                    System.out.println(age);
                    return name.toUpperCase();
                };

        System.out.println(upperCaseName4.apply("Naldo", 30));

    }
}