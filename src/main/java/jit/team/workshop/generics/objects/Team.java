package jit.team.workshop.generics.objects;

import java.util.ArrayList;
import java.util.List;

public class Team<T> {

    private final List<T> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public T get(int index) {
        return members.get(index);
    }

    public void add(T newMember) {
        members.add(newMember);
    }
}
