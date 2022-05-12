package br.com.javafunctional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Reinaldo
 * Amigos Code study of Java Functional programming
 * https://youtu.be/VRpHdSFWGPs?t=2224
 */
public class _Function {

    public static void main(String[] args) {

        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(2);
        System.out.println(multiply);

        /** Olha só que pira, dá pra encadear as funções (métodos) e passar um
         método por parâmetro para outro método, eternamente!
         É aqui que a SkyNet começa. :c
         */
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

    }

    /** Escrevendo de forma imperativa
     Forma oldschool de codar, em que o dev. precisa implementar a função literalmente, step by step.
     Nem tudo precisa ser hardcoded ou implementado literalmente pelo dev.
    */
    static int incrementByOne(int number) {
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1)*numToMultiplyBy;
    }


    /** Escrevendo de forma declarativa
     Não precisa ser hardcoded ou implementado literalmente pelo dev.
     Function<T, R> recebe um parametro T (input) e retorna um parametro R (output)
     Veja como Function generaliza ao máximo o que é um método bem como os parâmetros.
     */
    static Function<Integer, Integer> incrementByOneFunction
            = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function
            = number -> number * 10;

    /**
     * BiFunction é a mesma coisa que Function, só que aceita 2 parâmetros.
     */
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1)*numberToMultiplyBy;


}
