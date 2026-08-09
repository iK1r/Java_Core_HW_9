public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<K, V>[] table;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        if (size + 1 > table.length * LOAD_FACTOR) {
            resize();
            index = getIndex(key);
        }

        Node<K, V> node = new Node<>(key, value);

        node.next = table[index];
        table[index] = node;

        size++;
    }

    public void remove(K key) {
        int index = getIndex(key);

        Node<K, V> current = table[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (keysEqual(current.key, key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        table = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);

        Node<K, V> current = table[index];

        while (current != null) {
            if (keysEqual(current.key, key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }

        int index = key.hashCode() % table.length;

        if (index < 0) {
            index += table.length;
        }

        return index;
    }

    private boolean keysEqual(K firstKey, K secondKey) {
        if (firstKey == secondKey) {
            return true;
        }

        if (firstKey == null || secondKey == null) {
            return false;
        }

        return firstKey.equals(secondKey);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;

        table = (Node<K, V>[]) new Node[oldTable.length * 2];

        for (int i = 0; i < oldTable.length; i++) {
            Node<K, V> current = oldTable[i];

            while (current != null) {
                Node<K, V> next = current.next;

                int newIndex = getIndex(current.key);

                current.next = table[newIndex];
                table[newIndex] = current;

                current = next;
            }
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
