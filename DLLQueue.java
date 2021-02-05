/*
 * NAME: Ezhil Thaenraj
 * PID: A15950979
 */

/**
 * DLLQueue
 * @param <T> generic container
 * @author Ezhil Thaenraj
 * @since 02/04/21
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    public DLLQueue() {
        /* Initialize the instance variables
        of this stack/queue. */
        queue = new DoublyLinkedList<>();
    }

    public int size() {
        /*
        Return the number of elements currently stored in
         this stack/queue.
         */
        return queue.size();
    }

    public boolean isEmpty() {
        /*
        Return true if this stack/queue is empty, false otherwise.
        */
        return queue.isEmpty();
    }

    public void enqueue(T data) {
        /*
        Add the given data to this stack/queue.

        @throws IllegalArgumentException
        if data is null
        */
        queue.add(data);

    }

    public T dequeue() {
        /*
        Remove and return the top element from this
        stack/queue. Return null if this stack/queue
        has no elements.
        */
        if(queue.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
    }

    public T peek() {
        /*
        Peek and return the top element from this
        stack/queue. Return null if this stack/queue
        has no elements.
        */
        if(queue.isEmpty()) {
            return null;
        } else {
            return queue.get(0);
        }
    }

}
