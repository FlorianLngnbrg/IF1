package Stack;

public class Verschiebebahnhof
{
    private intKeller gleisA;
    private intKeller gleisB;
    private intKeller gleisC;

    public Verschiebebahnhof()
    {
        gleisA = new intZeigerKeller();
        gleisB = new intZeigerKeller();
        gleisC = new intZeigerKeller();

        gleisA.push(13);
        gleisA.push(4);
        gleisA.push(55);
        gleisA.push(10);
        gleisA.push(11);
        gleisA.push(23);
    }

    public void verschieben(intKeller von, intKeller nach){
        nach.push(von.pop());
    }

    public void sortieren() {
        verschieben(gleisA, gleisC);

        while(!gleisA.isEmpty() ) {

            while( !gleisC.isEmpty() && gleisA.peek() < gleisC.peek() ) {
                verschieben(gleisC, gleisB);
            }

            verschieben( gleisA, gleisC );

            while( !gleisB.isEmpty() ) {
                verschieben(gleisB, gleisC);
            }
        }
    }

    public String toString() {

        String s = "";
       s += "A" + gleisA + "\n";
       s += "B" + gleisB + "\n";
       s += "C" + gleisC + "\n";

       return s;

    }
}