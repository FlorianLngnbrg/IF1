package Verschluesslung;

public class AB4
{
    public static void main(String[] args)
    {
        String zeichenkette = "hoolahooplahoolagirlslikehooligans";

        for (int zeichenlaenge = 3; zeichenlaenge <= zeichenkette.length(); zeichenlaenge++) {
            for (int i = 0; i <= zeichenkette.length() - zeichenlaenge; i++) {
                String aktuelleZeichenfolge = zeichenkette.substring(i, i + zeichenlaenge);

                for (int j = i + 1; j <= zeichenkette.length() - zeichenlaenge; j++) {
                    int index = zeichenkette.indexOf(aktuelleZeichenfolge, j);

                    if (index != -1) {
                        int distance = index - j;

                        if (distance > 0) {
                            System.out.println("Zeichenfolge '" + aktuelleZeichenfolge + "' beim Index " + index +
                                    ". Mit einem Abstand von: " + distance);
                        }

                        j = index;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}

