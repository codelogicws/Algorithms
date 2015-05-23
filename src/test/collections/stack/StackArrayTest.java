package test.collections.stack; 

import collections.stack.Stack;
import collections.stack.StackFactory;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class StackArrayTest {

@Before
public void before() throws Exception {
    Stack<Integer> stack = StackFactory.makeStackArray(5);
} 

@After
public void after() throws Exception { 
} 

@Test
public void testPush() throws Exception { 
//TODO: Test goes here... 
} 

@Test
public void testPop() throws Exception { 
//TODO: Test goes here... 
} 

@Test
public void testSize() throws Exception { 
//TODO: Test goes here... 
} 

@Test
public void testIsEmpty() throws Exception { 
//TODO: Test goes here... 
} 

@Test
public void testPeek() throws Exception { 
//TODO: Test goes here... 
} 


} 
