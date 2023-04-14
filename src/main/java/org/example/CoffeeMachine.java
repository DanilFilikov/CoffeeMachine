package org.example;

public abstract class CoffeeMachine {

    private final String NAME;
    private short amount_of_coffee;
    private short amount_of_milk;
    private short amount_of_water;
    private static boolean On;

    public CoffeeMachine(String NAME) {
        this.NAME = NAME;
    }
    public String getName(){
     return NAME;
    }

    public static boolean IsOn() {
        return On;
    }

    public static void setOn(boolean on) {
        On = on;
    }

    public void setAmount_of_water(short amount_of_water) {
        this.amount_of_water = amount_of_water;
    }

    public void setAmount_of_coffee(short amount_of_coffee) {
        this.amount_of_coffee = amount_of_coffee;
    }

    public void setAmount_of_milk(short amount_of_milk) {
        this.amount_of_milk = amount_of_milk;
    }

    public short getAmount_of_coffee() {
        return amount_of_coffee;
    }

    public short getAmount_of_milk() {
        return amount_of_milk;
    }

    public short getAmount_of_water() {
        return amount_of_water;
    }

    public abstract void onOff();
    public abstract void addWater();
    public abstract void machineON();
    public abstract void addCoffee();
    public abstract void addMilk();


}
