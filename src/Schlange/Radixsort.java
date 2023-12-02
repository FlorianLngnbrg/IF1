package Schlange;

import java.util.Arrays;

public class Radixsort {

    public static void main(String[] argv) {

        String[] zahlen = {"124", "523", "483", "128", "923", "584"};
        StringSchlange[] buckets = new StringSchlange[10];

        for(int i=0; i<buckets.length; i++){
            buckets[i] = new StringArraySchlange(10);

        }
        int posZahlen=0;

        for(int a=2; a>=0; a--)
        {
            for (int j = 0; j < zahlen.length; j++)
            {
                    char c = zahlen[j].charAt(a);
                    int ascii = (int) c;
                    ascii = (ascii - 48);
                    buckets[ascii].enqueue(zahlen[j]);
            }
            // funktioniert erstmal

            posZahlen = 0;

            for(int b=0; b<buckets.length; b++)
            {
                if(buckets[b].isEmpty()) continue;
                while(!buckets[b].isEmpty())
                {
                    zahlen[posZahlen++] = buckets[b].dequeue();
                }
            }
        }
        System.out.println(Arrays.toString(zahlen));
    }
}
