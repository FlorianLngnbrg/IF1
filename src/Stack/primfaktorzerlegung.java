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
        intKeller zStapel = pfz(420);
        intKeller nStapel = pfz(450);

        intKeller tempZStapel = new intArrayKeller();
        intKeller tempNStapel = new intArrayKeller();

        while (!zStapel.isEmpty()) {
            tempZStapel.push(zStapel.pop());
        }

        while (!nStapel.isEmpty()) {
            tempNStapel.push(nStapel.pop());
        }

        while (!tempZStapel.isEmpty()) {
            int aktuell = tempZStapel.pop();
            boolean gefunden = false;

            while (!tempNStapel.isEmpty()) {
                nStapel.push(tempNStapel.pop());
            }
            while (!nStapel.isEmpty()) {
                int nCurrent = nStapel.pop();
                if (nCurrent == aktuell) {
                    gefunden = true;
                    break;
                } else {
                    tempNStapel.push(nCurrent);
                }
            }
            if (!gefunden) {
                zStapel.push(aktuell);
            }
        }
        while (!tempNStapel.isEmpty()) {
            nStapel.push(tempNStapel.pop());
        }
    }
    public static intKeller zStapel = pfz(420);
    public static intKeller nStapel = pfz(450);

    public static void main(String[] argv) {
        System.out.println( zStapel );
        System.out.println( nStapel );

        reduziere();

        System.out.println( zStapel );
        System.out.println( nStapel );
    }
}