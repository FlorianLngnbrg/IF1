package Schlange;

public class intArraySchlange implements intSchlange
{
    private int[] data;
    private int vorne;
    private int hinten;
    private int n;

    public intArraySchlange()
    {
        data = new int[100];
        vorne = data[0];
        hinten = data[0];
        n = 0;
    }

    public boolean isEmpty() {

        return hinten==vorne;
    }

    public void enqueue(int x)
    {
        if(n== data.length)
        {throw new RuntimeException("Schlaneg ist voll");}

        data[hinten] = x;
        hinten= (hinten + 1) % data.length;
        n++;
    }

    public int head() {
        if(isEmpty())
        { throw new RuntimeException("Schlange ist leer"); }
        return data[vorne];
    }

    public int dequeue() {
        if(isEmpty())
        { throw new RuntimeException("Schlange ist leer"); }
        int erstes = data[vorne];
        vorne = (vorne + 1) % data.length;
        n--;
        return erstes;
    }

    public String toString() {
        String s = "";

        for(int i=0; i<n; i++) {
            s += data[ (vorne+i) % data.length] + " ";
        }

        return s;
    }

    public int length()
    {
        return n;
    }

}
