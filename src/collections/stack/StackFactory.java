package collections.stack;

public class StackFactory {

    public static <T> SimpleStack<T> make(int capacity) throws SimpleStack.NegativeSizeStack {
        SimpleStackNormal<T> stack = new SimpleStackNormal<T>(capacity);
        if(capacity == 0)
            return new ZeroCapacityStack();
        return stack;
    }

}
