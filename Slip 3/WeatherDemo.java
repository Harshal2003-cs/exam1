import java.util.Observable;
import java.util.Observer;

class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }
    
    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

class CurrentDisplay implements Observer {
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherStation) {
            WeatherStation ws = (WeatherStation) obs;
            System.out.printf("Current: %.1f°C, %.1f%%, %.1f hPa\n", 
                ws.getTemperature(), ws.getHumidity(), ws.getPressure());
        }
    }
}

public class WeatherDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        CurrentDisplay display = new CurrentDisplay();
        
        station.addObserver(display);
        
        station.setMeasurements(25.5f, 65.0f, 1013.2f);
        station.setMeasurements(26.8f, 70.0f, 1012.5f);
    }
}