package test.ws.codelogic.math.postfix;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ws.codelogic.math.postfix.InfixToPostfix;
import ws.codelogic.math.postfix.InvalidCharaterInvalidEquation;
import ws.codelogic.math.postfix.MultipleSignsTogetherInvalidEquation;

import static org.junit.Assert.assertEquals;

public class InfixToPostfixTest {

    private InfixToPostfix converter;

    @Before
    public void before() throws Exception {
        converter = new InfixToPostfix();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSimpleOnePlusOne() {
        assertEquals("11+", converter.convert("1+1"));
    }

    @Test
    public void testTwoMinusSeven() {
        assertEquals("27-", converter.convert("2-7"));
    }

    @Test
    public void justANumber() {
        assertEquals("(456)", converter.convert("456"));
    }

    @Test
    public void multiSignTest() {
        assertEquals("72-5+", converter.convert("7-2+5"));
    }

    @Test
    public void threeDigitNumber() {
        assertEquals("4(567)+", converter.convert("4+567"));
    }

    @Test
    public void multiplicationTest() {
        assertEquals("4(567)*", converter.convert("4*567"));
    }

    @Test
    public void divisionTest() {
        assertEquals("4(567)/", converter.convert("4/567"));
    }

    @Test
    public void multiplicationPriority() {
        assertEquals("422*+", converter.convert("4+2*2"));
    }

    @Test
    public void parenthesisTest() {
        assertEquals("42+2*", converter.convert("(4+2)*2"));
    }

    @Test
    public void largeParanthesisTest() {
        assertEquals("42+2*5*64-9*+", converter.convert("(4+2)*2*5+(6-4)*9"));
    }

    @Test (expected = MultipleSignsTogetherInvalidEquation.class)
    public void multiSignBackToBack() {
        converter.convert("4++3");
    }

    @Test (expected = InvalidCharaterInvalidEquation.class)
    public void hasLetters() {
        converter.convert("1+1helllo");
    }

    @Test (expected = InvalidCharaterInvalidEquation.class)
    public void hasSpecialCharater() {
        converter.convert("1*2%3");
    }

}
