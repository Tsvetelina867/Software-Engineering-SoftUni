package Workshop;

import java.util.function.Consumer;

public class SmartStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<E> {
        private E val;
        private Node<E> prev;

        public Node(E val, Node<E> prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    public T pop() {
        T val = top.val;
        top = top.prev;
        size--;
        return val;
    }

    public T peek() {
        return top.val;
    }

    public int size() {
        return size;
    }

    public void forEach(Consumer<T> consumer) {
        Node<T> last = top;

        while (last != null) {
            consumer.accept(last.val);
            last = last.prev;
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }
}
