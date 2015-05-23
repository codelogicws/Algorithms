package collections.stack;

public class StackArray <T> implements Stack<T>{

    private int capacity;

    protected StackArray(int capacity){
        this.capacity = capacity;
    }

    @Override
    public void push(T newElement) {
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T peek() {
        return null;
    }
}
