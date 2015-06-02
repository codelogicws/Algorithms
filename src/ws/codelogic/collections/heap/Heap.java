package ws.codelogic.collections.heap;

public class Heap<T extends Comparable <T>> {

    private T[] array;
    private int lastElement;

    public Heap(T[] array){
        this.array = array;
        lastElement = 0;
    }

    public void insert(T element) {
        lastElement++;
        array[lastElement] = element;
        moveUp(lastElement);
    }

    private void moveUp(int lastElement) {
        if(lastElement < 2) return;
        int parent = lastElement/2;
        if(array[parent].compareTo(array[lastElement]) < 0){
            swap(parent, lastElement);
        }
    }

    private void swap(int i1, int i2) {
        T temp = array[i2];
        array[i2] = array[i1];
        array[i1] = temp;
    }

    public T pop() {
        swap(lastElement, 1);
        moveDown(1);
        return array[lastElement--];
    }

    private void moveDown(int i) {
//        int child1 = i*2;
//        int child2 = (i*2)+1;

    }
}
