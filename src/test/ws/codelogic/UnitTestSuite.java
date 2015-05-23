package test.ws.codelogic;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.ws.codelogic.collections.stack.StackArrayTest;
import test.ws.codelogic.collections.stack.StackLinkedListTest;
import test.ws.codelogic.strings.parentheses.ParenthesesValidaterTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StackLinkedListTest.class,
        StackArrayTest.class,
        ParenthesesValidaterTest.class
})
public class UnitTestSuite {

}
