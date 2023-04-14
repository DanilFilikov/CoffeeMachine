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
    public void onOff() {
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
        if (getAmount_of_water() + inWater > LIMIT_OF_WATER){
            System.out.println("Превышен лимит воды");
        } else
        {
            setAmount_of_water((short) (getAmount_of_water() + inWater));
        }
    }
    public void waterLeft(){
        System.out.print("Осталось воды: " + getAmount_of_water() + '/' + "1000");
    }

    @Override
    public void machineON() {
        boolean On = true;
        while (On) {
            if (!IsOn()) {
                System.out.println(" 1)Включить кофе машину");
            } else {
                System.out.println(" 1)Выключить кофе машину\n 2)Налить воды\n 3)Сколько осталось воды\n 4)Налить молока");
            }
            switch (in.nextInt()) {
                case 1 -> onOff();
                case 2 -> addWater();
                case 3 -> waterLeft();
            }

            System.out.println(getName());
        }

    }

    @Override
    public void addCoffee() {

    }

    @Override
    public void addMilk() {

    }
}




