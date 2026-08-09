public class MyArrayList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    public void add(T value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length + 10];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public void clear() {
        array = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return (T) array[index];
    }
}
