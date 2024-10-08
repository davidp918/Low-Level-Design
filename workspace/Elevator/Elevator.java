package Elevator;

import java.util.TreeSet;

public class Elevator implements Runnable {

    public final int numFloors;
    public int curFloor;
    public final int capacity;
    public int passengers;
    public ElevatorState state;

    // TODO: Implement concurrency control
    private final TreeSet<Integer> pickUp;
    private final TreeSet<Integer> pickDown;
    private final TreeSet<Integer> dropOff;

    public Elevator(int numFloors, int capacity) {
        this.numFloors = numFloors;
        this.capacity = capacity;
        this.passengers = 0;
        this.curFloor = 0;
        this.state = ElevatorState.IDLE;

        this.pickUp = new TreeSet<>();
        this.pickDown = new TreeSet<>();
        this.dropOff = new TreeSet<>();
    }

    public void request(HallRequest request) {
        if (request.direction() == Direction.UP) {
            this.pickUp.add(request.floor());
        } else {
            this.pickDown.add(request.floor());
        }
    }

    public void request(CarRequest request) {
        this.dropOff.add(request.floor());
    }

    @Override
    public void run() {
        while (true) {
            this.move();
        }
    }

    // 1. Move up/down one floor if needed
    // 2. Pick/Drop passengers if needed
    // TODO: use state pattern as the logic of control is quite complex, elevator state will also contain door open/close, maintenance etc.
    private void move() {
        if (pickUp.isEmpty() && pickDown.isEmpty() && dropOff.isEmpty()) {
            // let the thread go to sleep here
            this.state = ElevatorState.IDLE;
            return;
        }
    }

}