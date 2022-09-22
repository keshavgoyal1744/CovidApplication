package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    } 

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Adds the object to the position in the list
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        else {
            if (index == 0) {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }

    /**
     * Adds the object to the end of the list.
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }

    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(T obj) {
        Node<T> current = head;

        if (isEmpty()) {
            return false;
        }

        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                } 
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }

            current = current.next;
        }
        return false;
    }

    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } 
        else if (index == 0) {
            if (size() == 1) {
                head = null;
                size--;
                return true;
            }
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<T> current = head;
            int currentIndex = 0;

            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(T obj) {
        Node<T> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it
     */
    public int lastIndexOf(T obj) {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }

    /**
     * Returns a string representation of the list
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    /**
     * Returns an array representation of the list
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }

    /**
     * Returns true if both lists are the same
     *
     * @return If two lists have the same contents
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }

    private static class Node<D> {

        private D data;
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }

        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }

        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }

        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }
    
    private class ListIterator<A> implements Iterator<T> {

        private Node<T> next;
        private boolean calledNext;

        /**
         * Creates a new ListIterator
         */
        public ListIterator() {
            next = head;
            calledNext = false;
        }

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next.next() != null;
        }

        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (next.next() == null) {
                throw new NoSuchElementException("No nodes left in list");
            }
            next = next.next();
            calledNext = true;
            T nodeData = next.getData();
            return nodeData;
        }
    }

}
