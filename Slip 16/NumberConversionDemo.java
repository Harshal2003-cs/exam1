import java.util.*;

// --- Subject Interface ---
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// --- Observer Interface ---
interface Observer {
    void update(int number);
}

// --- Concrete Subject ---
class NumberSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int number;

    public void setNumber(int number) {
        this.number = number;
        notifyObservers();
    }

    public int getNumber() {
        return number;
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(number);
        }
    }
}

// --- Concrete Observers ---
class BinaryObserver implements Observer {
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

class OctalObserver implements Observer {
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class HexObserver implements Observer {
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
    }
}

// --- Main Class (Demo) ---
public class NumberConversionDemo {
    public static void main(String[] args) {
        NumberSubject subject = new NumberSubject();

        // Attach observers
        subject.attach(new BinaryObserver());
        subject.attach(new OctalObserver());
        subject.attach(new HexObserver());

        System.out.println("Enter Decimal Number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        subject.setNumber(num);

        System.out.println("\nChange number to 20:");
        subject.setNumber(20);
        
        sc.close();
    }
}
