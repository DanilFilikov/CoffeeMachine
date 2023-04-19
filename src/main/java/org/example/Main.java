package org.example;

import org.example.domain.Bosh;
import org.example.domain.CoffeeMachine;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        CoffeeMachine bosh = new Bosh();

        bosh.machineMenu();
    }
}

