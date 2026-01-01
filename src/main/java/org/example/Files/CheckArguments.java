package org.example.Files;

import org.example.Files.Enums.Options;

public class CheckArguments {

    public static void check(String[] args, int i, Options argName) throws RuntimeException {
        if (args[i + 1].startsWith("-")) {
            throw new RuntimeException(String.format("Нет аргумента для %s!", argName));
        }
        if (!args[i + 2].startsWith("-")) {
            throw new RuntimeException(String.format("Аргумента для %s! должен быть 1!", argName));
        }
    }
}
