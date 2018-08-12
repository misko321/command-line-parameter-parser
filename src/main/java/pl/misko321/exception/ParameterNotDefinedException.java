package pl.misko321.exception;

public class ParameterNotDefinedException extends RuntimeException {
    public ParameterNotDefinedException(String name) {
        super("Parameter " + name + " is not allowed");
    }

    public ParameterNotDefinedException(char name) {
        super("Parameter " + name + " is not allowed");
    }
}
