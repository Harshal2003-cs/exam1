// Adapter Pattern Example: Heart Model to Beat Model

// Target interface (what the system expects)
interface BeatModel {
    int getBeatsPerMinute();
    void increaseRate();
    void decreaseRate();
}

// Adaptee class (existing model with different interface)
class HeartModel {
    private int heartRate;

    public HeartModel() {
        heartRate = 70;  // default heart rate
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void beatFaster() {
        heartRate += 5;
    }

    public void beatSlower() {
        heartRate -= 5;
    }
}

// Adapter class → converts HeartModel to BeatModel
class HeartToBeatAdapter implements BeatModel {
    private HeartModel heart;

    public HeartToBeatAdapter(HeartModel heart) {
        this.heart = heart;
    }

    @Override
    public int getBeatsPerMinute() {
        return heart.getHeartRate();
    }

    @Override
    public void increaseRate() {
        heart.beatFaster();
    }

    @Override
    public void decreaseRate() {
        heart.beatSlower();
    }
}

// Client to test the adapter
public class AdapterDemo {
    public static void main(String[] args) {
        // Existing Heart Model
        HeartModel heart = new HeartModel();

        // Adapter connects HeartModel to BeatModel interface
        BeatModel beatModel = new HeartToBeatAdapter(heart);

        System.out.println("Initial BPM: " + beatModel.getBeatsPerMinute());

        beatModel.increaseRate();
        System.out.println("After increase: " + beatModel.getBeatsPerMinute());

        beatModel.decreaseRate();
        beatModel.decreaseRate();
        System.out.println("After two decreases: " + beatModel.getBeatsPerMinute());
    }
}
