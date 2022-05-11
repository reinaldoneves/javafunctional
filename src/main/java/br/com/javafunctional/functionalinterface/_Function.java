package br.com.javafunctional.functionalinterface;

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

        // Olha só que pira, dá pra encadear as funções (métodos) e passar um
        // método por parâmetro para outro método, eternamente!
        // É aqui que a SkyNet começa. :\
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

    }

    // Escrevendo de forma imperativa
    // nem tudo precisa ser hardcoded ou implementado literalmente pelo dev.
    static int incrementByOne(int number) {
        return number + 1;
    }

    // Escrevendo de forma declarativa
    // Forma oldschool de codar, em que o dev. precisa implementar a funcao literalmente, step by step.
    // Function<T, R> recebe um parametro T (input) e retorna um parametro R (output)
    static Function<Integer, Integer> incrementByOneFunction
            = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function
            = number -> number * 10;


}
