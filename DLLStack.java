/*
 * NAME: Ezhil Thaenraj
 * PID: 02/4/2021
 */

/**
 * DLLStack
 * @param <T> generic container
 * @author Ezhil Thaenraj
 * @since 02/4/21
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    public DLLStack() {
        /*
        Initialize the instance variables of this stack/queue.
         */
        stack = new DoublyLinkedList<>();

    }

    public int size() {
        /*
        Return the number of elements currently stored in this stack/queue.
        */
        return stack.size();
    }

    public boolean isEmpty() {
        /*
        Return true if this stack/queue is empty, false otherwise.
        */
        return stack.isEmpty();
    }

    public void push(T data) {
        /*
        Add the given data to this stack/queue.

        @throws IllegalArgumentException
        if data is null
        */
        stack.add(data);
    }

    public T pop() {
        /*
        Remove and return the top element from this stack/queue.
        Return null if this stack/queue has no elements.
         */
        if(stack.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public T peek() {
        /*
        Peek and return the top element from this stack/queue.
        Return null if this stack/queue has no elements.
        */
        if(stack.isEmpty()) {
            return null;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

}
