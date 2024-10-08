package Elevator;

public interface ElevatorMovementStrategy {
    public void addRequest(HallRequest request);

    public void addRequest(CarRequest request);

    public void move(Elevator elevator);
}
