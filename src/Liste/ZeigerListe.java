package Liste;

public class ZeigerListe implements Liste {

    private class Node {
        int item;       // data
        Node next;      // next
    }

    private Node first;     // head
    private Node last;
    private int N;          // length


    public void getNode(Node p, int y)
    {
        p = first;
        for(int m=0; m<y; m++)
        {
            p=p.next;
        }
    }
    public ZeigerListe() {
        first = last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int getItem(int index) {
        Node get;
        get = first;
        for(int j=0; j<index; j++)
        {
            get = get.next;
        } return get.item;
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
    public void insertAt(int index, int inhalt)
    {
        Node ins;

        getNode(ins, index);

        append(inhalt);
        N++;
    }

    @Override
    public void setItem(int index, int inhalt)
    {
        Node set;
        set = first;

        for(int u=0; u<index; u++)
        {
            set = set.next;
        } set.item = inhalt;
    }

    @Override
    public void delete(int index)
    {
        Node del;
        del = first;
        for(int k=index; k<N-1; k++)
        {
            insertAt(index, );
        }
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
        l.insertAt(3, 5);
        l.setItem(1, 2);

        System.out.println(l);
    }
}