package org.example;

import java.util.Scanner;
import java.util.logging.Level;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        CoffeeMachine bosh = new Bosh("Bosh");
        bosh.machineMenu();

    }
}

