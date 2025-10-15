package Generics;

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> stackList = new ArrayList<>();

    // Push element to top of stack
    public void push(T element) {
        stackList.add(element);
        System.out.println(element + " pushed to stack");
    }

    // Pop element from top of stack
    public T pop() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T removedElement = stackList.remove(stackList.size() - 1);
        System.out.println(removedElement + " popped from stack");
        return removedElement;
    }

    // Peek top element without removing
    public T peek() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    // Get stack size
    public int size() {
        return stackList.size();
    }
}

public class StackGeneric {
    public static void main(String[] args) {
        // Integer Stack
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Top element: " + intStack.peek());
        intStack.pop();
        System.out.println("Stack size: " + intStack.size());

        System.out.println("------");

        // String Stack
        Stack<String> stringStack = new Stack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");
        System.out.println("Top element: " + stringStack.peek());
        stringStack.pop();
        System.out.println("Stack size: " + stringStack.size());
    }
}
