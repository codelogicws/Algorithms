package ws.codelogic.collections.stack;

public class StackArray <T> implements Stack<T>{

    private T[] data;
    private int pointer;

    protected StackArray(T[] emptyArray){
        data = emptyArray;
        pointer = 0;
    }

    @Override
    public void push(T newElement) {
        if(pointer >= data.length) throw new StackOverflowError();
        data[pointer++] = newElement;
    }

    @Override
    public T pop() {
        if(pointer == 0) throw new StackUnderFlow();
        return data[--pointer];
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public T peek() {
        return null;
    }
}
