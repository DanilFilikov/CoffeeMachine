package org.example.domain;

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
