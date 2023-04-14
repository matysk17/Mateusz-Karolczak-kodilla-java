package com.kodilla.testing;


import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        System.out.println("Test - pierwszy test jednostkowy:");

        com.example.calculator.Calculator calculator = new com.example.calculator.Calculator();
        int addResult = calculator.add(20, 5);
        int subResult = calculator.sub(20, 5);
        if (addResult == 25 && subResult == 15) {
            System.out.println("Test Calculatora wykonany pozytywnie");
        } else {
            System.out.println("Test Calculatora wykonany negatywnie!");
        }
    }
}