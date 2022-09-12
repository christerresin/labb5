package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[5];
        for (int d = 0; d < 5; d++) {
            dice[d] = new Die();
        }
        assertEquals(true, YatziMain.checkIfYatzi(dice));
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dice = new Die[5];
        for (int d = 0; d < 5; d++) {
            dice[d] = new Die();
        }
        dice[4].value = 1;
        assertEquals(false, YatziMain.checkIfYatzi(dice));
    }
}
