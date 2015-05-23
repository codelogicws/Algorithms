package test;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import test.collections.stack.TestStackLinkedList;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestStackLinkedList.class
})
public class UnitTestSuite {

}
