package ws.codelogic.collections.stack;

import org.junit.Test;
import org.junit.Before; 

import static org.junit.Assert.*;

public class StackArrayTest {

    private Stack<Integer> stack;
    private static final int STACK_SIZE = 5;


    @Before
    public void before() throws Exception {
        stack = StackFactory.makeStackIntegerArray(STACK_SIZE);
    }

    @Test
    public void push() {
        stack.push(5);
        assertEquals(1, stack.size());
    }

    @Test
    public void popTest() {
        stack.push(0);
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void isEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isNotEmpty(){
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void pushOnePopTheSame() {
        stack.push(2);
        assertEquals(2, pop());
    }

    @Test
    public void push2PopTheSame() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, pop());
        assertEquals(1, pop());
    }

    private int pop(){
        return stack.pop();
    }

    @Test (expected = Stack.StackUnderFlow.class)
    public void popOnAEmptyStack() {
        stack.pop();
    }


    @Test (expected = StackOverflowError.class)
    public void pushOnAFullStack() {
        for(int i=0;i< STACK_SIZE +1;i++)stack.push(0);
    }

    @Test
    public void DoesAZeroCapacityStackGetCreated() {
        Stack newStack = StackFactory.makeStackIntegerArray(0);
    }

    @Test (expected = Stack.NegativeSizeStack.class)
    public void DoesANegativeStackThrowException() {
        Stack newStack = StackFactory.makeStackIntegerArray(-1);
    }

}
