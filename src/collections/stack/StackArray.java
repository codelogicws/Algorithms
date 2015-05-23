package collections.stack;

public class StackArray <T> implements Stack<T>{

    private int capacity;
    private int size;
    T[] stackArray;
    T element;

    protected StackArray(T[] emptyArray){
        this.capacity = emptyArray.length;
        stackArray = emptyArray;
        size = 0;
    }

    @Override
    public void push(T newElement) {
        if(size >= capacity) throw new StackOverflowError();
        element = newElement;
        size++;
    }

    @Override
    public T pop() {
        if(size == 0) throw new StackUnderFlow();
        --size;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peek() {
        return null;
    }
}
