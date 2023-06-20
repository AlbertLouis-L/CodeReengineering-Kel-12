
package afterrefactoring;
public class Main {
    public static void main(String[] args) {
        Mercedes mercedes = new Mercedes();
        Ducati ducati = new Ducati();

        mercedes.stock();
        mercedes.model();
        mercedes.color();
        System.out.println(" ");
        ducati.stock();
        ducati.model();
        ducati.color();
        ducati.cylinderCapacity();
    }
}
