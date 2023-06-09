package org.example.domain;

import java.util.HashSet;
import java.util.Set;

public class Profile {

    private final String profileName;
    private final Set<String> drinks = new HashSet<>();

    public Profile(String profileName) {
        this.profileName = profileName;
    }

    public void addDrink(Coffee coffee) {
        if (drinks.contains(coffee.getTitle())) {
            System.out.println("Этот напиток уже добавлен");
        }else {
            System.out.println("Добавлен напиток " + coffee.getTitle());
        }
        drinks.add(coffee.getTitle());
    }

    public Set<String> getDrinks() {
        return drinks;
    }

    @Override
    public String toString() {
        return profileName + ": " + String.join(", ", drinks);
    }
}