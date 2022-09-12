package edu.lernia.labb5;

public class Die extends BoardGameMaterial {
    private int value = 0;

    public Die() {
    }

    public Die(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public void rollDie() {
        int dieValue = (int) (Math.random() * 6 + 1);
        setValue(dieValue);
    }

    @Override
    public String toString() {
        return "Dice shows " + value;
    }
}
