package br.com.javafunctional.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

/**
 * Essa é uma Interface funcional que simplesmente retorna um valor.
 * Ou seja, um fornecedor de qualquer tipo <T>
 */
public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:3306/character_app";
    }

    static Supplier<String> getDBConnectionUrlSupplier =
         () -> "jdbc://localhost:3306/character_app";

    static Supplier<List<String>> getDBConnectionUrlsSupplier =
            () -> List.of("jdbc://localhost:3306/character_app",
                    "jdbc://localhost:3306/equipament_app",
                    "jdbc://localhost:3306/map_app",
                    "jdbc://localhost:3306/battle_system_app",
                    "jdbc://localhost:3306/dialogue_app");

}
