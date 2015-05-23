package test.ws.codelogic.strings.parentheses; 

import org.junit.Test; 
import org.junit.Before;
import ws.codelogic.strings.parentheses.IllegalCapacity;
import ws.codelogic.strings.parentheses.ParenthesesOverFlow;
import ws.codelogic.strings.parentheses.ParenthesesValidater;

import static org.junit.Assert.*;

public class ParenthesesValidaterTest {

    private ParenthesesValidater parenValidator;
    private final static int TESTCAPACITY = 6;

    @Before
    public void before() throws Exception {
        parenValidator = new ParenthesesValidater(TESTCAPACITY);
    }

    @Test
    public void simpleOpenCloseParenthesesYieldsTrue() {
        assertTrue(parenValidator.isValid("()"));
    }

    @Test
    public void toManyOpenBrackets() {
        assertFalse(parenValidator.isValid("(()"));
    }

    @Test
    public void toManyClosingBrackets() {
        assertFalse(parenValidator.isValid("())"));
    }

    @Test (expected = ParenthesesOverFlow.class)
    public void overPushTheCapacity() {
        assertFalse(parenValidator.isValid("((((((("));
    }

    @Test (expected = IllegalCapacity.class)
    public void negativeCapacityConstructionThrowsException() {
        ParenthesesValidater pv = new ParenthesesValidater(-1);
    }

}
