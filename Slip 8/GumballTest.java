// State Interface
interface State {
    void insertQuarter();
    void turnCrank();
    void dispense();
}

// Receiver / Context
class GumballMachine {
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;
    int count = 3;

    public GumballMachine() {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        state = noQuarterState;
    }

    void setState(State state) { this.state = state; }

    void insertQuarter() { state.insertQuarter(); }
    void turnCrank() { 
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out...");
            count--;
        }
    }

    State getNoQuarterState() { return noQuarterState; }
    State getHasQuarterState() { return hasQuarterState; }
    State getSoldState() { return soldState; }
    int getCount() { return count; }
}

// Concrete States
class NoQuarterState implements State {
    GumballMachine machine;
    NoQuarterState(GumballMachine machine) { this.machine = machine; }

    public void insertQuarter() {
        System.out.println("Quarter inserted");
        machine.setState(machine.getHasQuarterState());
    }

    public void turnCrank() { System.out.println("Insert a quarter first"); }
    public void dispense() { System.out.println("Pay first"); }
}

class HasQuarterState implements State {
    GumballMachine machine;
    HasQuarterState(GumballMachine machine) { this.machine = machine; }

    public void insertQuarter() { System.out.println("Quarter already inserted"); }

    public void turnCrank() {
        System.out.println("Crank turned");
        machine.setState(machine.getSoldState());
    }

    public void dispense() { System.out.println("No gumball dispensed yet"); }
}

class SoldState implements State {
    GumballMachine machine;
    SoldState(GumballMachine machine) { this.machine = machine; }

    public void insertQuarter() { System.out.println("Wait, dispensing gumball"); }

    public void turnCrank() { System.out.println("Turning twice won't get another gumball"); }

    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() > 0) {
            machine.setState(machine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
        }
    }
}

// Client / Test
public class GumballTest {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine();

        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter(); // Out of gumballs
        machine.turnCrank();
    }
}
