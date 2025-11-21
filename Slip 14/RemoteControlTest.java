// Command interface
interface Command {
    void execute();
}

// Receiver 1
class Light {
    void on() {
        System.out.println("Light is ON");
    }

    void off() {
        System.out.println("Light is OFF");
    }
}

// Receiver 2
class GarageDoor {
    void up() {
        System.out.println("Garage Door is OPEN");
    }

    void down() {
        System.out.println("Garage Door is CLOSED");
    }
}

// Receiver 3
class Stereo {
    void on() {
        System.out.println("Stereo is ON");
    }

    void off() {
        System.out.println("Stereo is OFF");
    }

    void setCD() {
        System.out.println("Stereo is set for CD input");
    }

    void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }
}

// Concrete Commands
class LightOnCommand implements Command {
    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

class GarageDoorUpCommand implements Command {
    GarageDoor door;

    GarageDoorUpCommand(GarageDoor door) {
        this.door = door;
    }

    public void execute() {
        door.up();
    }
}

class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(10);
    }
}

// Invoker
class SimpleRemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}

// Client (Test class)
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        // Receivers
        Light livingRoomLight = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        // Commands
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);

        System.out.println("---- Testing Remote Control ----");
        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(lightOff);
        remote.buttonWasPressed();

        remote.setCommand(garageDoorUp);
        remote.buttonWasPressed();

        remote.setCommand(stereoOn);
        remote.buttonWasPressed();
    }
}
