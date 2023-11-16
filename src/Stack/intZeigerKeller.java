package Stack;

public class intZeigerKeller implements intKeller{

    class Node
    {
        int item;
        Node next;
    }
    private Node top;
    private int n=0;

    // liefert true, falls Keller leer, sonst false
    public boolean isEmpty()
    {
        return top.next == null;
    }

    // legt neues Element x auf den Keller
    public void push(int x)
    {
        Node newNode = new Node();
        newNode.item = x;
        newNode.next=top;
        top = newNode;
        n++;
    }

    // liefert das oberste Stackelement
    public int peek()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Der Keller ist leer.");
        }
        return top.item;
    }

    // löscht das oberste Kellerelement und liefert es zurück
    public int pop()
    {
        int x = top.item;
        top = top.next;
        return x;
    }

    public int length()
    {
        return n;
    }

    public String toString()
    {
        String s = " ";
        Node hilf = top;
        while(hilf != null)
        {
            s = s + "" + top.item;
            hilf = top.next;
        }

        return s;
    }
}
