package ws.codelogic.collections.heap;

import org.junit.Before;
import org.junit.Test;

public class HeapTest{

    private Heap<Integer> heap;

    @Before
    public void startUp(){
        heap = new Heap<>();
    }

    @Test
    public void addItemToHeap() {
        heap.add(5);
    }

    @Test
    public void addOneRemoveTheSame() {
        heap.add(5);
        System.out.println();
    }


}