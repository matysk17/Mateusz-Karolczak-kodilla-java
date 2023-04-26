package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        String result = "No result";
        try {
            result = secondChallenge.probablyIWillThrowException(1.5, 1.5);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println(result);
        }
    }
}