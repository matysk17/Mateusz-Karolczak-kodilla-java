package com.example.calculator;


import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) {

        System.out.println("Wynik dodawania : " + add(10,5));

        System.out.println("Wynik odejmowania : " + sub(10, 5));
    }

    public static int add(int a, int b) {
        int addResult = a + b;
        return addResult;

    }
    public static int sub(int a, int b) {

        int subResult = a - b ;
        return subResult;

    }
    }


