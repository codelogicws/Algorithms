package collections.stack;

public interface Stack<T> {
    void push(T newElement);
    T pop();
    int size();
    boolean isEmpty();
    T peek();

    class NegativeSizeStack extends RuntimeException{}

    class StackEmptyHasNoObject extends RuntimeException {}

    class StackUnderFlow extends RuntimeException{}
}
