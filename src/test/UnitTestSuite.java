package test;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.collections.stack.TestSimpleStack;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSimpleStack.class
})
public class UnitTestSuite {

}
