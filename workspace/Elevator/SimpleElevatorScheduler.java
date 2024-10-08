package Elevator;

import java.util.List;

public class SimpleElevatorScheduler implements ElevatorScheduler {

    @Override
    public Elevator chooseElevator(HallRequest request, List<Elevator> elevators) {
        int highScore = 0;
        Elevator result = null;

        for (Elevator elevator: elevators) {
            int curScore = 0;

            // distance for the floor
            curScore += Math.abs(elevator.numFloors - request.floor());

            // if elevator is moving away from the floor
            if ((elevator.state == ElevatorState.MOVING_UP && elevator.numFloors <= request.floor()) ||
                    (elevator.state == ElevatorState.MOVING_DOWN && elevator.numFloors >= request.floor())) {
                curScore += elevator.numFloors;
            }

            // if elevator is full capacity
            if (elevator.passengers == elevator.capacity) {
                curScore += 20;
            }

            if (curScore > highScore) {
                highScore = curScore;
                result = elevator;
            }
        }

        return result;
    }

}
