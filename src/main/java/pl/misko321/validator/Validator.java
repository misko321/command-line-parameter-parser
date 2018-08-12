package pl.misko321.validator;

@FunctionalInterface
public interface Validator {
    boolean validate(String parameter);
}
