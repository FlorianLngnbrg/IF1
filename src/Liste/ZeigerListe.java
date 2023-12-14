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
    public int getItem(int index) {
	return 0;
    }

    @Override
    public void append(int inhalt) {
        Node newNode = new Node();
        newNode.item = inhalt;

 	if( isEmpty() ) {
            last = first = newNode;
	} else {
	    last.next = newNode;
 	    last = newNode;
	}

	N++;
    }

    @Override
    public void insertAt(int index, int inhalt) {
        
    }

    @Override
    public void setItem(int index, int inhalt) {

    }

    @Override
    public void delete(int index) {
    
    }

    @Override
    public int getLength() {
	return 0;
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

        System.out.println(l);
    }
}