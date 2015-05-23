package test.collections.stack;

import collections.stack.*;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.Assert.*;

public class StackLinkedListTest {

    private Stack<Integer> stack;

    @Before
    public void before() throws Exception {
        stack = StackFactory.make(5);
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void pushOnePeek(){
        stack.push(5);
        assertEquals(5, peek());
    }

    @Test
    public void pushElementsGetTheSameElementBack(){
        stack.push(99);
        assertEquals(99, pop());
    }

    @Test
    public void theTwoElementsPoppedAreTheRightElements(){
        stack.push(9);
        stack.push(0);
        stack.push(2);
        assertEquals(2, pop());
        assertEquals(0, pop());
    }

    @Test (expected = Stack.NegativeSizeStack.class)
    public void createAStackWithANegativeSize_YeildsNegativeStackException(){
        Stack<Integer> testStack = StackFactory.make(-1);
    }

    @Test
    public void checkSize(){
        for(int i=0;i<5;i++) stack.push(0);
        assertEquals(5, stack.size());
    }

    @Test (expected = StackOverflowError.class)
    public void pushToManyElements(){
        long overFlowAt = 6;
        for(long i=0;i<overFlowAt;i++) stack.push(0);
    }

    @Test (expected = Stack.StackUnderFlow.class)
    public void popFromAEmptyStack(){
        pop();
    }

    @Test
    public void testIsEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test(expected = Stack.StackEmptyHasNoObject.class)
    public void peekAtEmptyStack(){
        stack.peek();
    }

    @Test(expected = Stack.StackEmptyHasNoObject.class)
    public void peekAtEmptyZeroStack(){
        Stack<Integer> zeroStack = StackFactory.make(0);
        zeroStack.peek();
    }

    @Test
    public void testIsNotEmpty(){
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test (expected = Stack.StackUnderFlow.class)
    public void popFromZeroStack(){
        Stack<Integer> zeroStack = StackFactory.make(0);
        zeroStack.pop();
    }

    @Test (expected = StackOverflowError.class)
    public void pushZeroStack(){
        Stack<Integer> zeroStack = StackFactory.make(0);
        zeroStack.push(999);
    }

    private int pop(){
        return stack.pop();
    }

    private int peek(){
        return stack.peek();
    }


} 
