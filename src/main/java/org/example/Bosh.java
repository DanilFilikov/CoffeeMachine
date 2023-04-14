package org.example;

import java.util.Scanner;

import static org.example.Main.in;

public class Bosh extends CoffeeMachine {

    public Bosh(String NAME) {
        super(NAME);
    }

    @Override
    public void machineOnOff() {
        setOn(!IsOn());
        if (IsOn()) {
            System.out.println("Кофемашина включена");
        } else {
            System.out.println("Кофемашина выключена");
        }
    }

    @Override
    public void addWater() {
        System.out.println("Введите кол-во воды: ");
        try {
            setAmount_of_water((short) (getAmount_of_water() + in.nextShort()));
        } catch (Exception exception) {
            System.out.println("Превышена максимальная емкость воды");
        }
    }

    @Override
    public void waterLeft() {
        System.out.print("Осталось воды: " + getAmount_of_water() + '/' + "1000");
    }

    @Override
    public void addCoffee() {
        System.out.println("Введите кол-во кофе: ");
        try {
            setAmount_of_coffee((short) (getAmount_of_coffee() + in.nextShort()));
        }catch (Exception exception){
            System.out.println("Превышена максимальная емкость кофе");
        }
    }
    @Override
    public void coffeeLeft() {
        System.out.print("Осталось кофе: " + getAmount_of_coffee() + '/' + "700");
    }

    @Override
    public void addMilk() throws Exception {
        System.out.println("Введите кол-во молока: ");
        try{
            setAmount_of_milk((short) (getAmount_of_milk() + in.nextShort()));
        }catch (Exception exception){
            System.out.println("Превышена максимальная емкость молока");
        }
    }

    @Override
    public void milkLeft() {
        System.out.print("Осталось молока: " + getAmount_of_milk() + '/' + "350");
    }

    @Override
    public void clean() {
        System.out.println("Кофемашина отчищена!");
    }

    @Override
    public void workingEmulation() throws Exception {
        boolean On = true;
        while (On) {
            if (!IsOn()) {
                System.out.println(" 1)Включить кофе машину");
            } else {
                System.out.println(" 1)Выключить кофе машину\n 2)Налить воды\n 3)Сколько осталось воды\n 4)Налить молока");
            }
            switch (in.nextInt()) {
                case 1 -> machineOnOff();
                case 2 -> addWater();
                case 3 -> waterLeft();
                case 4 -> addCoffee();
                case 5 -> coffeeLeft();
                case 6 -> addMilk();
                case 7 -> milkLeft();
            }
        }
    }
}




