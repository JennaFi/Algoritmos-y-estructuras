package Exceptions.hw2.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the value1: ");
        double firstValue = scanner.nextDouble();
        System.out.print("Input the value2: ");
        double secondValue = scanner.nextDouble();
        try {
            System.out.println(calculate(firstValue, secondValue));
            scanner.close();
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    private static double calculate(double value1, double value2) throws DivisionByZeroException {
        if (value2 == 0) throw new DivisionByZeroException("Division by zero is permitted");
        return value1 / value2;
    }
}