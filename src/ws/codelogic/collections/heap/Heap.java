package ws.codelogic.collections.heap;

public class Heap<T extends Comparable <T>> {

    private T[] array;
    private int lastElement;

    public Heap(T[] array){
        this.array = array;
        lastElement = 0;
    }

    public void insert(T element) {
        if(lastElement+2 > array.length)throw new HeapNotLargeEnough();
        lastElement++;
        array[lastElement] = element;
        moveUp(lastElement);
    }

    private void moveUp(int lastElement) {
        if(lastElement < 2) return;
        int parent = lastElement/2;
        if(array[parent].compareTo(array[lastElement]) < 0){
            swap(parent, lastElement);
            moveUp(parent);
        }
    }

    private void swap(int i1, int i2) {
        T temp = array[i2];
        array[i2] = array[i1];
        array[i1] = temp;
    }

    public T pop() {
        swap(lastElement, 1);
        T temp = array[lastElement--];
        array[lastElement+1] = null;
        moveDown(1);
        return temp;
    }

    private void moveDown(int i) {
        int child1 = i*2;
        int child2 = (i*2)+1;
        int largestChild = 0;

        if(child1 <= lastElement){
            if(child2 <= lastElement && isFirstGreaterThenSecond(child2, child1))
                largestChild = child2;
            else
                largestChild = child1;
        }

        if(largestChild != 0 && isFirstGreaterThenSecond(child1, i)){
            swap(largestChild, i);
            moveDown(child1);
        }
    }

    private boolean isFirstGreaterThenSecond(int i1, int i2) {
        return array[i1].compareTo(array[i2]) > 0;
    }

    public static class HeapNotLargeEnough extends RuntimeException {
    }
}
