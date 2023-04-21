package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static org.example.Main.in;

public class Bosh extends CoffeeMachine {

    private final List<Profile> profiles = new ArrayList<>();
    private final List<Coffee> drinks = new ArrayList<>();

    private byte count = 0;

    @Override
    public void addWater() {
        if (isOn) {

            System.out.println("Введите кол-во воды: ");

            try {
                setAmountOfWater((short) (getAmountOfWater() + in.nextShort()));
                Log.info("Added water to the machine");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    @Override
    public void addCoffee() {
        if (isOn) {

            System.out.println("Введите кол-во кофе: ");

            try {
                setAmountOfCoffee((short) (getAmountOfCoffee() + in.nextShort()));
                Log.info("Added coffee to the machine");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    @Override
    public void addMilk() {
        if (isOn) {

            System.out.println("Введите кол-во молока: ");

            try {
                setAmountOfMilk((short) (getAmountOfMilk() + in.nextShort()));
                Log.info("Added milk to the machine");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    @Override
    public void showIngredients() {
        if (isOn) {

            System.out.println("Осталось воды: " + getAmountOfWater() + '/' + LIMIT_OF_WATER);
            System.out.println("Осталось молока: " + getAmountOfMilk() + '/' + LIMIT_OF_MILK);
            System.out.println("Осталось кофе: " + getAmountOfCoffee() + '/' + LIMIT_OF_COFFEE + "\n");

            Log.info("Looked throughout the ingredients");
        }
    }

    @Override
    public void clean() {
        if (isOn) {
            if (!isClean) {
                isClean = true;
                System.out.println("Кофемашина отчищена!\n");
                Log.info("Coffee machine has been cleaned");
            } else {
                System.out.println("Чистка не требуется");
            }
        }
    }

    @Override
    public void makeCoffee(Coffee coffee) {
        setAmountOfWater((short) (getAmountOfWater() - 200));
        setAmountOfCoffee((short) (getAmountOfCoffee() - 50));
        setAmountOfMilk((short) (getAmountOfMilk() - 100));
        drinks.add(coffee);
        Log.info("Made a coffee");
    }

    public void createProfile() {
        if (isOn) {

            System.out.println("Введите имя профиля: ");
            Profile profile = new Profile(in.next());
            profiles.add(profile);
            System.out.println("Введите напитки(Чтобы выйти из меню введите 4): ");

            while (true) {
                try{
                for (Coffee coffee : Coffee.values()) {
                    System.out.println(coffee.ordinal() + " " + coffee.getTitle());
                }
                    int coffeeOrdinal = in.nextInt();
                    if(coffeeOrdinal == 4){
                        break;
                    }
                    if (coffeeOrdinal < 0 || coffeeOrdinal > Coffee.values().length) {
                        System.out.println("Нет такого");
                        break;
                    }
                    Coffee coffee = Coffee.values()[coffeeOrdinal];
                    profile.addDrink(coffee);
                    String result = String.join(", ", profile.getDrinks());
                    System.out.println("Напитки сохранены в профиль: " + result);
                    Log.info("Created a profile");
                }catch (InputMismatchException exception){
                    in.next();
                    System.out.println("Необходимо ввести число");
                }
        }
        }

    }

    public void showRecipes() {
        if (isOn) {
            System.out.println("Введите название напитка: ");
            System.out.println(Arrays.toString(Coffee.values()));
            try {
                switch (Coffee.valueOf(in.next())) {
                case ESPRESSO -> System.out.println("Рецепт эспрессо");
                case CAPPUCCINO -> System.out.println("Рецепт капучино");
                case AMERICANO -> System.out.println("Рецепт американо");
                case LATTE -> System.out.println("Рецепт латте");
            }
            Log.info("Looked throughout the recipes");
        }catch (Exception exception){
                System.out.println("Нет такого напитка");
            }
        }
    }

    @Override
    public void showCoffeeMenu() throws Exception{
        if (isOn) {

            Log.info("Looked throughout the menu");

            checkIngredients();
            checkClean();
                while (true) {

                    System.out.println("Выберите желаемый напиток(Чтобы выйти из меню введите 4):");
                    for (Coffee coffee : Coffee.values()) {
                        System.out.println(coffee.ordinal() + " " + coffee.getTitle());
                    }
                    try {
                        if (count == 5) {
                            isClean = false;
                            count = 0;
                        }
                    int coffeeOrdinal = in.nextInt();
                    if(coffeeOrdinal == 4){
                        break;
                    }
                    else if (coffeeOrdinal < 0 || coffeeOrdinal > Coffee.values().length) {
                        System.out.println("Нет такого ");
                        break;
                    }

                    switch (coffeeOrdinal) {
                        case 0 -> {
                            System.out.println("Выбран напиток: " + Coffee.ESPRESSO + "\n");
                            System.out.println("Введите кол-во напитков: \n");
                            int drinksCount = in.nextShort();
                            if (isClean) {
                                for (int i = 0; i < drinksCount; i++) {
                                    checkIngredients();
                                    count += 1;
                                    makeCoffee(Coffee.ESPRESSO);
                                }
                                System.out.println(Coffee.ESPRESSO + " готов в кол-ве: " + drinksCount + "шт!\n");
                                Log.info("ESPRESSO has been made");
                            } else {
                                System.out.println("Кофемашина грязная!");
                            }
                        }
                        case 1 -> {
                            System.out.println("Выбран напиток: " + Coffee.CAPPUCCINO + "\n");
                            System.out.println("Введите кол-во напитков: ");
                            int drinksCount = in.nextShort();
                            if (isClean) {
                            for (int i = 0; i < drinksCount; i++) {
                                checkIngredients();
                                count += 1;
                                makeCoffee(Coffee.CAPPUCCINO);
                            }
                            System.out.println(Coffee.CAPPUCCINO + " готов в кол-ве: " + drinksCount + "шт!\n");
                            Log.info("CAPPUCCINO has been made");
                        } else {
                                System.out.println("Кофемашина грязная!");
                            }
                        }
                        case 2 -> {
                            System.out.println("Выбран напиток: " + Coffee.AMERICANO + "\n");
                            System.out.println("Введите кол-во напитков: ");
                            int drinksCount = in.nextShort();
                            if (isClean) {
                            for (int i = 0; i < drinksCount; i++) {
                                checkIngredients();
                                count += 1;
                                makeCoffee(Coffee.AMERICANO);
                            }
                            System.out.println(Coffee.AMERICANO + " готов в кол-ве: " + drinksCount + "шт!\n");
                            Log.info("AMERICANO has been made");
                        } else {
                                System.out.println("Кофемашина грязная!");
                            }
                        }
                        case 3 -> {
                            System.out.println("Выбран напиток: " + Coffee.LATTE + "\n");
                            System.out.println("Введите кол-во напитков: ");
                            int drinksCount = in.nextShort();
                            if (isClean) {
                            for (int i = 0; i < drinksCount; i++) {
                                checkIngredients();
                                count += 1;
                                makeCoffee(Coffee.LATTE);
                            }
                            System.out.println(Coffee.LATTE + " готов в кол-ве: " + drinksCount + "шт!\n");
                            Log.info("LATTE has been made");
                        }
                            else {
                                System.out.println("Кофемашина грязная!");
                            }
                        }
                    }
                }catch (InputMismatchException exception){
                        in.next();
                        System.out.println("Необходимо ввести число");
                    }
                }
            }
        }


    private void printProfiles() {
        if (isOn) {
            if(profiles.isEmpty()) {
                System.out.println("Записи отсутствуют");
            }
            for (Profile profile : profiles) {
                System.out.println(profile);
                Log.info("Shown profiles");
            }
        }
    }

    private void printDrinks() {
        if (isOn) {
            if(drinks.isEmpty()){
                System.out.println("Записи отсутсвуют");
            }
            System.out.println(drinks);
            Log.info("Shown every coffee that have been made");
        }
    }

    @Override
    public void showMenu() {
        boolean isWorking = true;
        while (isWorking) {
            System.out.println(isOn ? "Кофемашина работает" : "Кофемашина не работает");
            System.out.println("""
                     1)Вкл/Выкл
                     2)Добавить воды
                     3)Добавить молока
                     4)Добавить кофе
                     5)Наличие ингридиентов
                     6)Выбрать напиток
                     7)Отчистить кофемашину
                     8)Проверить чистоту
                     9)Создать профиль
                     10)Рецепты
                     11)Вывести профили
                     12)Вывести приготовленные напитки
                     13)Выход
                    """);
            try{
                switch (in.nextInt()) {
                    case 1 -> toggleOnOff();
                    case 2 -> addWater();
                    case 3 -> addMilk();
                    case 4 -> addCoffee();
                    case 5 -> showIngredients();
                    case 6 -> showCoffeeMenu();
                    case 7 -> clean();
                    case 8 -> checkClean();
                    case 9 -> createProfile();
                    case 10 -> showRecipes();
                    case 11 -> printProfiles();
                    case 12 -> printDrinks();
                    case 13 -> {
                        in.close();
                        isWorking = false;
                    }
                }
                }catch (InputMismatchException exception){
                in.next();
                System.out.println("Необходимо ввести число");
            }catch (Exception exception){
                System.out.println(exception.getMessage());;
            }
        }
    }
}
