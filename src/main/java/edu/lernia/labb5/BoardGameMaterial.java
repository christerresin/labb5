package edu.lernia.labb5;

import java.util.Scanner;

public class BoardGameMaterial {
    /* Will be used to store all boardgamematerials in one class */
    private Die[] dice;
    private boolean isPlaying;
    private int gameTurn;

    public void startNewGame() {
        isPlaying = true;
        gameTurn = 1;

        dice = new Die[5];
        for (int d = 0; d < dice.length; d++) {
            dice[d] = new Die();
        }

        while (isPlaying == true) {
            gameTurn = 1;
            System.out.println("Welcome to Yatzi!");
            try (Scanner sc = new Scanner(System.in)) {
                while (gameTurn < 4) {
                    System.out.println("Starting turn " + (gameTurn) + " of 3, rolling dice.");
                    for (int i = 0; i < dice.length; i++) {
                        dice[i].rollDie();
                        // dice[i].value = 5; //Test if yatzi work
                        System.out.println(i + 1 + ": " + dice[i].toString());
                    }
                    // YATZI
                    if (checkIfYatzi(dice)) {
                        System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
                    } else {
                        // Here we check if there is no Yatzy: then we check what turn we are on and
                        // asks the player if we want to continue or not
                        if (gameTurn != 3) {
                            System.out.println("Want to throw again? (y for yes, anything else for no)");
                            if (sc.next().equals("y")) {
                                ++gameTurn;
                            } else {
                                endGame();
                            }
                        } else {
                            System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
                            if (sc.next().equals("y")) {
                                gameTurn = 1;
                            } else {
                                endGame();
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

    public boolean checkIfYatzi(Die[] dice) {
        boolean isYatzi = true;
        for (int j = 1; j < 5; j++) {
            if (dice[j].getValue() != dice[j - 1].getValue()) {
                isYatzi = false;
            }

        }
        return isYatzi;

    }

    public void endGame() {
        this.isPlaying = false;
        System.exit(0);
    }

}
