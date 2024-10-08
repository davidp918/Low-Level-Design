package Elevator;

public class ElevatorDemo {
    public static void main(String[] args) {

        ElevatorScheduler scheduler = new SimpleElevatorScheduler();
        ElevatorSystem system = new ElevatorSystem(2, 10, 10, scheduler);

        system.floorButtonPress(new HallRequest(3, Direction.DOWN));
    }
}
