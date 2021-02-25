package org.codingspartan.playingcardsorter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardComparator implements Comparator<Card> {

    private final Map<Card, Integer> positions = new HashMap<>();

    public CardComparator(Deck deck, List<Card.Color> colorOrder, List<Card.Value> valueOrder) {
        int position = 0;
        for (Card.Color color : colorOrder) {
            for (Card.Value value : valueOrder) {
                positions.put(deck.getCard(value, color), position);
                position++;
            }
        }
    }

    @Override
    public int compare(Card card1, Card card2) {
        Integer position1 = positions.get(card1);
        Integer position2 = positions.get(card2);

        if (position1 == null) {
            throw new IllegalArgumentException("No position found for first card");
        }
        if (position2 == null) {
            throw new IllegalArgumentException("No position found for second card");
        }

        return position1.compareTo(position2);
    }
}