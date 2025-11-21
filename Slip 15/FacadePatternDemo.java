class DVDPlayer {
    void on() { System.out.println("DVD Player ON"); }
    void play() { System.out.println("Playing Movie"); }
}

class Lights {
    void dim() { System.out.println("Lights dimmed"); }
}

class HomeTheaterFacade {
    private DVDPlayer dvd = new DVDPlayer();
    private Lights lights = new Lights();

    void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        lights.dim();
        dvd.on();
        dvd.play();
        System.out.println("Movie is now playing!");
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();
        theater.watchMovie();
    }
}
