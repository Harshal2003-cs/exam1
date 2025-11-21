// Command Interface
interface Command {
    void execute();
    void undo();
}

// Receiver
class CeilingFan {
    void on() { System.out.println("Ceiling fan is ON"); }
    void off() { System.out.println("Ceiling fan is OFF"); }
}

// Concrete Command - Turn fan ON
class FanOnCommand implements Command {
    CeilingFan fan;
    FanOnCommand(CeilingFan fan) { this.fan = fan; }

    public void execute() { fan.on(); }
    public void undo() { fan.off(); }
}

// Concrete Command - Turn fan OFF
class FanOffCommand implements Command {
    CeilingFan fan;
    FanOffCommand(CeilingFan fan) { this.fan = fan; }

    public void execute() { fan.off(); }
    public void undo() { fan.on(); }
}

// Invoker - Remote Control
class RemoteControl {
    private Command command;
    private Command undoCommand;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
        undoCommand = command;
    }

    void pressUndo() {
        if (undoCommand != null) {
            System.out.println("Undoing last action...");
            undoCommand.undo();
        }
    }
}

// Client - Test Ceiling Fan Commands
public class CeilingFanTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        CeilingFan fan = new CeilingFan();

        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        // Turn fan ON
        remote.setCommand(fanOn);
        remote.pressButton();

        // Turn fan OFF
        remote.setCommand(fanOff);
        remote.pressButton();

        // Undo last command (fan OFF → ON)
        remote.pressUndo();
    }
}
