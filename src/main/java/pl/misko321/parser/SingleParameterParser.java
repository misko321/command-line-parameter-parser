package pl.misko321.parser;

import java.util.List;

public class SingleParameterParser {
    private List<ParameterDefinition> definitions;

    public SingleParameterParser(List<ParameterDefinition> definitions) {
        this.definitions = definitions;
    }

//    public ParserResult parse(String[] parameters) {
//        Arrays.stream(parameters)
//                .map(this::parseSingleParameter).forEach(this::parse2);
//    }

}

// LESSONS LEARNT:
// When planning to divide a task into subtask, consider whether subtasks don't depend on each other, e.g. in "--name abc" both words must be analyzed together.
// Preprocess/normalize hard to use values

// -abcdef -> -a -b -c=def