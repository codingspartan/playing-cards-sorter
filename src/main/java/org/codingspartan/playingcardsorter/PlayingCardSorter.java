package org.codingspartan.playingcardsorter;

import java.util.Arrays;
import java.util.List;


public class PlayingCardSorter {

    public static void main(String[] args) {
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

        deck.shuffle();
        List<Card> hand = deck.deal(10);

        System.out.println("************************** INPUT **************************");
        System.out.println(hand);

        hand.sort(cardComparator);

        System.out.println("************************** OUTPUT **************************");
        System.out.println(hand);

    }

}
