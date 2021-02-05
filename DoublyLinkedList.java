/*
 * NAME: Ezhil Thaenraj
 * PID: A15950979
 */

import java.util.AbstractList;

/**
 * DLL class
 * @author Ezhil Thaenraj
 * @since 02/4/2021
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            // TODO: complete constructor
            data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            // TODO: complete implementation
            data = element;
            next = nextNode;
            prev = prevNode;

        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            // TODO: complete implementation
            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            // TODO: complete implementation
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            // TODO: complete implementation
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            // TODO: complete implementation
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            // TODO: complete implementation
            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            // TODO: complete implementation
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // TODO: complete implementation
            prev.next = next;
            next.prev = prev;

        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // TODO: complete default constructor
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if (element == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(element);
        if (nelems == 0) {
            newNode.prev = head;
            head.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            this.nelems++;
            return true;
        } else {
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev = newNode;
            this.nelems++;
            return true;
        }
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param index to be added to
     * @param element value to be added at the index
     * @throws IndexOutOfBoundsException,NullPointerException
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if(element == null) {
            throw new NullPointerException();
        } else if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(element);
        Node prevNode;
        Node nextNode;

        if(index == 0) {
            prevNode = head;
            nextNode = head.next;
        } else if (index == this.size() - 1) {
            prevNode = tail.prev;
            nextNode = tail;
        } else {
            prevNode = getNth(index - 1);
            nextNode = getNth(index + 1);
        }

        newNode.next = nextNode;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        this.nelems++;

    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        // TODO: implement clear
        this.head.next = tail;
        this.tail.prev = head;
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element that we are looking for
     * @return True or False based on element being in DLL
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
        // TODO: Fill in implementation
        Node newNode = head.next;
        for(int x = 0; x < this.size() - 1; x++) {
            if(newNode.getElement().equals(data)) {
                return true;
            } else {
                newNode = newNode.next;
            }
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index of the item wanted
     * @throws IndexOutOfBoundsException
     * @return the item at index
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation to get the node at index
        if (index < 0 || index > this.size()-1) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = getNth(index);
        return newNode.getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @param  index of the wanted item
     * @return Node at that index
     */
    private Node getNth(int index) {
        // TODO: implement
        Node newNode = head.next;
        if (index == 0){
            return head.next;
        }
        for(int x = 0; x < this.nelems; x++) {
            if (x == index-1){
                newNode = newNode.next;
                break;
            }
            else{
                newNode = newNode.next;
            }
        }
        return newNode;
    }

    /**
     * Determine if the list empty
     *
     * @return True or False based on if DLL is empty
     */
    @Override
    public boolean isEmpty() {
        // TODO: implement isEmpty
        return nelems == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index of item to be removed
     * @throws IndexOutOfBoundsException
     * @return the value that is removed
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation
        if (index < 0 || index > this.size()-1) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = this.getNth(index);
        newNode.remove();
        this.nelems--;
        return newNode.getElement();
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index that is to be changed
     * @param element to replace the index
     * @throws IndexOutOfBoundsException,NullPointerException
     * @return the element that is set
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        if (element == null) {
            throw new NullPointerException();
        }
        else if (index < 0 || index > this.size()-1) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = this.getNth(index);
        T returnElem = newNode.getElement();
        newNode.setElement(element);
        return returnElem;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        // TODO: complete implementation
        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * @return the toString()
     */
    @Override
    public String toString() {
        String returnStr = "[(head) -> ";
        Node newNode = this.head.next;
        for (int x = 0; x < nelems; x++){
            returnStr += newNode.getElement().toString() + " -> ";
            newNode = newNode.next;
        }
        returnStr += "(tail)]";
        return returnStr;

    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Inserts another linked list of the same type into this one
     *
     * TODO: javadoc comments
     */
    public void splice(int index, DoublyLinkedList<T> otherList) throws IndexOutOfBoundsException {
        // TODO: Determine if index is valid

        // TODO: Splicing implementation. HINT: remember DoublyLinkedList's  have dummy nodes
    }

    /**
     * Determine the starting indices that match the subSequence
     *
     * TODO: javadoc comments
     */
    public int[] match(DoublyLinkedList<T> subsequence) {

        // A list to hold all the starting indices found
        DoublyLinkedList<Integer> indices = new DoublyLinkedList<>();

        // TODO: Add implementation to find the starting indices

        // Array Conversion
        int[] startingIndices = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            startingIndices[i] = indices.get(i);
        }
        return startingIndices;
    }

}