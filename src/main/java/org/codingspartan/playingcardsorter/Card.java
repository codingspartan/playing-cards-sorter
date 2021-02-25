package org.codingspartan.playingcardsorter;

public class Card {

    private final Value value;

    private final Color color;

    public enum Value {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    public enum Color {
        CLUBS,
        DIAMONDS,
        SPADES,
        HEARTS
    }

    public Card(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }

}
