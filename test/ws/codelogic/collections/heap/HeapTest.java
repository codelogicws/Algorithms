package ws.codelogic.collections.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapTest{

    private Heap<Integer> heap;

    @Before
    public void startUp(){
        Integer[] array = new Integer[5];
        heap = new Heap<>(array);
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
        assertEquals(9, pop());
        assertEquals(5, pop());
    }

    @Test
    public void add2ReverseOrder_getHieghestNumber() {
        addToHeap(9,5);
        assertEquals(9, pop());
        assertEquals(5, pop());
    }

    @Test
    public void add3_pullAllLargestFirst() {
        addToHeap(1,3,2);
        assertEquals(3, pop());
        assertEquals(2, pop());
        assertEquals(1, pop());
    }

    @Test
    public void add3_pullAllLargestFirst2() {
        addToHeap(2,3,1);
        assertEquals(3, pop());
        assertEquals(2, pop());
        assertEquals(1, pop());
    }

    @Test
    public void add2_pullAllLargestFirst2() {

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