package br.com.javafunctional.functionalinterface;

import java.util.function.Predicate;

/**
 * @author reinaldo_neves@hotmail.com
 *
 * Predicate - Predicate interface is a functional interface that takes one argument and returns a boolean value.
 * Assim como Function e Consumer, Predicate é a uma forma de delegar a implementação de um método;
 * O predicate recebe um argumento e retorna um valor booleano, verdadeiro ou falso.
 * Vale lembrar que os predicates podem ser bem úteis na hora de fazer consultas em um banco de dados,
 * e portanto, na implementação de filtros em um repositório JPA/Hibernate.
 *
 * <BiPredicate> - É a mesma coisa que o BiFunction só que nesse caso, para um método booleano de
 * validação com dois parâmetros
 */
public class _Predicate {

    public static void main(String[] args) {

        System.out.println("\nWithout Predicate");
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("07000000001"));
        System.out.println(isPhoneNumberValid("09009877300"));

        System.out.println("\nWith Predicate");
        boolean test = isPhoneNumberValidPredicate.test("0700000000");
        System.out.println(test);
        System.out.println(isPhoneNumberValidPredicate.test("07000000001"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        System.out.println("\nIs phone number valid and contains number 3 = "
                + isPhoneNumberValidPredicate.and(containsNumber3).
                test("09009877300"));

        System.out.println("\nIs phone number valid and contains number 3 = "
                + isPhoneNumberValidPredicate.or(containsNumber3).
                test("0700000000"));

    }

    /**
     * Plain old java method/function for validating phone number
     * @param phoneNumber phone number to be validated
     * @return true if it is a valid phone number
     */
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07")
                && phoneNumber.length() == 11;
    }

    /**
     * Predicate Functional interface
     * @param phoneNumber phone number to be validated
     * @return true if it is a valid phone number
     */
    static Predicate<String> isPhoneNumberValidPredicate
            = phoneNumber -> phoneNumber.startsWith("07")
                && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3
            = phoneNumber -> phoneNumber.contains("3");

}
