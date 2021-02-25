package org.codingspartan.playingcardsorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PlayingCardSorterTest {

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
    public void test_3Diamonds() {
        List<Card> hand = Arrays.asList(deck.getCard(Card.Value.EIGHT, Card.Color.DIAMONDS), deck.getCard(Card.Value.ACE, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS));

        hand.sort(cardComparator);

        assertHands(Arrays.asList(deck.getCard(Card.Value.ACE, Card.Color.DIAMONDS), deck.getCard(Card.Value.EIGHT, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS)), hand);
    }

    @Test
    public void test_4Jacks() {
        List<Card> hand = Arrays.asList(deck.getCard(Card.Value.JACK, Card.Color.CLUBS), deck.getCard(Card.Value.JACK, Card.Color.HEARTS), deck.getCard(Card.Value.JACK, Card.Color.SPADES), deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS));

        hand.sort(cardComparator);

        assertHands(Arrays.asList(deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.HEARTS), deck.getCard(Card.Value.JACK, Card.Color.SPADES), deck.getCard(Card.Value.JACK, Card.Color.CLUBS)), hand);
    }

    @Test
    public void test_7mixed() {
        List<Card> hand = Arrays.asList(deck.getCard(Card.Value.EIGHT, Card.Color.DIAMONDS), deck.getCard(Card.Value.ACE, Card.Color.DIAMONDS), deck.getCard(Card.Value.NINE, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.CLUBS), deck.getCard(Card.Value.JACK, Card.Color.HEARTS), deck.getCard(Card.Value.JACK, Card.Color.SPADES), deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS));

        hand.sort(cardComparator);

        assertHands(Arrays.asList(deck.getCard(Card.Value.ACE, Card.Color.DIAMONDS), deck.getCard(Card.Value.EIGHT, Card.Color.DIAMONDS), deck.getCard(Card.Value.NINE, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.DIAMONDS), deck.getCard(Card.Value.JACK, Card.Color.HEARTS), deck.getCard(Card.Value.JACK, Card.Color.SPADES), deck.getCard(Card.Value.JACK, Card.Color.CLUBS)), hand);
    }

    private void assertHands(List<Card> expectedHand, List<Card> actualHand) {
        int exceptedSize = expectedHand.size();
        Assertions.assertEquals(exceptedSize, exceptedSize);

        for (int i = 0; i < exceptedSize; i++) {
            Assertions.assertEquals(expectedHand.get(i), actualHand.get(i));
        }
    }

}