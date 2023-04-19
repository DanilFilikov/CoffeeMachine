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
            throw new IllegalArgumentException("reached limit of coffee: " + amountOfCoffee + "of " + LIMIT_OF_COFFEE);
        } else {
            this.amountOfCoffee = amountOfCoffee;
        }
    }

    public void setAmountOfMilk(short amountOfMilk) throws Exception {
        if (amountOfMilk > LIMIT_OF_MILK) {
            throw new IllegalArgumentException("reached limit of milk: " + amountOfMilk + "of " + LIMIT_OF_MILK);
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
            Log.info("Coffee machine started");
        } else {
            System.out.println("Кофемашина выключена");
            Log.info("Coffee machine turned off");
        }
    }

    public void checkClean() throws Exception {
        if (isOn) {

        if (!isClean) {
            System.out.println("Кофемашина грязная!\n");
            throw new Exception("Кофемашина грязная!\n");
        }
        Log.info("Checked if the machine was clean");
        }
    }

    public void checkIngredients() throws Exception {
        if (isOn) {

            if (getAmountOfCoffee() < 50 || getAmountOfMilk() < 100 || getAmountOfWater() < 200) {
                System.out.println("Недостаточно ингридиентов\n");
                throw new Exception("Недостаточно ингридиентов\n");
            }
            Log.info("Checked if there was enough ingredients");
        }
    }

    public abstract void addWater() throws Exception;

    public abstract void showMenu() throws Exception;

    public abstract void addCoffee() throws Exception;

    public abstract void addMilk() throws Exception;

    public abstract void showIngredients() throws Exception;

    public abstract void clean() throws Exception;

    public abstract void showCoffeeMenu() throws Exception;

    public abstract void makeCoffee(Coffee title) throws Exception;


}
