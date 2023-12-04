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
            for (String s : zahlen) {
                char c = s.charAt(a);
                int ascii = (int) c;
                ascii = (ascii - 48);
                buckets[ascii].enqueue(s);
            }
            // funktioniert erstmal

            posZahlen = 0;

            for (StringSchlange bucket : buckets) {
                if (bucket.isEmpty()) continue;
                while (!bucket.isEmpty()) {
                    zahlen[posZahlen++] = bucket.dequeue();
                }
            }
        }
        System.out.println(Arrays.toString(zahlen));
    }
}
