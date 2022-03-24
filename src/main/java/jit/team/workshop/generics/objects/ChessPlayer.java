package jit.team.workshop.generics.objects;

public class ChessPlayer {

    private String name;

    public ChessPlayer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChessPlayer{" +
                "name='" + name + '\'' +
                '}';
    }
}
