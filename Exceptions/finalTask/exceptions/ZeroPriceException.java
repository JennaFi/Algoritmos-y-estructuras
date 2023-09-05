package Exceptions.finalTask.exceptions;

import java.io.IOException;

public class ZeroPriceException extends IOException {
    public ZeroPriceException(String message) {
        super(message);
    }
}