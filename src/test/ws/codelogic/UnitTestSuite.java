package test.ws.codelogic;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.ws.codelogic.Math.InfixToPostfixTest;
import test.ws.codelogic.collections.stack.StackArrayTest;
import test.ws.codelogic.collections.stack.StackLinkedListTest;
import test.ws.codelogic.strings.parentheses.ParenthesesValidaterTest;
import test.ws.codelogic.strings.parentheses.PredictLeftParenthesesTest;
import ws.codelogic.Math.InfixToPostfix;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StackLinkedListTest.class,
        StackArrayTest.class,
        ParenthesesValidaterTest.class,
        PredictLeftParenthesesTest.class,
        InfixToPostfixTest.class
})
public class UnitTestSuite {

}
