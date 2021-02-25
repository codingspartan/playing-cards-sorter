package org.codingspartan.playingcardsorter;

import org.codingspartan.playingcardsorter.Card;
import org.codingspartan.playingcardsorter.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DeckTest {

    @Test
    void test_create52CardsDeck() {
        Deck deck = Deck.create52CardsDeck();

        Assertions.assertEquals(52, deck.size());
    }

    @Test
    void test_shuffle() {
        Deck deck = Deck.create52CardsDeck();
        List<Card> originalOrder = deck.getCards();

        deck.shuffle();

        Assertions.assertNotEquals(originalOrder, deck.getCards());
    }

    @Test
    void test_deal() {
        Deck deck = Deck.create52CardsDeck();
        List<Card> originalOrder = deck.getCards();

        Card card1 = deck.deal();
        Assertions.assertEquals(card1, originalOrder.get(0));

        Card card2 = deck.deal();
        Assertions.assertEquals(card2, originalOrder.get(1));
    }

    @Test
    void test_dealN() {
        Deck deck = Deck.create52CardsDeck();
        List<Card> originalOrder = deck.getCards();
        int nb = 3;
        List<Card> cards = deck.deal(nb);

        Assertions.assertEquals(nb, cards.size());
        Assertions.assertEquals(originalOrder.get(0), originalOrder.get(0));
        Assertions.assertEquals(originalOrder.get(1), originalOrder.get(1));
        Assertions.assertEquals(originalOrder.get(2), originalOrder.get(2));
    }
}