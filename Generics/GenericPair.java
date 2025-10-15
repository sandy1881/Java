package Generics;

import java.util.Objects;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same object
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class GenericPair {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Integer, String> pair2 = new Pair<>(1, "One");
        Pair<Integer, String> pair3 = new Pair<>(2, "Two");

        System.out.println("pair1: " + pair1);
        System.out.println("pair2: " + pair2);
        System.out.println("pair3: " + pair3);

        System.out.println("pair1 equals pair2? " + pair1.equals(pair2));  // true
        System.out.println("pair1 equals pair3? " + pair1.equals(pair3));  // false

        System.out.println("pair1 hashCode: " + pair1.hashCode());
        System.out.println("pair2 hashCode: " + pair2.hashCode());
    }
}
