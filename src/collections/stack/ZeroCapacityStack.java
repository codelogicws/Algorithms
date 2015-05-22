package collections.stack;

public class ZeroCapacityStack <T> implements SimpleStack<T> {

    @Override
    public void push(T newElement) {
        throw new StackOverflowError();
    }

    @Override
    public T pop() {
        throw new StackUnderFlow();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T peek(){
        throw new StackEmptyHasNoObject();
    }

}
