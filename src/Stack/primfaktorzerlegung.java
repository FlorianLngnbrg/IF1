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

    public static void main(String[] args)
    {
        System.out.println(pfz(84));
    }
}