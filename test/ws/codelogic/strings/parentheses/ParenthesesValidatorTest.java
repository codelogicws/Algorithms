package ws.codelogic.strings.parentheses;

import org.junit.Test; 
import org.junit.Before;

import static org.junit.Assert.*;

public class ParenthesesValidatorTest {

    private ParenthesesValidator validator;
    private final static int TEST_CAPACITY = 6;

    @Before
    public void before() {
        validator = new ParenthesesValidator(TEST_CAPACITY);
    }

    @Test
    public void simpleOpenCloseParenthesesYieldsTrue() {
        assertTrue(validator.isValid("()"));
    }

    @Test
    public void toManyOpenBrackets() {
        assertFalse(validator.isValid("(()"));
    }

    @Test
    public void toManyClosingBrackets() {
        assertFalse(validator.isValid("())"));
    }

    @Test (expected = ParenthesesOverFlow.class)
    public void overPushTheCapacity() {
        assertFalse(validator.isValid("((((((("));
    }

    @Test
    public void multiParenthesesTypes() {
        assertTrue(validator.isValid("({})"));
    }

    @Test
    public void multiParenthesesMistake() {
        assertFalse(validator.isValid("({{)"));
    }

    @Test
    public void multiParenthesesShouldNotBeInterchangeable() {
        assertFalse(validator.isValid("(}"));
    }

    @Test
    public void testParenthesesWithOtherText() {
        assertTrue(validator.isValid("(this is stuff<this is more stuff>)"));
    }

    @Test
    public void testParenthesesWithOtherWordsMistake() {
        assertFalse(validator.isValid("(other words<<>)"));
    }

    @Test
    public void missMatchSquareBracket(){
        assertFalse(validator.isValid("[]]"));
    }

    @Test
    public void missMatchOfCurlyBracket() {
        assertFalse(validator.isValid("{{}"));
    }

    @Test (expected = IllegalCapacity.class)
    public void negativeCapacityConstructionThrowsException() {
        new ParenthesesValidator(-1);
    }

}
