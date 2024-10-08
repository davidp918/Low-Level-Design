package Elevator;

import java.util.List;

interface ElevatorScheduler {
    public Elevator chooseElevator(HallRequest request, List<Elevator> elevators);
}
