package com.company;

class Product{

    private String naam;
    private double prijs;

    public Product(String naam, double prijs) {
        if (prijs < 0) throw new IllegalArgumentException("Prijs kan niet negatief zijn. ");

        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }
}
