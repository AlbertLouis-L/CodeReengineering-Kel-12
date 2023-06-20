class Sedan extends Car {
    public void parkingSensor() {
        System.out.println("installed");
    }

    public void turbo() {
        System.out.println("not installed");
    }

    public void headLamps() {
        System.out.println("installed");
    }

    public void tes() {
        System.out.println("tes");
    }
}

public class Main {
    public static void main(String[] args) {
        Sedan partSedan = new Sedan();
        partSedan.type();
        partSedan.parkingSensor();
        partSedan.turbo();
        partSedan.headLamps();
    }
}