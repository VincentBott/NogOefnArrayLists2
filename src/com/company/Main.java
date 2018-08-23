package com.company;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> producten = leesProducten(scanner);

        boolean eindeProgramma = false;

        do {
            System.out.println("Wat wilt u zien? ");
            System.out.println("1. De hoogste prijs");
            System.out.println("2. De laagste prijs");
            System.out.println("3. De gemiddelde prijs");
            System.out.print("Uw keuze: ");

            int keuze = Integer.parseInt(scanner.nextLine());

            switch (keuze) {

                case 1:
                    double hoogste = getHoogstePrijs(producten);

                    System.out.printf("De hoogste prijs is %.2f%n", hoogste);
                    eindeProgramma = true;
                    break;
                case 2:
                    double laagste = getLaagstePrijs(producten);

                    System.out.printf("De laagste prijs is %.2f%n", laagste);
                    eindeProgramma = true;
                    break;
                case 3:
                    double gemiddelde = getGemiddeldePrijs(producten);

                    System.out.printf("De gemiddelde prijs is %.2f%n", gemiddelde);
                    eindeProgramma = true;
                    break;
            }

        } while (!eindeProgramma);

    }

    private static double getGemiddeldePrijs(ArrayList<Product> producten) {

        double prijs = 0;

        for (Product prod : producten) {
            prijs = prijs + prod.getPrijs();
        }

        return prijs / producten.size();
    }

    private static double getLaagstePrijs(ArrayList<Product> producten) {

        /* Eigen versie hieronder.

        double laagsteprijs = producten.get(0).getPrijs();

        for (int i = 1; i < producten.size(); i++) {
            if (producten.get(i).getPrijs() < producten.get(i + 1).getPrijs())
                laagsteprijs = producten.get(i).getPrijs();
        }

        return laagsteprijs;
        */


        double laagstePrijs = producten.get(0).getPrijs();

        for (int i = 0; i < producten.size(); i++) {
            if (producten.get(i).getPrijs() < laagstePrijs) {
                laagstePrijs = producten.get(i).getPrijs();
            }
        }

        return laagstePrijs;
    }



    private static double getHoogstePrijs(ArrayList<Product> producten) {

        /* Eigen versie hieronder.

        double hoogsteprijs = 0;

        for (int i = 0; i < producten.size(); i++) {
            if (producten.get(i).getPrijs() > producten.get(i + 1).getPrijs())
                hoogsteprijs = producten.get(i).getPrijs();
        }

        */

            double hoogstePrijs = producten.get(0).getPrijs();

            for (int i = 0; i < producten.size(); i++) {
                if (producten.get(i).getPrijs() > hoogstePrijs) {
                    hoogstePrijs = producten.get(i).getPrijs();
                }
            }
            return hoogstePrijs;
    }


    private static ArrayList<Product> leesProducten(Scanner scanner) {


        ArrayList<Product> producten = new ArrayList<>();

        String productnaam;

        do {

            System.out.print("Geef productnaam(<RETURN> om te stoppen): ");

            productnaam = scanner.nextLine();


            if (!productnaam.equals("")) {

                double prijs;

                do {

                    System.out.print("Geef prijs: ");

                    prijs = Double.parseDouble(scanner.nextLine());


                    try {
                        Product product = new Product(productnaam, prijs);

                        producten.add(product);
                    } catch (IllegalArgumentException e) {

                        System.out.print(e);
                    }
                } while (prijs < 0);

            }

        } while (!productnaam.equals(""));

        return producten;
    }
}

/*
Geef productnaam(<RETURN> om te stoppen): potlood
Geef prijs: -5
Prijs mag niet negatief zijn. Geef prijs: 5
Geef productnaam(<RETURN> om te stoppen): gom
Geef prijs: 9
Geef productnaam(<RETURN> om te stoppen): lat
Geef prijs: 3
Geef productnaam(<RETURN> om te stoppen): 
Wat wilt u zien? 
1. De hoogste prijs
2. De laagste prijs
3. De gemiddelde prijs
Uw keuze: 3
De gemiddelde prijs is 5,67
 */
