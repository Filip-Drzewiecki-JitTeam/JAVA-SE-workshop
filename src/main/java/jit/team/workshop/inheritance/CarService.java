package jit.team.workshop.inheritance;

import jit.team.workshop.inheritance.interfaces.Car;
import jit.team.workshop.inheritance.objects.SportCar;

public class CarService {

    public void drivingDemo() {
        Car car = new SportCar(250);
        car.start();
        car.isRunning();
        car.checkSpeed();
        car.accelerate(50);
        car.checkSpeed();
        car.drive();
        car.checkSpeed();
        car.drive();
        car.checkSpeed();
        car.brake();
        car.checkSpeed();
        car.stop();
        car.isRunning();
    }
}
