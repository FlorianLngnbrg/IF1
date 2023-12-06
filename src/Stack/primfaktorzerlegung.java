package Stack;
public class primfaktorzerlegung {
    public static intKeller pfz(int x) {
        intKeller k = new intArrayKeller();

        for (int j = 2; j < x; j++) {
            if (istPrim(j)) {
                int h = x;
                while (h % j == 0) {
                    k.push(j);
                    h = h / j;
                }
            }
        }
        return k;
    }
    public static boolean istPrim(int y) {
        for (int i = 2; i < y; i++) {
            if (y % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void reduziere()
    {
        intKeller tempZStapel = new intArrayKeller();
        intKeller tempNStapel = new intArrayKeller();

        while (!zStapel.isEmpty()) {
            tempZStapel.push(zStapel.pop());
        }

        while (!nStapel.isEmpty()) {
            tempNStapel.push(nStapel.pop());
        }
        //+

        while (!tempZStapel.isEmpty()) {
            int z = tempZStapel.pop();
            boolean gefunden = false;

            intKeller tempTempNStapel = new intArrayKeller();

            while (!tempNStapel.isEmpty()) {
                int nCurrent = tempNStapel.pop();
                if (nCurrent == z) {
                    gefunden = true;
                    break;
                } else {
                    tempTempNStapel.push(nCurrent);
                }
            }

            while (!tempTempNStapel.isEmpty()) {
                tempNStapel.push(tempTempNStapel.pop());
            }

            if (!gefunden) {
                zStapel.push(z);
            }
        }

        while (!tempNStapel.isEmpty()) {
            nStapel.push(tempNStapel.pop());
        }
    }
    public static intKeller zStapel = pfz(420);
    public static intKeller nStapel = pfz(450);

    public static void main(String[] argv) {
        System.out.println("Ursprünglicher Zähler-Stapel: " + zStapel);
        System.out.println("Ursprünglicher Nenner-Stapel: " + nStapel);

        reduziere();

        System.out.println("Gekürzter Zähler-Stapel: " + zStapel);
        System.out.println("Gekürzter Nenner-Stapel: " + nStapel);
    }

}