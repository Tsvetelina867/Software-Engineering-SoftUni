package Workshop;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    class Node<E> {

        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;
    private Class<T> elementType;

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }

    public T removeFirst() {
        checkEmpty();
        T element = this.head.element;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return element;
    }

    public T removeLast() {
        checkEmpty();
        T element = this.tail.element;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.size--;
        return element;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) Array.newInstance(elementType, this.size);
        AtomicInteger index = new AtomicInteger();
        forEach(e -> array[index.getAndIncrement()] = e);
        return array;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d", index, this.size));
        }
    }
}
