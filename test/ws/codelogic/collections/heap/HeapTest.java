package ws.codelogic.collections.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapTest{

    private Heap<Integer> heap;
    private final int TESTSIZE = 10;

    @Before
    public void startUp(){
        Integer[] array = new Integer[TESTSIZE];
        heap = new Heap<>(array);
    }

    @Test (expected = Heap.HeapNotLargeEnough.class)
    public void overPush() {
        for(int i=0;i<TESTSIZE;i++){
            heap.insert(0);
        }
    }

    @Test
    public void addItemToHeap() {
        heap.insert(5);
    }

    @Test
    public void addOneRemoveTheSame() {
        heap.insert(5);
        assertEquals(new Integer(5), heap.pop());
    }

    @Test
    public void add2_getHeighestNumberFirst() {
        addToHeap(5,9);
        popAssertEquals(9,5);
    }

    @Test
    public void add2ReverseOrder_getHieghestNumber() {
        addToHeap(9,5);
        popAssertEquals(9,5);
    }

    @Test
    public void add3_pullAllLargestFirst() {
        addToHeap(1,3,2);
        popAssertEquals(3,2,1);
    }

    @Test
    public void add3_pullAllLargestFirst2() {
        addToHeap(2,3,1);
        popAssertEquals(3,2,1);
    }

    @Test
    public void testOrderingWithLargeInput() {
        addToHeap(9,7,1,2,3,6,4,5,8);
        popAssertEquals(9,8,7,6,5,4,3,2,1);
    }

    public void popAssertEquals(int... asserts){
        for(int i : asserts){
            assertEquals(i, pop());
        }
    }

    private int pop(){
        return heap.pop();
    }

    private void addToHeap(int... toAdd) {
        for(int i : toAdd){
            heap.insert(i);
        }
    }

}