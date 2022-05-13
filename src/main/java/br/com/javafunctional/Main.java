package br.com.javafunctional;

import br.com.javafunctional.functionalinterface.Gender;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static br.com.javafunctional.functionalinterface.Gender.*;

public class Main {

	public static void main(String[] args) {

		List<Person> people = List.of(
				new Person("Jack", MALE),
				new Person("Maria", FEMALE),
				new Person("Aisha", FEMALE),
				new Person("Linn", NON_BINARY),
				new Person("Alice", FEMALE),
				new Person("Jhon Frusciante", MALE)
		);

		System.out.println("\nImperative approach");
		// Imperative approach
		List<Person> females = new ArrayList<>();

		for (Person person : people){
			if(FEMALE.equals(person.gender)){
				females.add(person);
			}
		}

		for (Person female : females){
			System.out.println(female);
		}

		System.out.println("\nDeclarative approach");
		// Declarative approach
		Predicate<Person> personPredicate =
				person -> FEMALE.equals(person.gender);
		List<Person> females2 = people.stream()
				.filter(personPredicate)
				.collect(Collectors.toList());

		females2.forEach(System.out::println);
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
