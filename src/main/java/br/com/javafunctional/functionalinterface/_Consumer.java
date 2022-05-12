package br.com.javafunctional.functionalinterface;

import java.util.function.Consumer;

/***
 * Assim como as Functions nos ajudam a abstrair implementações, porém com retornos de valores,
 * as Consumers são interfaces funcionais que recebem um argumento e não retornam nenhum valor.
 *
 */
public class _Consumer {

    public static void main(String[] args) {

        //Greeting with plain old Java Function
        Customer customer = new Customer("John",
                "123456789");
        greetCustomer(customer);

        // Consumer Functional Interface
        greetCostumerConsumer.accept(customer);

    }

    static Consumer<Customer> greetCostumerConsumer =
            customer -> System.out.println("Hello " + customer.customerName +
                    ", thank you for registering your phone number: "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thank you for registering your phone number: "
                + customer.customerPhoneNumber);
    }

    static class Customer {

        private String customerName;
        private String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}
