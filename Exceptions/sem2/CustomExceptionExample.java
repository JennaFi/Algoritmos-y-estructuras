package Exceptions.sem2;
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    public static void main(String[] args) {
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (DivisionByZeroException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static int divideNumbers(int dividend, int divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed");
        }
        return dividend / divisor;
    }
}