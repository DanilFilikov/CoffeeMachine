package org.example.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Main.in;

public class Bosh extends CoffeeMachine {


    private final List<Profile> profiles = new ArrayList<>();
    private final List<Coffee> drinks = new ArrayList<>();

    private byte count = 0;

    @Override
    public void addWater() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Введите кол-во воды: ");

        try {
            setAmountOfWater((short) (getAmountOfWater() + in.nextShort()));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        Log.i("Added water to the machine");
    }

    @Override
    public void addCoffee() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Введите кол-во кофе: ");

        try {
            setAmountOfCoffee((short) (getAmountOfCoffee() + in.nextShort()));
        } catch (Exception exception) {
            System.out.println("Превышена максимальная емкость кофе");
        }

        Log.i("Added coffee to the machine");
    }


    @Override
    public void addMilk() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Введите кол-во молока: ");

        try {
            setAmountOfMilk((short) (getAmountOfMilk() + in.nextShort()));
        } catch (Exception exception) {
            System.out.println("Превышена максимальная емкость молока");
        }

        Log.i("Added milk to the machine");

    }

    @Override
    public void ingredientsLeft() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Осталось воды: " + getAmountOfWater() + '/' + LIMIT_OF_WATER);
        System.out.println("Осталось молока: " + getAmountOfMilk() + '/' + LIMIT_OF_MILK);
        System.out.println("Осталось кофе: " + getAmountOfCoffee() + '/' + LIMIT_OF_COFFEE + "\n");

        Log.i("Looked throughout the ingredients");
    }

    @Override
    public void clean() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        isClean = true;
        System.out.println("Кофемашина отчищена!\n");
        Log.i("Coffee machine has been cleaned");
    }

    @Override
    public void makeCoffee(Coffee coffee) throws Exception {
        setAmountOfWater((short) (getAmountOfWater() - 200));
        setAmountOfCoffee((short) (getAmountOfCoffee() - 50));
        setAmountOfMilk((short) (getAmountOfMilk() - 100));
        drinks.add(coffee);
    }

    public void createProfile() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Введите имя профиля: ");
        Profile profile = new Profile(in.next());
        profiles.add(profile);

        System.out.println("Введите напитки(Чтобы закончить введите stop): ");
        for (Coffee coffee : Coffee.values()) {
            System.out.println(coffee.ordinal() + " " + coffee.getTitle());
        }

        while (true) {
            int coffeeOrdinal = in.nextInt();
            if (coffeeOrdinal < 0 || coffeeOrdinal > Coffee.values().length) {
                System.out.println("Нет такова ");
                break;
            }
            Coffee coffee = Coffee.values()[coffeeOrdinal];
            profile.addDrink(coffee);
            System.out.println("Добавлен напиток " + coffee.getTitle());
        }
        String result = String.join(", ", profile.getDrinks());
        System.out.println("Напитки сохранены в профиль: " + result);
    }

    public void recipes() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        System.out.println("Введите название напитка: ");


        // TODO: handle error
        switch (Coffee.valueOf(in.next())) {
            case ESPRESSO -> System.out.println("Рецепт1");
            case CAPPUCCINO -> System.out.println("рецепт2");
            case AMERICANO -> System.out.println("Рецепт3");
            case LATTE -> System.out.println("Рецепт4");
        }

        Log.i("Looked throughout the recipes");
    }

    public void coffeeMenu() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        count += 1;

        if (count == 10) {
            isClean = false;
        }

        try {
            cleanCheck();
            ingredientsCheck();
            System.out.println("Выберите желаемый напиток:" + Arrays.toString(Coffee.values()));

            // TODO: extract to method
            switch (in.nextShort()) {
                case 1 -> {
                    System.out.println("Выбран напиток: " + Coffee.ESPRESSO + "\n");
                    System.out.println("Введите кол-во напитков: \n");
                    int drinksCount = in.nextShort();
                    for (int i = 0; i < drinksCount; i++) {
                        cleanCheck();
                        ingredientsCheck();
                        count += 1;
                        makeCoffee(Coffee.ESPRESSO);
                    }
                    System.out.println(Coffee.ESPRESSO + " готов в кол-ве: " + drinksCount + "шт!\n");
                    Log.i("ESPRESSO has been made");
                }
                case 2 -> {
                    System.out.println("Выбран напиток: " + Coffee.CAPPUCCINO + "\n");
                    System.out.println("Введите кол-во напитков: ");
                    int drinksCount = in.nextShort();
                    for (int i = 0; i < drinksCount; i++) {
                        cleanCheck();
                        ingredientsCheck();
                        count += 1;
                        makeCoffee(Coffee.CAPPUCCINO);
                    }
                    System.out.println(Coffee.CAPPUCCINO + " готов в кол-ве: " + drinksCount + "шт!\n");
                    Log.i("CAPPUCCINO has been made");
                }
                case 3 -> {
                    System.out.println("Выбран напиток: " + Coffee.AMERICANO + "\n");
                    System.out.println("Введите кол-во напитков: ");
                    int drinksCount = in.nextShort();
                    for (int i = 0; i < drinksCount; i++) {
                        cleanCheck();
                        ingredientsCheck();
                        count += 1;
                        makeCoffee(Coffee.AMERICANO);
                    }
                    System.out.println(Coffee.AMERICANO + " готов в кол-ве: " + drinksCount + "шт!\n");
                    Log.i("AMERICANO has been made");
                }
                case 4 -> {
                    System.out.println("Выбран напиток: " + Coffee.LATTE + "\n");
                    System.out.println("Введите кол-во напитков: ");
                    int drinksCount = in.nextShort();
                    for (int i = 0; i < drinksCount; i++) {
                        cleanCheck();
                        ingredientsCheck();
                        count += 1;
                        makeCoffee(Coffee.LATTE);
                    }
                    System.out.println(Coffee.LATTE + " готов в кол-ве: " + drinksCount + "шт!\n");
                    Log.i("LATTE has been made");
                }
            }
        } catch (Exception ignored) {
        }
        Log.i("Looked throughout the menu");
    }

    public void ingredientsCheck() throws Exception {
        if (!isOn) {
            throw new Exception("Кофемашина не работает");
        }

        if (getAmountOfCoffee() < 50 || getAmountOfMilk() < 100 || getAmountOfWater() < 250) {
            System.out.println("Недостаточно ингридиентов\n");
            throw new Exception("Недостаточно ингридиентов\n");
        }
    }

    private void printProfiles() {
        for (Profile profile : profiles) {
            System.out.println(profile);
        }
    }

    @Override
    public void machineMenu() {
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
                     12)Выход
                    """);
            try {
                switch (in.nextInt()) {
                    case 1 -> toggleOnOff();
                    case 2 -> addWater();
                    case 3 -> addMilk();
                    case 4 -> addCoffee();
                    case 5 -> ingredientsLeft();
                    case 6 -> coffeeMenu();
                    case 7 -> clean();
                    case 8 -> cleanCheck();
                    case 9 -> createProfile();
                    case 10 -> recipes();
                    case 11 -> printProfiles();
                    case 12 -> {
                        in.close();
                        isWorking = false;
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }
}
