package Elevator;

import java.util.ArrayList;
import java.util.List;

// ElevatorSystem class
public class ElevatorSystem {
    private final List<Elevator> elevators;
    private final int numFloors;
    private ElevatorScheduler scheduler;

    public ElevatorSystem(int numElevators, int elevatorCapacity, int numFloors, ElevatorScheduler scheduler) {
        this.numFloors = numFloors;
        this.elevators = new ArrayList<>();
        this.scheduler = scheduler;
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(numFloors, elevatorCapacity);
            elevators.add(elevator);
            new Thread(elevator).start();
        }
    }

    /*
    When a request comes in, we evaluate all states of elevators, and calculate a score for each elevator given the
    request, and

     */
    public void floorButtonPress(HallRequest request) {
        Elevator elevator = this.scheduler.chooseElevator(request, elevators);
        elevator.request(request);
    }
}