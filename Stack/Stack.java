package Stack;
import java.util.*;

public class Stack {

    private int arr[];
    private int top;
    private int capacity;
    
    Stack(int size) {
        arr = new int[size];
        capacity=size;
        top = -1;
    }

    boolean isFull() {
        return top == capacity - 1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    int getSize() {
        return top + 1;
    }

    void printStack() {
        for(int i=0; i<=top; i++) {
            System.out.println(arr[i] + ", ");
        }
    }

    void push(int x) {
        if (isFull()) {
            System.out.print("Stack Overflow");

            System.exit(1);
        }

        System.out.println("Pushing " + x);
        arr[++top] = x; 
    }

    int pop() {
        if (isEmpty()) {
            System.out.print("Stack is empty");

            System.exit(1);
        }
        return arr[top--];
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
    
        stack.push(1);
        stack.push(2);
        stack.push(3);
    
        System.out.print("Stack:");
        stack.printStack();
    
        // remove element from stack
        stack.pop();
        System.out.print("\nAfter popping out\n");
        stack.printStack();
    
    }
}
