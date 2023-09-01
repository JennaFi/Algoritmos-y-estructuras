package Exceptions.hw2.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
        try {
            System.out.println(validNumber(scanner.nextInt()));
            scanner.close();
        } catch (InvalidNumberException e) {
            System.out.println(e + e.getMessage());
        }
        scanner.close();
    }

    private static String validNumber(int num) throws InvalidNumberException {
        if (num < 0) throw new InvalidNumberException("The number must be more than zero");
        return "The number is correct!";
    }
}