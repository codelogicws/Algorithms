package ws.codelogic.collections.stack;

public class StackLinkedList<T> implements Stack<T> {

    private Node<T> head;
    private int size;
    private int capacity;

    protected StackLinkedList(int capacity){
        if(capacity < 0)
            throw new NegativeSizeStack();
        this.capacity = capacity;
        size = 0;
    }

    @Override
    public void push(T newElement) {
        size++;
        if(size > capacity) throw new StackOverflowError();
        head = new Node<>(newElement, head);
    }

    @Override
    public T pop() {
        if(isEmpty())throw new StackUnderFlow();
        T value = head.value;
        head = head.next;
        size--;
        return value;
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
    public T peek(){
        if(isEmpty()) throw new StackEmptyHasNoObject();
        return head.value;
    }

    private class Node<T2>{
        public final T2 value;
        public final Node<T2> next;

        public Node(T2 value, Node<T2> next){
            this.value = value;
            this.next = next;
        }
    }

}

