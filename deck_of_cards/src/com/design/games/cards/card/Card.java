package com.design.games.cards.card;

public class Card {

    private final CardValue cardValue;

    private final SuitType suitType;

    public Card(CardValue cardValue, SuitType suitType) {
        this.cardValue = cardValue;
        this.suitType = suitType;
    }

    public SuitType getSuitType() {
        return suitType;
    }

    public CardValue getCardValue() {
        return cardValue;
    }
    @Override
    public String toString() {
        return "Card{" +
                "cardValue =" + cardValue +
                ", suitType =" + suitType +
                '}';
    }
}
