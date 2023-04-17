package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import static org.example.Main.in;

public class Bosh extends CoffeeMachine {
    public Bosh(String NAME) {
        super(NAME);
    }
    private byte count = 0;

    public enum Coffee {
        ESPRESSO("Эспрессо"),
        CAPPUCCINO("Капучино"),
        AMERICANO("Американо"),
        LATTE("Латте");

        private final String title;

        Coffee(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

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
    public void addCoffee() {
        System.out.println("Введите кол-во кофе: ");
        try {
            setAmount_of_coffee((short) (getAmount_of_coffee() + in.nextShort()));
        } catch (Exception exception) {
            System.out.println("Превышена максимальная емкость кофе");
        }
    }


    @Override
    public void addMilk() throws Exception {
        System.out.println("Введите кол-во молока: ");
        try {
            setAmount_of_milk((short) (getAmount_of_milk() + in.nextShort()));
        } catch (Exception exception) {
            System.out.println("Превышена максимальная емкость молока");
        }
    }
    @Override
    public void ingredientsLeft() {
        System.out.println("Осталось воды: " + getAmount_of_water() + '/' + LIMIT_OF_WATER);
        System.out.println("Осталось молока: " + getAmount_of_milk() + '/' + LIMIT_OF_MILK);
        System.out.println("Осталось кофе: " + getAmount_of_coffee() + '/' + LIMIT_OF_COFFEE + "\n");
    }

    @Override
    public void clean() {
        isClean = true;
        System.out.println("Кофемашина отчищена!\n");
    }
    @Override
    public void makeCoffee(Coffee title) throws Exception {
        setAmount_of_water((short) (getAmount_of_water() - 200));
        setAmount_of_coffee((short) (getAmount_of_coffee() - 50));
        setAmount_of_milk((short) (getAmount_of_milk() - 100));
    }
    public void createProfile(){
        System.out.println("Введите имя профиля: ");
        Profiles profiles = new Profiles(in.next());
    }
    public void recepies(){
        System.out.println("Введите название напитка: ");
        switch (in.next()) {
            case "Эспрессо" -> System.out.println("Рецепт1");
            case "Капучино" -> System.out.println("рецепт2");
            case "Американо" -> System.out.println("Рецепт3");
            case "Латте" -> System.out.println("Рецепт4");
        }
    }
    public void coffeeMenu() throws Exception {
        count += 1;
        if (count == 10){
            isClean = false;
        }
        try {
            cleanCheck();
            ingredientsCheck();
            System.out.println("Выберите желаемый напиток:" + Arrays.toString(Coffee.values()));
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
                    System.out.println( Coffee.ESPRESSO + " готов в кол-ве: " + drinksCount + "шт!\n");
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
                    System.out.println( Coffee.CAPPUCCINO + " готов в кол-ве: " + drinksCount + "шт!\n");
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
                    System.out.println( Coffee.AMERICANO + " готов в кол-ве: " + drinksCount + "шт!\n");
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
                    System.out.println( Coffee.LATTE + " готов в кол-ве: " + drinksCount + "шт!\n");
                }
            }
        } catch(Exception ignored){
        }
    }

    public void ingredientsCheck() throws Exception {
        if(getAmount_of_coffee() < 50 || getAmount_of_milk() < 100 || getAmount_of_water() < 250){
            System.out.println("Недостаточно ингридиентов\n");
            throw new Exception("Недостаточно ингридиентов\n");
        }
    }

    @Override
    public void cleanCheck() throws Exception {
        if (!isClean){
            System.out.println("Кофемашина грязная!\n");
            throw new Exception("Кофемашина грязная!\n");
        }
    }

    @Override
    public void machineMenu() throws Exception {
        boolean On = true;
        while (On) {
            if (!IsOn()) {
                System.out.println(" 1)Включить кофе машину");
            } else {
                System.out.println("""
                         1)Выключить кофе машину
                         2)Добавить воды
                         3)Добавить молока
                         4)Добавить кофе
                         5)Наличие ингридиентов
                         6)Выбрать напиток
                         7)Отчистить кофемашину
                         8)Проверить чистоту
                         9)Выбрать профиль
                         10)Создать профиль
                         11)Рецепты
                        """);
            }
            switch (in.nextInt()) {
                case 1 -> machineOnOff();
                case 2 -> addWater();
                case 3 -> addMilk();
                case 4 -> addCoffee();
                case 5 -> ingredientsLeft();
                case 6 -> coffeeMenu();
                case 7 -> clean();
                case 8 -> cleanCheck();
                case 11-> recepies();

            }
        }
    }
}




