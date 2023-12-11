package Liste;

public class ZeigerListe implements Liste {

    private class Node {
        int item;       // data
        Node next;      // next
    }

    private Node first;     // head
    private Node last;
    private int N;          // length

    public ZeigerListe() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void append(int inhalt) {
        Node newNode = new Node();
        newNode.item = inhalt;

        if (isEmpty()) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        N++;
    }

    @Override
    public int getItem(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    @Override
    public void insertAt(int index, int inhalt) {
        if (index < 0 || index > N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == N) {
            append(inhalt);
            return;
        }

        Node newNode = new Node();
        newNode.item = inhalt;

        if (index == 0) {
            newNode.next = first;
            first = newNode;

            /*
            last.next = newNode;
            last = newNode;
             */
        } else {
            Node prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }

        N++;
    }

    @Override
    public void setItem(int index, int inhalt) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node u = first;
        for (int i = 0; i < index; i++) {
            u = u.next;
        }

        u.item = inhalt;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            if (index == N - 1) {
                last = prev;
            }
        }
        N--;
    }

    @Override
    public int getLength() {
        return N;
    }

    public String toString() {
        String s = "N = " + N + ": ";
        for(Node p = first; p != null; p = p.next){
            s += p.item + " ";
        }
        return s;
    }

    public static void main(String[] argv) {
        Liste l = new ZeigerListe();

        l.append(4);
        l.append(7);
        l.append(13);
        l.delete(2);

        System.out.println(l);
    }
}