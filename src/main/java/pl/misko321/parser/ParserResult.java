package pl.misko321.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserResult {

    private Map<String, Integer> flags = new HashMap<>(); // TODO two structures?
    private Map<String, String> results = new HashMap<>();
    private List<String> positionals = new ArrayList<>();

    public boolean isPresent(String parameter) {
        return flags.containsKey(parameter) || results.containsKey(parameter);
    }

    void set(ParameterDefinition parameter) {
        flags.compute(String.valueOf(parameter.getShortName()), (k, n) -> n == null ? 1 : ++n);
        flags.compute(parameter.getLongName(), (k, n) -> n == null ? 1 : ++n);
    }

    void unset(String parameter) {
        results.remove(parameter);
    }

    public void add(ParameterDefinition key, String value) {
        results.put(String.valueOf(key.getShortName()), value);
        results.put(key.getLongName(), value);
    }

    public String getValue(String parameter) {
        return results.get(parameter);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Flags: ");
        flags.forEach((k, v) -> builder.append(k));
        results.forEach((k, v) -> builder.append(k)
                .append("=")
                .append(v));

        return builder.toString();
    }

    public void addPositional(String positional) {
        positionals.add(positional);
    }
}
