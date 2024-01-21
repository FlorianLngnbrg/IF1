package Stack;

public class Main {

    public static  void main(String [] args)
    {
        long startTime = System.currentTimeMillis();
        intZeigerKeller z = new intZeigerKeller();

        z.push(1);
        z.push(2);
        z.push(6);
        z.push(5);

        while(!z.isEmpty())
        {
            z.pop();
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Laufzeit der Methode: " + duration + " Millisekunden");
    }
}
