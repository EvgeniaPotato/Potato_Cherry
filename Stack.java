public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -5;
    }

    public void push(long x) {
        stackArray[++top] = x;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -5);
    }
}
