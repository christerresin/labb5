package edu.lernia.labb5;

import java.util.Scanner;

public class BoardGameMaterial {
    /* Will be used to store all boardgamematerials in one class */
    private Die[] dice;
    private int gameTurn;
    private int maxGameTurns = 4;

    public void startNewGame() {
        isPlaying = true;
        gameTurn = 1;

        dice = new Die[5];
        for (int d = 0; d < dice.length; d++) {
            dice[d] = new Die();
        }

        System.out.println("Welcome to Yatzi!");
        try (Scanner sc = new Scanner(System.in)) {
            while (gameTurn < maxGameTurns) {
                startNewTurn();
                // YATZI
                if (checkIfYatzi(dice)) {
                    System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
                    endGame();
                } else {
                    getUserInput(sc);
                }
            }

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    private void getUserInput(Scanner sc) {
        if (gameTurn != 3) {
            rerollDies(sc);
        } else {
            gameOverOrNewGame(sc);
        }
    }

    private void rerollDies(Scanner sc) {
        System.out.println("Want to throw again? (y for yes, anything else for no)");
        if (sc.next().equals("y")) {
            ++gameTurn;
        } else {
            endGame();
        }
    }

    private void gameOverOrNewGame(Scanner sc) {
        System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
        if (sc.next().equals("y")) {
            gameTurn = 1;
        } else {
            endGame();
        }
    }

    private void startNewTurn() {
        System.out.println("Starting turn " + (gameTurn) + " of 3, rolling dice.");
        for (int i = 0; i < dice.length; i++) {
            dice[i].rollDie(6);
            // dice[i].value = 5; //Test if yatzi work
            System.out.println(i + 1 + ": " + dice[i].toString());
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
        System.exit(0);
    }

}
