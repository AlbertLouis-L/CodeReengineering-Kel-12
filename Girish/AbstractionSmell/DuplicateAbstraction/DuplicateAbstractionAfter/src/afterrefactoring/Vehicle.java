
package afterrefactoring;
abstract class Vehicle {
    abstract void model();
    abstract void color();
    public void stock() {
        System.out.println("available");
    }
}

interface Motorcycle {
    void cylinderCapacity();
}

class Mercedes extends Vehicle {
    public void model() {
        System.out.println("e320");
    }

    public void color() {
        System.out.println("silver");
    }
}

class Ducati extends Vehicle implements Motorcycle {
    public void model() {
        System.out.println("v4S");
    }

    public void color() {
        System.out.println("red");
    }

    public void cylinderCapacity() {
        System.out.println("1103cc");
    }
}
