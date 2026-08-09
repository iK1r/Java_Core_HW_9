public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value);

        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (first == null) {
            return null;
        }

        return first.value;
    }

    public T poll() {
        if (first == null) {
            return null;
        }

        T value = first.value;
        first = first.next;
        size--;

        if (first == null) {
            last = null;
        }

        return value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
