package pl.misko321.parser;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import pl.misko321.validator.Validator;

@Builder
@Getter
public class ParameterDefinition {
    private Character shortName;
    @Accessors(fluent = true) private boolean takesValue;
    private String longName;
    private Validator validator;
    private String help;
}
