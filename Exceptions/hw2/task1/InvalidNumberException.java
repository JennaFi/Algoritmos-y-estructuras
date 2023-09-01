package Exceptions.hw2.task1;

public class InvalidNumberException extends IllegalArgumentException {

    public InvalidNumberException(String s) {
        super(s);
    }
}