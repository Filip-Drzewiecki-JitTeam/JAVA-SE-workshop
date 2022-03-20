package jit.team.workshop.inheritance.interfaces;

public interface Vehicle {
    void start();

    void stop();

    boolean isRunning();

    void accelerate(int val);

    int checkSpeed();
}
