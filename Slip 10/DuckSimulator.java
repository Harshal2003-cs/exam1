// Strategy interface
interface FlyBehavior {
    void fly();
}

// Concrete Strategy 1
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Flying with wings!");
    }
}

// Concrete Strategy 2
class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can’t fly.");
    }
}

// Context class
class Duck {
    FlyBehavior flyBehavior;

    Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void performFly() {
        flyBehavior.fly();
    }

    void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;  // dynamically change behavior
    }
}

// Concrete Duck type
class MallardDuck extends Duck {
    MallardDuck() {
        super(new FlyWithWings());
    }
}

// Test class
public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        System.out.println("Mallard Duck:");
        mallard.performFly();

        System.out.println("\nChanging behavior at runtime...");
        mallard.setFlyBehavior(new FlyNoWay());
        mallard.performFly();
    }
}
