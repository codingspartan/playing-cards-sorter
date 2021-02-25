package org.codingspartan.playingcardsorter;

import org.codingspartan.playingcardsorter.Card;
import org.codingspartan.playingcardsorter.CardComparator;
import org.codingspartan.playingcardsorter.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CardComparatorTest {

    List<Card.Color> colorOrder = Arrays.asList(Card.Color.DIAMONDS, Card.Color.HEARTS, Card.Color.SPADES, Card.Color.CLUBS);

    List<Card.Value> valueOrder = Arrays.asList(
            Card.Value.ACE,
            Card.Value.FIVE,
            Card.Value.TEN,
            Card.Value.EIGHT,
            Card.Value.SIX,
            Card.Value.FIVE,
            Card.Value.SEVEN,
            Card.Value.FOUR,
            Card.Value.TWO,
            Card.Value.THREE,
            Card.Value.NINE,
            Card.Value.QUEEN,
            Card.Value.KING,
            Card.Value.JACK
    );

    Deck deck = Deck.create52CardsDeck();
    CardComparator cardComparator = new CardComparator(deck, colorOrder, valueOrder);

    @Test
    void test_compare_inferior() {
        Card card1 = deck.getCard(Card.Value.ACE, Card.Color.CLUBS);
        Card card2 = deck.getCard(Card.Value.TWO, Card.Color.CLUBS);

        Assertions.assertEquals(-1, cardComparator.compare(card1, card2));
    }

    @Test
    void test_compare_equals() {
        Card card1 = deck.getCard(Card.Value.ACE, Card.Color.CLUBS);
        Card card2 = deck.getCard(Card.Value.ACE, Card.Color.CLUBS);

        Assertions.assertEquals(0, cardComparator.compare(card1, card2));
    }

    @Test
    void test_compare_superior() {
        Card card1 = deck.getCard(Card.Value.THREE, Card.Color.CLUBS);
        Card card2 = deck.getCard(Card.Value.TWO, Card.Color.CLUBS);

        Assertions.assertEquals(1, cardComparator.compare(card1, card2));
    }
}