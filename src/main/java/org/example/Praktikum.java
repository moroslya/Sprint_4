package org.example;

public class Praktikum {

    public static void main(String[] args) {

        String userName = "Иван Иванов";

        Account account = new Account(userName);

        if (account.checkNameToEmboss()) {

            System.out.println("Строку \"" + userName + "\" можно напечатать на карте");

        } else {

            System.out.println("Строку \"" + userName + "\" нельзя напечатать на карте");

        }

    }

}