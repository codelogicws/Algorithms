package collections.stack;

public class StackFactory {

    public static <T> Stack<T> make(int capacity) {
        if(capacity == 0)
            return new ZeroCapacityStack();
        StackLinkedList<T> stack = new StackLinkedList<T>(capacity);
        return stack;
    }

    public static <T> Stack<T> makeStackArray(int capacity) {
        if(capacity == 0)
            return new ZeroCapacityStack();
        Stack<T> stack = new StackArray<T>(capacity);
        return stack;
    }

}
