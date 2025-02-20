package Stack;

public class Stack implements intKeller {
    private class Node {
        int item;
        Node next;
    }

    private Node top;
    private int N;

    public Stack() {
        top = null;
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }
    public void push(int item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        N++;
    }

    @Override
    public int peek() {
        return 0;
    }

    public int top() {
        if(isEmpty()) throw new RuntimeException();
        return top.item;
    }
    public int pop() {
        if(isEmpty()) throw new RuntimeException();
        int item = top.item;
        top = top.next;
        N--;
        return item;
    }
    public String toString() {
        String s = "";
        for(Node p = top; p!=null; p = p.next)
            s = p.item + " " + s;
        return s;
    }
}