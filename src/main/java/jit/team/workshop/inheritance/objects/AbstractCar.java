package jit.team.workshop.inheritance.objects;

import jit.team.workshop.inheritance.interfaces.Car;

public abstract class AbstractCar implements Car {

    protected int currentSpeed;
    protected boolean running;
    protected final int maxSpeed;

    protected AbstractCar(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void start() {
        System.out.println("Car engine start");
        this.running = true;
    }

    @Override
    public void stop() {
        if (currentSpeed != 0) {
            System.out.println("Please stop first to turn the engine off");
        } else {
            System.out.println("Car engine stop");
            this.running = false;
        }
    }

    @Override
    public void drive() {
        System.out.println("Driving");
        currentSpeed = currentSpeed - 10;
    }

    @Override
    public void brake() {
        System.out.println("Braking");
        currentSpeed = currentSpeed - 30;
    }

    @Override
    public void accelerate(int value) {
        System.out.println("Sports car accelerating");
        currentSpeed = currentSpeed + value;
    }

    @Override
    public int checkSpeed() {
        System.out.println("Current speed=" + this.currentSpeed);
        return this.currentSpeed;
    }

    @Override
    public boolean isRunning() {
        System.out.println("Car is running=" + this.running);
        return this.running;
    }
}
