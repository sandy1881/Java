public class MyArrayList<E> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add element at end
    public void add(E element) {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size++] = element;
    }

    // Add element at specific index
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    // Add all elements from another list
    public void addAll(MyArrayList<E> otherList) {
        for (int i = 0; i < otherList.size; i++) {
            if (size == data.length) {
                Object[] newData = new Object[data.length * 2];
                for (int j = 0; j < data.length; j++) {
                    newData[j] = data[j];
                }
                data = newData;
            }
            data[size++] = otherList.get(i);
        }
    }

    // Get element at index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) data[index];
    }

    // Return index of element
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null && element == null) return i;
            if (data[i] != null && data[i].equals(element)) return i;
        }
        return -1;
    }

    // Check if element exists
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null && element == null) return true;
            if (data[i] != null && data[i].equals(element)) return true;
        }
        return false;
    }

    // Print all elements
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // For testing
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Mango");
        list.print();

        System.out.println("Index of Cherry: " + list.indexOf("Cherry"));
        System.out.println("Contains Banana: " + list.contains("Banana"));

        MyArrayList<String> more = new MyArrayList<>();
        more.add("Grapes");
        more.add("Orange");

        list.addAll(more);
        System.out.println("After addAll:");
        list.print();
    }
}
