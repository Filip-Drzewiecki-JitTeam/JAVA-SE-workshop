package solutions.service;

import solutions.objects.Adult;
import solutions.objects.Child;
import solutions.objects.Human;

import java.util.List;

public class HumanService {

    public List<Human> generateListOfHumans() {
        Human human1 = new Adult("Poland", 19, 85528.00);
        Human human2 = new Adult("Poland", 67, 45000.00);
        Human human3 = new Child("Germany", 4, true);
        Human human4 = new Adult("Ukraine", 45, 0.00);
        Human human5 = new Adult("France", 34, 190500.00);
        Human human6 = new Adult("Belarus", 68, 70300.00);

        return List.of(human1, human2, human3, human4, human5, human6);
    }
}
