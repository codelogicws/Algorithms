package test;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.collections.stack.StackArrayTest;
import test.collections.stack.StackLinkedListTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StackLinkedListTest.class,
        StackArrayTest.class
})
public class UnitTestSuite {

}
