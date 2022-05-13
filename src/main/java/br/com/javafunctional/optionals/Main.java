package br.com.javafunctional.optionals;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;


/***
 * Amigos Code
 * https://youtu.be/VRpHdSFWGPs?t=5480
 * @author reinaldo_neves@hotmail.com
 * @since may/2022
 */
public class Main {

    public static void main(String[] args) {

//      Só pra lembrar a abstração que rola com o lambda do default value:
//      Supplier<Object> objectSupplier = () -> "default value";

        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

//      Sente o Supplier de IllegalStateException: Não recebe parâmetro, mas retorna um valor pra noiz
//      Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
        Object value2 = Optional.ofNullable("Hellow World")
                .orElseThrow(() -> new IllegalStateException("Exception"));

        System.out.println(value);

//      Se fossemos programar ao modo oldscool, com os parâmetros Consumer<T> e Runnable de ifPresentOrElse declarados fora:
//      Consumer<String> stringConsumer = email -> System.out.println("Sending email to: " + email);
//      Runnable runnable = () -> System.out.println("Cannot send email :(");
        Optional.ofNullable("jhon.frusciante@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to: "+email),
                        () -> System.out.println("Cannot send email :("));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to: "+email),
                        () -> System.out.println("Cannot send email :("));
    }

}
