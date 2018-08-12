package pl.misko321.parser;

import pl.misko321.exception.ParameterNotDefinedException;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Preprocessor {
    private final List<ParameterDefinition> definitions;
    private final ParserResult result = new ParserResult();

    public Preprocessor(List<ParameterDefinition> definitions) {
        this.definitions = definitions;
    }

    public ParserResult preprocess(String[] args) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(args));

        while (!deque.isEmpty()) {
            String next = deque.pop();
            if (next.startsWith("-")) {
                parseShortArgs(next, deque);
            } else if (next.startsWith("--")) {
                parseLongArgs(next, deque);
            } else {
                result.addPositional(next);
            }
        }

        return result;
    }

    private void parseShortArgs(String arg, Deque<String> remainingArgs) {
        for (int i = 1; i < arg.length(); ++i) {
            ParameterDefinition definition = findByShortName(arg.charAt(i));
            if (definition.takesValue()) {
                String value = arg.length() > i ? arg.substring(i + 1) : remainingArgs.pop();
                result.add(definition, value);
                break;
            } else {
                result.set(definition);
            }
        }
    }

    private void parseLongArgs(String arg, Deque<String> remainingArgs) {
        if (arg.contains("=")) {
            String[] split = arg.split("=");
            ParameterDefinition definition = findByLongName(split[0]);
            result.add(definition, split[1]);
        } else {
            ParameterDefinition definition = findByLongName(arg);
            result.add(definition, remainingArgs.pop());
        }
    }

    private ParameterDefinition findByShortName(char name) {
        return definitions.stream()
                .filter(def -> def.getShortName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ParameterNotDefinedException(name));
    }

    private ParameterDefinition findByLongName(String name) {
        return definitions.stream()
                .filter(def -> def.getLongName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ParameterNotDefinedException(name));
    }
}
