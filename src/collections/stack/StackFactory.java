package collections.stack;

public class StackFactory {

    public static <T> Stack<T> make(int capacity) {
        if(capacity == 0)
            return new ZeroCapacityStack();
        StackLinkedList<T> stack = new StackLinkedList<T>(capacity);
        return stack;
    }

    public static Stack<Integer> makeStackIntegerArray(int capacity){
        return makeStackArray(new Integer[capacity]);
    }

    public static <T> Stack<T> makeStackArray(T[] emptyArray) {
        if(emptyArray.length == 0)
            return new ZeroCapacityStack();
        Stack<T> stack = new StackArray<T>(emptyArray);
        return stack;
    }

}
