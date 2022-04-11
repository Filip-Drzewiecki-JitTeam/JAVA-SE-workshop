package tests;

import jit.team.workshop.generators.RandomUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConditionServiceTest {

    @Test
    public void testRandom() {
        int random = RandomUtils.generateRandomInt(1, 5);
        assertTrue(random >= 1 && random <= 5);
    }
}
