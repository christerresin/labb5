package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[5];
        for (int d = 0; d < 5; d++) {
            dice[d] = new Die(1);
        }
        BoardGameMaterial yatzi = new BoardGameMaterial();
        assertEquals(true, yatzi.checkIfYatzi(dice));
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dice = new Die[5];
        for (int d = 0; d < 5; d++) {
            dice[d] = new Die();
        }
        dice[4].rollDie();
        BoardGameMaterial yatzi = new BoardGameMaterial();
        assertEquals(false, yatzi.checkIfYatzi(dice));
    }
}
