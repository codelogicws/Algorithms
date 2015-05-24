package test.ws.codelogic.Math; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ws.codelogic.Math.InfixToPostfix;

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

//    @Test
//    public void multiSignTest() {
//        assertEquals("72-5+", converter.convert("7-2+5"));
//    }

}
