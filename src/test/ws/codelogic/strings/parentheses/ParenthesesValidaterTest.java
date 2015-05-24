package test.ws.codelogic.strings.parentheses; 

import org.junit.Test; 
import org.junit.Before;
import ws.codelogic.strings.parentheses.IllegalCapacity;
import ws.codelogic.strings.parentheses.ParenthesesOverFlow;
import ws.codelogic.strings.parentheses.ParenthesesValidater;

import static org.junit.Assert.*;

public class ParenthesesValidaterTest {

    private ParenthesesValidater validator;
    private final static int TESTCAPACITY = 6;

    @Before
    public void before() throws Exception {
        validator = new ParenthesesValidater(TESTCAPACITY);
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
    public void multiParenthesesInterchangabilityMistake() {
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
    public void failerOfSquareBracket(){
        assertFalse(validator.isValid("[]]"));
    }

    @Test
    public void failerOfCurlyBracket() {
        assertFalse(validator.isValid("{{}"));
    }

    @Test (expected = IllegalCapacity.class)
    public void negativeCapacityConstructionThrowsException() {
        ParenthesesValidater pv = new ParenthesesValidater(-1);
    }

}
