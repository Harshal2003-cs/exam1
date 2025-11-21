import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

// Adapter Class: Converts Enumeration to Iterator
class EnumerationIteratorAdapter<T> implements Iterator<T> {
    private Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove() not supported in Enumeration");
    }
}

// Client Code
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        Enumeration<String> enumeration = vector.elements();

        // Using Adapter: Convert Enumeration to Iterator
        Iterator<String> iterator = new EnumerationIteratorAdapter<>(enumeration);

        System.out.println("Iterating using Adapter (Enumeration → Iterator):");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
