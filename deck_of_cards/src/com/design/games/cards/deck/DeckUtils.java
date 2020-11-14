package com.design.games.cards.deck;

import com.design.games.cards.card.Card;
import com.design.games.cards.card.CardValue;
import com.design.games.cards.card.SuitType;

import java.util.ArrayList;
import java.util.List;

public class DeckUtils {

    public static List<Card> prepareAllCards() {
        List<Card> cards = new ArrayList<>();
        for (SuitType suitType : SuitType.values()) {
            List<Card> suitCards = createCardsOfType(suitType);
            cards.addAll(suitCards);
        }
        return cards;
    }

    private static List<Card>  createCardsOfType(SuitType suitType) {
        List<Card>  suitCards = new ArrayList<>();
        for (CardValue cardValue : CardValue.values()) {
            Card card = new Card(cardValue, suitType);
            suitCards.add(card);
        }
        return suitCards;
    }

}
