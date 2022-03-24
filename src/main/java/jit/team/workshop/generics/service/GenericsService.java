package jit.team.workshop.generics.service;

import jit.team.workshop.generics.objects.ChessPlayer;
import jit.team.workshop.generics.objects.Horse;
import jit.team.workshop.generics.objects.Plant;
import jit.team.workshop.generics.objects.Team;

import java.util.List;

public class GenericsService {

    public void practiceGenerics() {
        //useGenerics();
        //compareGenerics();
        //useGenericObjects();
    }

    public void useGenerics() {
        Horse rafael = new Horse("Rafael");
        Horse guillermo = new Horse("Guillermo");

        List<Horse> list = combineObjectsIntoList(rafael, guillermo);
        System.out.println(list);

    }

    public <T> List<T> combineObjectsIntoList(T element1, T element2) {
        return List.of(element1, element2);
    }

    private void compareGenerics() {
        Horse rafael = new Horse("Rafael", true);
        Horse guillermo = new Horse("Guillermo", false);
        System.out.println("Faster horse is=" + compare(rafael, guillermo));

        Plant rose = new Plant("Rose", 10);
        Plant oak = new Plant("Oak", 1000);
        System.out.println("Bigger plant is=" + compare(rose, oak));
    }

    private <T extends Comparable<T>> T compare(T element1, T element2) {
        if (element1.compareTo(element2) > 0) {
            return element1;
        }
        if (element1.compareTo(element2) < 0) {
            return element2;
        }
        return null;
    }

    private void useGenericObjects() {
        Team<ChessPlayer> team = new Team<>();
        team.add(new ChessPlayer("Jan Krzysztof Duda"));
        team.add(new ChessPlayer("Magnus Carlsen"));
        System.out.println("First team member is=" + team.get(0));
        System.out.println("All team members=" + team);
    }

    /**
     * Exercise 5
     * Create your own interface and method that uses generics implementing that interface.
     * */
}
