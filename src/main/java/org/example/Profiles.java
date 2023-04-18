package org.example;

import java.util.ArrayList;
import java.util.List;

public class Profiles {

    private String profileName;
    private List<String> drinks = new ArrayList<>();


    public Profiles(String profileName) {
        this.profileName = profileName;
    }

    public void setDrinks(List<String> drinks) {
        this.drinks = drinks;
    }
    public List<String> getDrinks() {
        return drinks;
    }
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

}