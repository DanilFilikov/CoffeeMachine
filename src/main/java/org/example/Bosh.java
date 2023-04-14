package org.example;

import java.util.Scanner;

import static org.example.Main.in;

public class Bosh extends CoffeeMachine {

    static final short LIMIT_OF_COFFEE = 1000;
    static final short LIMIT_OF_WATER = 1000;
    static final short LIMIT_OF_MILK = 500;

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
        short inWater = in.nextShort();
        try{
        setAmount_of_water((short) (getAmount_of_water() + inWater));
        }catch(Exception exception){
            System.out.println("Превышена максимальная емкость воды");
        }

        }
//        if (getAmount_of_water() + inWater > LIMIT_OF_WATER) {
//            System.out.println("Превышен лимит воды");
//        } else {
//            setAmount_of_water((short) (getAmount_of_water() + inWater));
//        }


    public void waterLeft() {
        System.out.print("Осталось воды: " + getAmount_of_water() + '/' + "1000");
    }

    @Override
    public void workingEmulation() {
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
            }

            System.out.println(getName());
        }

    }

    @Override
    public void addCoffee() {
        System.out.println("Введите кол-во кофе: ");
        short inCoffee = in.nextShort();
        if (getAmount_of_coffee() + inCoffee > LIMIT_OF_COFFEE) {
            System.out.println("Превышен лимит кофе");
        } else {
            setAmount_of_coffee((short) (getAmount_of_coffee() + inCoffee));
        }
    }

    public void coffeeLeft() {
        System.out.print("Осталось кофе: " + getAmount_of_coffee() + '/' + "1000");
    }

    @Override
    public void addMilk() {
        System.out.println("Введите кол-во молока: ");
        short inCoffee = in.nextShort();
        if (getAmount_of_coffee() + inCoffee > LIMIT_OF_COFFEE) {
            System.out.println("Превышен лимит молока");
        } else {
            setAmount_of_coffee((short) (getAmount_of_coffee() + inCoffee));
        }

    }
}




