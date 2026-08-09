public class MyLinkedList<T> {
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
            node.previous = last;
            last = node;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node<T> current = getNode(index);

        if (current.previous == null) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        size--;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return getNode(index).value;
    }

    private Node<T> getNode(int index) {
        Node<T> current;

        if (index < size / 2) {
            current = first;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = last;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }

        return current;
    }

    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
