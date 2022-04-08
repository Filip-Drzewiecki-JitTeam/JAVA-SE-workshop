package jit.team.workshop.inheritance.service;

import jit.team.workshop.exercises.Exercise2;
import jit.team.workshop.exercises.Exercise3;
import jit.team.workshop.inheritance.interfaces.Car;
import jit.team.workshop.inheritance.objects.SportCar;

public class ObjectsService {

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

        new Exercise2().doExercise();

        new Exercise3().doExercise();
    }




}
