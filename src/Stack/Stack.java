package Stack;

public class Stack<E> implements intKeller<E> {
    private class Node {
        E item;
        Node next;
    }

    private Node top;
    private int N;

    public Stack() {
        top = null;
        N = 0;
    }
    public boolean isEmpty() { return N == 0; }

    @Override

    public void push(int x) {

    }

    @Override
    public int peek() {
        return 0;
    }

    public int size() { return N; }
    public void push(E item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = top;
        top = newNode;
        N++;
    }
    public E top() {
        if(isEmpty()) throw new RuntimeException();
        return top.item;
    }
    public int pop() {
        if(isEmpty()) throw new RuntimeException();
        E item = top.item;
        top = top.next;
        N--;
        return (int) item;
    }
    public String toString() {
        String s = "";
        for(Node p = top; p!=null; p = p.next)
            s = p.item + " " + s;
        return s;
    }
}