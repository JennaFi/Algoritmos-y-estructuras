package Exceptions.sem2;

public class CalculatorException extends Exception {
    private String operation;
    private String errorMessage;

    public CalculatorException(String operation, String errorMessage) {
        this.operation = operation;
        this.errorMessage = errorMessage;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String getMessage() {
        return "Error during " + operation + " operation: " + errorMessage;
    }
}