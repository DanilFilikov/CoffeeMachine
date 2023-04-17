package org.example;

public abstract class CoffeeMachine {
    static final short LIMIT_OF_COFFEE = 500;
    static final short LIMIT_OF_WATER = 1000;
    static final short LIMIT_OF_MILK = 1000;
    private final String NAME;
    private short amount_of_coffee;
    private short amount_of_milk;
    private short amount_of_water;
    private static boolean On;
    public static boolean isClean = true;


    public CoffeeMachine(String NAME) {
        this.NAME = NAME;
    }

    public String getName() {
        return NAME;
    }

    public static boolean IsOn() {
        return On;
    }

    public static void setOn(boolean on) {
        On = on;
    }

    public void setAmount_of_water(short amount_of_water) throws Exception {
        if(amount_of_water > LIMIT_OF_WATER){
            throw new Exception();
        }else{
           this.amount_of_water = amount_of_water;
        }
    }

    public void setAmount_of_coffee(short amount_of_coffee) throws Exception {
        if(amount_of_coffee > LIMIT_OF_COFFEE){
            throw new Exception();
        }else{
            this.amount_of_coffee = amount_of_coffee;
        }
    }

    public void setAmount_of_milk(short amount_of_milk) throws Exception {
        if(amount_of_milk > LIMIT_OF_MILK){
            throw new Exception();
        }else{
            this.amount_of_milk = amount_of_milk;
        }
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

    public abstract void machineOnOff();
    public abstract void addWater();
    public abstract void machineMenu() throws Exception;
    public abstract void addCoffee();
    public abstract void addMilk() throws Exception;
    public abstract void ingredientsLeft();
    public abstract void clean();
    public abstract void coffeeMenu() throws Exception;
    public abstract void makeCoffee(Bosh.Coffee title) throws Exception;
    public abstract void ingredientsCheck() throws Exception;
    public abstract void cleanCheck() throws Exception;
}
