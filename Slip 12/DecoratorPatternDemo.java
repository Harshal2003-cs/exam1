interface Car {
    void assemble();
}

// Concrete component
class BasicCar implements Car {
    public void assemble() {
        System.out.print("Basic Car");
    }
}

// Base decorator
abstract class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    public void assemble() {
        this.car.assemble();
    }
}

// Concrete decorator 1
class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

// Concrete decorator 2
class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}

// Test class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        System.out.println("Sports Car:");
        sportsCar.assemble();

        System.out.println("\n\nLuxury Sports Car:");
        Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
        luxurySportsCar.assemble();
    }
}
