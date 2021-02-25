package org.codingspartan.playingcardsorter;

import java.util.*;

public class Deck {

    private final List<Card> cards = new ArrayList<>();
    private static final Map<Card.Value, Map<Card.Color, Card>> cardByValueAndColor = new HashMap<>();

    private int topCardInDeck = 0;

    private Deck() {
    }

    public static Deck create52CardsDeck() {
        Deck deck = new Deck();
        for (Card.Value value : Card.Value.values()) {
            cardByValueAndColor.put(value, new HashMap<>());
            Map<Card.Color, Card> cardByColor = cardByValueAndColor.get(value);
            for (Card.Color color : Card.Color.values()) {
                Card card = new Card(value, color);
                cardByColor.put(color, card);
                deck.cards.add(card);
            }
        }
        return deck;
    }

    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (topCardInDeck < cards.size()) {
            return cards.get(topCardInDeck++);
        }
        throw new IllegalStateException("Deck is empty !");
    }

    public List<Card> deal(int n) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(deal());
        }
        return cards;
    }

    protected Card getCard(Card.Value value, Card.Color color) {
        return cardByValueAndColor.get(value).get(color);
    }

    protected List<Card> getCards() {
        return new ArrayList<>(cards);
    }

}
