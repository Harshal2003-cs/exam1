// Thread-safe Singleton using Double-Checked Locking
class Singleton {
    private static volatile Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    public static Singleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Singleton.class) { // Lock the class
                if (instance == null) { // Second check (with lock)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// Testing Singleton with Multithreading
public class SingletonMultithreadingDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + singleton.hashCode());
        };

        // Creating multiple threads
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
