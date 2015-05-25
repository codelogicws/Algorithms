package test.ws.codelogic;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.ws.codelogic.math.postfix.InfixToPostfixTest;
import test.ws.codelogic.collections.stack.StackArrayTest;
import test.ws.codelogic.collections.stack.StackLinkedListTest;
import test.ws.codelogic.math.postfix.PostfixSolverTest;
import test.ws.codelogic.strings.parentheses.ParenthesesValidaterTest;
import test.ws.codelogic.strings.parentheses.PredictLeftParenthesesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StackLinkedListTest.class,
        StackArrayTest.class,
        ParenthesesValidaterTest.class,
        PredictLeftParenthesesTest.class,
        InfixToPostfixTest.class,
        PostfixSolverTest.class
})
public class UnitTestSuite {

}
