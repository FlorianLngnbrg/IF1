package Schlange;

public class Main
{
    public static void main(String[] args)
    {
        int step = 0;
        intArraySchlange schlange = new intArraySchlange();
        step++;
        schlange.enqueue(1);
        step++;
        schlange.enqueue(5);
        step++;
        schlange.enqueue(6);
        step++;
        schlange.enqueue(2);
        step++;

        while(!schlange.isEmpty())
        {
            step++;
            schlange.dequeue();
        }
        System.out.println(step);
    }
}
