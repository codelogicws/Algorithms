package ws.codelogic.strings.parentheses;

import org.junit.Test; 
import org.junit.Before; 

import static org.junit.Assert.*;

public class PredictLeftParenthesesTest {

    private PredictLeftParentheses predict;

    @Before
    public void before() {
        predict = new PredictLeftParentheses();
    }

    @Test
    public void addParenthesis() {
        assertEquals("()", predict.insertLeft(")"));
    }

    @Test
    public void addParenthesisWithASimpleProblem() {
        assertEquals("(2+1)", predict.insertLeft("2+1)"));
    }

    @Test
    public void addMultiParentheses() {
        assertEquals("((2+1)*(2+1))", predict.insertLeft("2+1)*2+1))"));
    }

    @Test
    public void largeInputTest() {
        assertEquals("((3+4)*(5+8)/(8-9)*(345-90))", predict.insertLeft("3+4)*5+8)/8-9)*345-90))"));
    }
}
