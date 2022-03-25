package tests;

import jit.team.workshop.variables.ConditionsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConditionServiceTest {

    @Test
    public void testRandom() {
        ConditionsService conditions = new ConditionsService();
        int random = conditions.getRandomNumberUsingNextInt(1, 5);
        assertTrue(random >= 1 && random <= 5);
    }
}
