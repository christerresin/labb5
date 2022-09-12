package edu.lernia.labb5;

public class BoardGameMaterial {
    /* Will be used to store all boardgamematerials in one class */

    public static boolean checkIfYatzi(Die[] dice) {
        boolean isYatzi = true;
        for (int j = 1; j < 5; j++) {
            if (dice[j].value != dice[j - 1].value) {
                isYatzi = false;
            }

        }
        return isYatzi;

    }
}
