package ws.codelogic;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import ws.codelogic.collections.stack.StackArrayTest;
import ws.codelogic.collections.stack.StackLinkedListTest;
import ws.codelogic.math.postfix.InfixToPostfixTest;
import ws.codelogic.strings.parentheses.ParenthesesValidaterTest;
import ws.codelogic.strings.parentheses.PredictLeftParenthesesTest;
import ws.codelogic.collections.UnionFindTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StackLinkedListTest.class,
        StackArrayTest.class,
        ParenthesesValidaterTest.class,
        PredictLeftParenthesesTest.class,
        InfixToPostfixTest.class,
        UnionFindTest.class
})
public class UnitTestSuite {

}
