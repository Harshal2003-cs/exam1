interface BeatModelInterface {
    void beat();
}

class HeartModel {
    void pulse() {
        System.out.println("Heart pulse detected!");
    }
}

// Adapter: makes HeartModel fit BeatModelInterface
class HeartModelAdapter implements BeatModelInterface {
    private HeartModel heart;

    HeartModelAdapter(HeartModel heart) {
        this.heart = heart;
    }

    public void beat() {
        heart.pulse();  // adapt pulse() → beat()
    }
}

public class HeartAdapterDemo {
    public static void main(String[] args) {
        HeartModel heart = new HeartModel();
        BeatModelInterface beatModel = new HeartModelAdapter(heart);
        beatModel.beat();
    }
}
