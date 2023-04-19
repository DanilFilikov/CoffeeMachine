package org.example.domain;

public abstract class CoffeeMachine {

    static final short LIMIT_OF_COFFEE = 500;
    static final short LIMIT_OF_WATER = 1000;
    static final short LIMIT_OF_MILK = 1000;

    private short amountOfCoffee;
    private short amountOfMilk;
    private short amountOfWater;

    protected boolean isOn;

    public static boolean isClean = true;

    public boolean checkIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
       this.isOn = isOn;
    }

    public void setAmountOfWater(short amountOfWater) throws IllegalArgumentException {
        if (amountOfWater > LIMIT_OF_WATER) {
            throw new IllegalArgumentException("reached limit of water: " + amountOfWater + "of " + LIMIT_OF_WATER);
        } else {
            this.amountOfWater = amountOfWater;
        }
    }

    public void setAmountOfCoffee(short amountOfCoffee) throws Exception {
        if (amountOfCoffee > LIMIT_OF_COFFEE) {
            throw new Exception();
        } else {
            this.amountOfCoffee = amountOfCoffee;
        }
    }

    public void setAmountOfMilk(short amountOfMilk) throws Exception {
        if (amountOfMilk > LIMIT_OF_MILK) {
            throw new Exception();
        } else {
            this.amountOfMilk = amountOfMilk;
        }
    }

    public short getAmountOfCoffee() {
        return amountOfCoffee;
    }

    public short getAmountOfMilk() {
        return amountOfMilk;
    }

    public short getAmountOfWater() {
        return amountOfWater;
    }

    public void toggleOnOff() {
        setIsOn(!isOn);
        if (isOn) {
            System.out.println("Кофемашина включена");
            Log.i("Coffee machine started");
        } else {
            System.out.println("Кофемашина выключена");
            Log.i("Coffee machine turned off");
        }
    }

    public void cleanCheck() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        if (!isClean) {
            System.out.println("Кофемашина грязная!\n");
            throw new Exception("Кофемашина грязная!\n");
        }
        Log.i("Checked if machine was clean");
    }

    public abstract void addWater() throws Exception;

    public abstract void machineMenu() throws Exception;

    public abstract void addCoffee() throws Exception;

    public abstract void addMilk() throws Exception;

    public abstract void ingredientsLeft() throws Exception;

    public abstract void clean() throws Exception;

    public abstract void coffeeMenu() throws Exception;

    public abstract void makeCoffee(Coffee title) throws Exception;

    public abstract void ingredientsCheck() throws Exception;

}
