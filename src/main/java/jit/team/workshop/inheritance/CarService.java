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

    /**
     * Exercise 2
     * Create class Human and two classes that will inherit from it - Adult and Child.
     * Human should have at least name and age.
     * Adult should have information about income.
     * Child should have information whether it's happy or not.
     * */

    /**
     * Exercise 3
     * create service that calculates taxes (with logic from exercise 1), but enhance it with objects and inheritance.
     * Method should accept parameter of class Human.
     * Method should calculate taxes only for Adults that have income and who's age is above 18 and below 65.
     * */
}
