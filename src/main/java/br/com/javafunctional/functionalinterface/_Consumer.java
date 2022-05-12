package br.com.javafunctional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/***
 * Assim como as Functions nos ajudam a abstrair implementações, porém com retornos de valores,
 * as Consumers são interfaces funcionais que recebem um argumento e não retornam nenhum valor.
 * Consumer é a mesma coisa que um método void, só que como é uma interface funcional, no paradigm Declarativo.
 * Continue daqui: https://youtu.be/VRpHdSFWGPs?t=3138
 */
public class _Consumer {

    public static void main(String[] args) {

        //Greeting with plain old Java Function
        Customer customer = new Customer("John Frusciante",
                "123456789");
        greetCustomer(customer);

        // Consumer Functional Interface
        greetCustumerConsumer.accept(customer);
        greetCustumerConsumerV2.accept(customer, true);

        // BiConsumer Functional Interface
        greetCustumerConsumerV2.accept(customer, false);

    }

    static BiConsumer<Customer, Boolean> greetCustumerConsumerV2 =
            (customer, showPhoneNumber) ->
                    System.out.println("Hello " + customer.customerName +
                    ", thank you for registering your phone number: "
                    + (showPhoneNumber? customer.customerPhoneNumber: "******"));

    static Consumer<Customer> greetCustumerConsumer =
            customer -> System.out.println("Hello " + customer.customerName +
                    ", thank you for registering your phone number: "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thank you for registering your phone number: "
                + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thank you for registering your phone number: "
                + (showPhoneNumber? customer.customerPhoneNumber: "******"));
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
