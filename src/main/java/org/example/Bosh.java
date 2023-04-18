package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.example.Main.in;

public class Bosh extends CoffeeMachine {
    public static final Logger logger = Logger.getLogger(Bosh.class.getName());
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
            logger.log(Level.INFO, "Coffee machine started");
        } else {
            System.out.println("Кофемашина выключена");
            logger.log(Level.INFO, "Coffee machine turned off");
        }

    }

    @Override
    public void addWater() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Введите кол-во воды: ");
            try {
                setAmount_of_water((short) (getAmount_of_water() + in.nextShort()));
            } catch (Exception exception) {
                System.out.println("Превышена максимальная емкость воды");
            }
            logger.log(Level.INFO, "Added water to the machine");
        }
    }

    @Override
    public void addCoffee() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Введите кол-во кофе: ");
            try {
                setAmount_of_coffee((short) (getAmount_of_coffee() + in.nextShort()));
            } catch (Exception exception) {
                System.out.println("Превышена максимальная емкость кофе");
            }
            logger.log(Level.INFO, "Added coffee to the machine");
        }
    }


    @Override
    public void addMilk() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Введите кол-во молока: ");
            try {
                setAmount_of_milk((short) (getAmount_of_milk() + in.nextShort()));
            } catch (Exception exception) {
                System.out.println("Превышена максимальная емкость молока");
            }
            logger.log(Level.INFO, "Added milk to the machine");
        }
    }
    @Override
    public void ingredientsLeft() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Осталось воды: " + getAmount_of_water() + '/' + LIMIT_OF_WATER);
            System.out.println("Осталось молока: " + getAmount_of_milk() + '/' + LIMIT_OF_MILK);
            System.out.println("Осталось кофе: " + getAmount_of_coffee() + '/' + LIMIT_OF_COFFEE + "\n");
            logger.log(Level.INFO, "Looked throughout the ingredients");
        }
    }

    @Override
    public void clean() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            isClean = true;
            System.out.println("Кофемашина отчищена!\n");
            logger.log(Level.INFO, "Coffee machine has been cleaned");
        }
    }
    @Override
    public void makeCoffee(Coffee title) throws Exception {
        setAmount_of_water((short) (getAmount_of_water() - 200));
        setAmount_of_coffee((short) (getAmount_of_coffee() - 50));
        setAmount_of_milk((short) (getAmount_of_milk() - 100));
    }
    public void createProfile() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Введите имя профиля: ");
            Profiles profiles = new Profiles(in.next());
            System.out.println("Введите напитки(Чтобы закончить введите stop): ");
            List<String> drinks = new ArrayList<>();
            boolean stop = false;
            while (!stop) {
                String coffee = in.next();
                if (coffee.equals("stop")) {
                    stop = true;
                    System.out.println(drinks);
                }
                drinks.add(coffee);
            }
            profiles.setDrinks(drinks);
        }
    }
/*    public void showAllProfiles(){
        Profiles profiles = new Profiles(in.next());
        profiles.getDrinks();
    }*/
    public void recipes() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            System.out.println("Введите название напитка: ");
            switch (in.next()) {
                case "Эспрессо" -> System.out.println("Рецепт1");
                case "Капучино" -> System.out.println("рецепт2");
                case "Американо" -> System.out.println("Рецепт3");
                case "Латте" -> System.out.println("Рецепт4");
            }
            logger.log(Level.INFO, "Looked throughout the recipes");
        }
    }
    public void coffeeMenu() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            count += 1;
            if (count == 10) {
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
                        System.out.println(Coffee.ESPRESSO + " готов в кол-ве: " + drinksCount + "шт!\n");
                        logger.log(Level.INFO, "ESPRESSO has been made");
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
                        logger.log(Level.INFO, "CAPPUCCINO has been made");
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
                        logger.log(Level.INFO, "AMERICANO has been made");
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
                        logger.log(Level.INFO, "LATTE has been made");
                    }
                }
            } catch (Exception ignored) {
            }
            logger.log(Level.INFO, "Looked throughout the menu");
        }
    }

    public void ingredientsCheck() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            if (getAmount_of_coffee() < 50 || getAmount_of_milk() < 100 || getAmount_of_water() < 250) {
                System.out.println("Недостаточно ингридиентов\n");
                throw new Exception("Недостаточно ингридиентов\n");
            }
        }
    }

    @Override
    public void cleanCheck() throws Exception {
        if (!IsOn()) { throw new Exception("Кофемашина не работает");
        }
        else {
            if (!isClean) {
                System.out.println("Кофемашина грязная!\n");
                throw new Exception("Кофемашина грязная!\n");
            }
            logger.log(Level.INFO, "Checked if machine was clean");
        }
    }

    @Override
    public void machineMenu() throws Exception {
        boolean On = true;
        while (On) {
            if (!IsOn()) {
                System.out.println("""
                         Кофемашина не работает
                         
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
                         11)Выход
                        """);
            }else {
                System.out.println("""
                         Кофемашина работает
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
                         11)Выход
                        """);
            }
            try{
            switch (in.nextInt()) {
                case 1 -> machineOnOff();
                case 2 -> addWater();
                case 3 -> addMilk();
                case 4 -> addCoffee();
                case 5 -> ingredientsLeft();
                case 6 -> coffeeMenu();
                case 7 -> clean();
                case 8 -> cleanCheck();
                //  case 9 -> showAllProfiles();
                case 9 -> createProfile();
                case 10 -> recipes();
                case 11 -> {
                    in.close();
                    On = false;
                }
            }
            }catch(Exception ignored){
            }
            }
        }
    }




