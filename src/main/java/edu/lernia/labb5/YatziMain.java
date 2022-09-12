package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {
    public static Die[] dice;
    public static boolean isPlaying = true;

    public static void main(String[] args) {
        int gameTurn = 1;
        dice = new Die[5];
        for (int d = 0; d < 5; d++) {
            dice[d] = new Die();
        }
        // We will continue until the game is over
        while (isPlaying == true) {
            gameTurn = 1;
            System.out.println("Welcome to Yatzi!");
            while (gameTurn < 4) {
                System.out.println("Starting turn " + (gameTurn) + " of 3, rolling dice.");
                for (int i = 0; i < dice.length; i++) {
                    dice[i].rollDie();
                    // dice[i].value = 5; //Test if yatzi work
                    System.out.println(i + 1 + ": " + dice[i].toString());
                }
                // YATZI
                boolean isYatzi = checkIfYatzi(dice);
                if (isYatzi == true) {
                    System.out.println("You got YATZI! in " + dice[0].value + "'s");
                    return;
                } else {
                    // Here we check if there is no Yatzy: then we check what turn we are on and
                    // asks the player if we want to continue or not
                    if (gameTurn != 3) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner sc = new Scanner(System.in);
                        if (sc.next().equals("y")) {
                            ++gameTurn;
                        } else {
                            isPlaying = !isPlaying;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
                        Scanner sc = new Scanner(System.in);
                        if (sc.next().equals("y")) {
                            gameTurn = 1;
                        } else {
                            isPlaying = !isPlaying;
                            break;
                        }
                    }
                }
            }
        }
    }

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