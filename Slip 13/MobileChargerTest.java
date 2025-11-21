// Volt class – represents voltage
class Volt {
    private int volts;

    public Volt(int v) {
        this.volts = v;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

// Socket class – produces constant 120 volts
class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

// Target interface – defines adapter methods
interface SocketAdapter {
    Volt get3Volt();
    Volt get12Volt();
    Volt get120Volt();
}

// Adapter class – converts 120V to 12V or 3V (using composition)
class SocketAdapterImpl implements SocketAdapter {
    private Socket socket = new Socket(); // using composition

    private Volt convertVolt(Volt v, int divider) {
        return new Volt(v.getVolts() / divider);
    }

    @Override
    public Volt get3Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 40); // 120/40 = 3V
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10); // 120/10 = 12V
    }

    @Override
    public Volt get120Volt() {
        return socket.getVolt(); // no conversion needed
    }
}

// Test class
public class MobileChargerTest {
    public static void main(String[] args) {
        SocketAdapter adapter = new SocketAdapterImpl();

        Volt v3 = adapter.get3Volt();
        Volt v12 = adapter.get12Volt();
        Volt v120 = adapter.get120Volt();

        System.out.println("Mobile needs: " + v3.getVolts() + "V");
        System.out.println("Tablet needs: " + v12.getVolts() + "V");
        System.out.println("TV needs: " + v120.getVolts() + "V");
    }
}
