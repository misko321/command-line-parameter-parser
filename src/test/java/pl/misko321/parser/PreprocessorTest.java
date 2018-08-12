package pl.misko321.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PreprocessorTest {

//    @Test
//    void shouldPreprocessSingleLetterParameters() {
//        ParameterDefinition a = ParameterDefinition.builder().shortName('a').build();
//        ParameterDefinition b = ParameterDefinition.builder().shortName('b').build();
//        ParameterDefinition c = ParameterDefinition.builder().shortName('c').build();
//
//        Preprocessor preprocessor = new Preprocessor(Arrays.asList(a, b, c));
//
//        String parsed = preprocessor.preprocess(new String[] { "-abc" });
//
//        assertThat(parsed).isEqualTo("-a -b -c");
//    }
//
//    @Test
//    void shouldPreprocessSingleLetterParametersWithLastHavingValue() {
//        ParameterDefinition a = ParameterDefinition.builder().shortName('a').build();
//        ParameterDefinition b = ParameterDefinition.builder().shortName('b').build();
//        ParameterDefinition c = ParameterDefinition.builder().shortName('c').takesValue(true).build();
//
//        Preprocessor preprocessor = new Preprocessor(Arrays.asList(a, b, c));
//
//        String parsed = preprocessor.preprocess(new String[] { "-abcval" });
//
//        assertThat(parsed).isEqualTo("-a -b -c val");
//    }
//
//    private List<ParameterDefinition> buildTestDefinitions() {
//        ParameterDefinition a = ParameterDefinition.builder().shortName('a').build();
//        ParameterDefinition b = ParameterDefinition.builder().shortName('b').build();
//        ParameterDefinition c = ParameterDefinition.builder().shortName('c').build();
//
//        return Arrays.asList(a, b, c);
//    }


}