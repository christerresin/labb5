package edu.lernia.labb5;

public class Die extends BoardGameMaterial {
    public int value = 0;

    public Die() {
    }

    public int rollDie() {
        value = (int) (Math.random() * 6 + 1);
        return value;
    }

    public int rerollDie() {
        return rollDie();
    }

    @Override
    public String toString() {
        return "Dice shows " + value;
    }
}
