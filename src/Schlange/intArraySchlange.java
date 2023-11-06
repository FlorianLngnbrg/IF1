package Schlange;

public class intArraySchlange implements intSchlange
{
    private int[] data;
    private int vorne;
    private int hinten;
    private int n:
    private

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
        vorne = x;
        hinten++;
        hinten= (hinten + 1) % data.length;
        n++;
    }

    public int head() {
        if(isEmpty())
        { throw new RuntimeException("Schlange ist leer"); }
        return vorne;
    }

    public int dequeue() {
        if(isEmpty())
        { throw new RuntimeException("Schlange ist leer"); }
        int erstes = data[vorne];
        vorne = (vorne + 1) % data.length;
        return vorne;
    }

    public String toString() {
        String s = "";

        for(int i=0; i<data.length; i++) {
            s += data[i] + " ";
        }

        return s;
    }

}
