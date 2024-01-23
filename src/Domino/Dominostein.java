package Domino;

public class Dominostein {

    private int links;
    private int rechts;

    public Dominostein(int l, int r)
    {
        links = l;
        rechts = r;
    }

    public int getLinks()
    {
        return links;
    }

    public int getRechts()
    {
        return rechts;
    }

    public void steinDrehen()
    {
        int lt = links;
        int rt = rechts;

        links = rt;
        rechts = lt;
    }

    @Override
    public String toString()
    {
        String s = "( " + links + " | " + rechts + " )";

        return s;
    }
}
