package br.com.javafunctional.streams;

import br.com.javafunctional.functionalinterface.Gender;
import lombok.ToString;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static br.com.javafunctional.functionalinterface.Gender.*;
import static br.com.javafunctional.functionalinterface.Gender.FEMALE;


/**
 * @author reinaldo_neves@hotmail.com
 *
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
 * https://youtu.be/VRpHdSFWGPs?t=4765
 */
public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jack", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Linn", NON_BINARY),
                new Person("Alice", FEMALE),
                new Person("Jhon Frusciante", MALE)
        );

        /***
         * O Stream recebe funções por parâmetro, para que você manipule uma
         * coleção/elemento da coleção ou filtre da maneira que bem entender.
         * Algumas dessas funções pode ser, por exemplo: Function, Predicate, Supplier, Consumer, etc
         * É possível passar a lambda diretamente, ou (ver mais abaixo):
         */
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        /***
         * Passar as variáveis com os resultados das funções, que já não foram implementadas,
         * mas apenas declaradas.
         * Perceba como o código fica muito mais legível e enxuto no exemplo de cima.
         * Perceba ainda que a gente pode usar todas as funções que vimos até aqui:
         */
        Function<Person, String> personStringFunction = person -> person.name;
        Collector<String, ?, Set<String>> stringSetCollector = Collectors.toSet();
        Consumer<String> println = x -> System.out.println(x);

        people.stream()
                .map(personStringFunction)
                .collect(stringSetCollector)
                .forEach(println);

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

//        System.out.println("\nImperative approach");
//        // Imperative approach
//        List<Person> females = new ArrayList<>();
//
//        for (Person person : people){
//            if(FEMALE.equals(person.gender)){
//                females.add(person);
//            }
//        }
//
//        for (
//                Person female : females){
//            System.out.println(female);
//        }
//
//        System.out.println("\nDeclarative approach");
//        // Declarative approach
//        Predicate<Person> personPredicate =
//                person -> FEMALE.equals(person.gender);
//        List<Person> females2 = people.stream()
//                .filter(personPredicate)
//                .collect(Collectors.toList());
//
//        females2.forEach(System.out::println);

    }

    @ToString
    static class Person {
        private String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;

        }
    }

}
